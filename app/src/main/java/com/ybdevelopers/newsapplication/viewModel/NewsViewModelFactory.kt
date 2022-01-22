package com.ybdevelopers.newsapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ybdevelopers.newsapplication.repository.APIRepository

class NewsViewModelFactory(private val apiRepository: APIRepository, private val apiKey: String) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(apiRepository, apiKey) as T
    }

}