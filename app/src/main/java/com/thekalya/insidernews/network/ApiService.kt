package com.thekalya.insidernews.network

import com.thekalya.insidernews.data.BaseResponse
import com.thekalya.insidernews.data.SourceResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Enock on 2/21/20.
 */

interface ApiService {
    @GET("everything")
    fun getALlArticles(
        @Query("q") query: String
    ): Observable<BaseResponse>

    @GET("everything")
    fun getArticlesInCategory(
        @Query("domains") domains: String,
        @Query("q") query: String
    ): Observable<BaseResponse>

    @GET("sources")
    fun getArticlesSource(
        @Query("category") category: String
    ): Observable<SourceResponse>

}
