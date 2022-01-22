package com.ybdevelopers.newsapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ybdevelopers.newsapplication.data.remote.api.APIInterface
import com.ybdevelopers.newsapplication.model.NewsListResponse
import timber.log.Timber

class APIRepository(private val apiInterface: APIInterface) {

    private val _newsListResponse: MutableLiveData<NewsListResponse> = MutableLiveData()
    val newsListResponse: LiveData<NewsListResponse> get() = _newsListResponse

    suspend fun getNews(apiKey: String) {
        val response = apiInterface.getAllNews("latest",apiKey)
        if (response?.body() != null) {
            _newsListResponse.postValue(response.body())
        }
    }
}