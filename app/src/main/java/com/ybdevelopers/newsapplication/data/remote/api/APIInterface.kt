package com.ybdevelopers.newsapplication.data.remote.api

import com.ybdevelopers.newsapplication.model.NewsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("v2/everything")
    suspend fun getAllNews(
        @Query("q") q: String,
        @Query("apiKey") apiKey: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): Response<NewsListResponse>
}