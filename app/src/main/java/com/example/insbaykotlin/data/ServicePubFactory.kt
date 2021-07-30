package com.example.insbaykotlin.data

import com.example.insbaykotlin.BuildConfig
import com.example.insbaykotlin.common.util.CommonUtil
import com.example.insbaykotlin.data.model.AnonymousModel
import com.example.insbaykotlin.common.Api
import com.google.gson.GsonBuilder
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface ServicePubFactory {

    companion object {
        private const val REQUEST_TIMEOUT = 30L

        fun create(BASE_URL: String): ServicePubFactory {
            val okHttpClientBuilder = OkHttpClient.Builder()
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .apply {
                            CommonUtil.getDeviceToken().also { token ->
                                addHeader("Authorization", "Bearer $token")
                            }
                        }
                        .build()
                    chain.proceed(newRequest)
                }
            if (BuildConfig.DEBUG) {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
            }

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClientBuilder.build())
                .build()

            return retrofit.create(ServicePubFactory::class.java)
        }
    }

    @FormUrlEncoded
    @POST(Api.GET_ANONYMOUS_TOKEN)
    fun getAnonymousToken(@FieldMap params: HashMap<String, String>): Single<AnonymousModel>
}