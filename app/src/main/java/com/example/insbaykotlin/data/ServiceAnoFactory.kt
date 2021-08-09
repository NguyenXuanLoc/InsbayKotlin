package com.example.insbaykotlin.data

import com.example.insbaykotlin.BuildConfig
import com.example.insbaykotlin.common.Api
import com.example.insbaykotlin.common.Param
import com.example.insbaykotlin.common.util.CommonUtil
import com.example.insbaykotlin.data.response.SearchOutfitsResponse
import com.example.insbaykotlin.data.response.SearchProductResponse
import com.example.insbaykotlin.data.response.SearchTvStarResponse
import com.google.gson.GsonBuilder
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
import java.util.concurrent.TimeUnit

interface ServiceAnoFactory {
    companion object {
        private const val REQUEST_TIMEOUT = 15L

        fun create(BASE_URL: String = "http://insbay.sigma-solutions.vn/ano/"): ServiceAnoFactory {
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

            return retrofit.create(ServiceAnoFactory::class.java)
        }
    }

    @GET(Api.SEARCH_LOOK)
    fun searchLook(
        @Query(Param.USER_TYPE) user_type: String,
        @Query(Param.LIMIT) limit: String,
        @Query(Param.PAGE) page: String,
        @Query(Param.ACCESS_TOKEN) access_token: String,
    ): Single<SearchOutfitsResponse>

    @GET(Api.SEARCH_TV_STAR)
    fun searchTvStar(
        @Query(Param.ACCESS_TOKEN) access_token: String
    ): Single<SearchTvStarResponse>

    @GET(Api.SEARCH_PRODUCT)
    fun searchProduct(@QueryMap map: HashMap<String, String>): Single<SearchProductResponse>

    @GET(Api.SEARCH_ALL)
    fun searchAll(@QueryMap map: HashMap<String, String>): Single<String>
}