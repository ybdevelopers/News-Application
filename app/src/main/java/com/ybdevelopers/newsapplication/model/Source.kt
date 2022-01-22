package com.ybdevelopers.newsapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Source(
    val id: String,
    val name: String
) : Parcelable