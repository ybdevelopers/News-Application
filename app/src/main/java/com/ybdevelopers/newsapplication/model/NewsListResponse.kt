package com.ybdevelopers.newsapplication.model

data class NewsListResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)