package com.example.insbaykotlin.data

import com.example.insbaykotlin.BuildConfig
import com.example.insbaykotlin.common.util.PefUtil
import com.example.insbaykotlin.common.Constant
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

interface LoginFactory {

    companion object {
        private const val REQUEST_TIMEOUT = 60L
        fun create(BASE_URL: String = "http://api.onmobi.vn/v1/"): LoginFactory? {
            val okHttpClientBuilder = OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                        .addHeader("authorization", "Bearer xyz")
                        .addHeader("Origin", "http://mobion.vn")
                        .addHeader("Content-Type", "application/json; charset=utf-8")
                        .addHeader("Accept", "*/*")
                        .addHeader("Referer", "http://mobion.vn/u/login")
                        .addHeader("Accept-Encoding", "gzip, deflate")
                        .addHeader("Accept-Language", "vi,en-US;q=0.9,en;q=0.8")
                        .addHeader("Connection", "keep-alive")
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

            return retrofit.create(LoginFactory::class.java)
        }
    }

}