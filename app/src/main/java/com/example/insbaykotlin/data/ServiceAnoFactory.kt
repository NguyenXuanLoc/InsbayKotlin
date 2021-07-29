package com.example.insbaykotlin.data

import com.example.insbaykotlin.BuildConfig
import com.example.insbaykotlin.data.response.DataResponse
import com.example.task.common.Api
import com.google.gson.GsonBuilder
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import vn.vano.vicall.data.response.BaseResponse
import java.util.concurrent.TimeUnit

interface ServiceAnoFactory {
    companion object {
        private const val REQUEST_TIMEOUT = 15L

        fun create(BASE_URL: String): ServiceAnoFactory {
            val okHttpClientBuilder = OkHttpClient.Builder()
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .addHeader(
                            "Authorization",
                            "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjgyOTk5NjYsImlhdCI6MTYyNzQzNTc4Niwic3ViIjoiLTgzIiwiaXNzIjoiRmJZR1hiTDdtNmhtR1pDVkNHbHVsZUdtRjdiUGpSaHMiLCJtZXRhIjoie1wiaWRcIjogXCItODNcIiwgXCJ1c2VybmFtZVwiOiBcImFub255bW91c1wiLCBcImNvdW50cnlcIjogXCJQTFwiLCBcInVzZXJfdHlwZVwiOiAwfSIsInJvbGUiOiJhbm9ueW1vdXMifQ.DWnh7Y0ZN25uHYwRZjbe2vJEabltGSQvzFSkSTaJjys"
                        )
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

    @GET(Api.SEARCH_PRODUCT)
    fun searchProduct(
        @Query("access_token") token: String,
        @Query("q") q: String,
        @Query("limit") limit: String,
        @Query("user_type") user_type: String,
        @Query("country") country: String
    ): Single<DataResponse>

}