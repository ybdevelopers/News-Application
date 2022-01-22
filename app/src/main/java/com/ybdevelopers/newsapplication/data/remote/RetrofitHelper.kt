package com.ybdevelopers.newsapplication.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {

    private const val API_BASE_URL = "https://newsapi.org/"

    var logging:HttpLoggingInterceptor = HttpLoggingInterceptor()
    

    var client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()


    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}