package com.thekalya.insidernews.network

import com.thekalya.insidernews.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object {
        fun getClient(): ApiService {
            val interceptor = Interceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .header("X-Api-Key", "67c24956036d4d539197df1573243782")
//                    ?.addHeader("X-Api-Key", "67c24956036d4d539197df1573243782")
                    ?.addHeader("Content-Type", "application/json")

                    ?.build()
                chain.proceed(request)
            }
            val client = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor(interceptor)
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level =
                        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                })
                .build()
            val gson = GsonBuilder()
                .setLenient()
                .setPrettyPrinting()
                .create()
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .baseUrl(Urls.baseUrl)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}