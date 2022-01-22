package com.ybdevelopers.newsapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
) : Parcelable