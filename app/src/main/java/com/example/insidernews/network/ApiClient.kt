package com.example.insidernews.network

import com.example.insidernews.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Enock on 2/21/20.
 */
class ApiClient {
    companion object{
        fun create(): ApiService{
            val interceptor= Interceptor{ chain ->
                val request=
                    chain.request().newBuilder().addHeader("Accept","application/json")?.addHeader("Content-Type","application/json")?.addHeader("X-Api-Key","67c24956036d4d539197df1573243782")?.build()
                chain.proceed(request)
            }
            val client= OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor(interceptor)
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level=if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                })
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(Urls.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }

    }

}