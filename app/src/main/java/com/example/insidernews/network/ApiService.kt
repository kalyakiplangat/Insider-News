package com.example.insidernews.network

import com.example.insidernews.data.Articles
import com.example.insidernews.data.BaseResponse
import com.example.insidernews.data.SourceResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Enock on 2/21/20.
 */

interface ApiService {
    @GET("everything")
    fun getALlArticles(@Query("query") query: String
    ): Observable<BaseResponse>

    @GET("everything")
    fun getArticlesInCategory(
        @Query("domains") domains: String,
        @Query("query") query: String
    ): Observable<BaseResponse>

    @GET("source")
    fun getArticlesSource(
        @Query("category") category: String
    ): Observable<List<SourceResponse>>

}
