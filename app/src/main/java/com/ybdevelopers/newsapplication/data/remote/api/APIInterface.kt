package com.ybdevelopers.newsapplication.data.remote.api

import com.ybdevelopers.newsapplication.model.NewsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("v2/everything?domains=wsj.com&apiKey=6f1db500af9b43f8b03d660789d2721c")
    suspend fun getAllNews(): Response<NewsListResponse>
}