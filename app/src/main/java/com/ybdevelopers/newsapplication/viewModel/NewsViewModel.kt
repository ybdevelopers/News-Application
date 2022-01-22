package com.ybdevelopers.newsapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ybdevelopers.newsapplication.model.NewsListResponse
import com.ybdevelopers.newsapplication.repository.APIRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(private val apiRepository: APIRepository, private val apiKey: String) :
    ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            apiRepository.getNews(apiKey)
        }
    }

    val newsList: LiveData<NewsListResponse> get() = apiRepository.newsListResponse
}