package com.ybdevelopers.newsapplication.data.remote

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val newBuilder = request.newBuilder()

        runBlocking {
            newBuilder.build()
        }

        request = newBuilder.build()
        return chain.proceed(request)
    }

}