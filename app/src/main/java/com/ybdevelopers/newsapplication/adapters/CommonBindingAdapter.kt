package com.ybdevelopers.newsapplication.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

import com.bumptech.glide.request.RequestOptions
import com.ybdevelopers.newsapplication.R

class CommonBindingAdapter {
    companion object {

        private var options: RequestOptions = RequestOptions()
            .centerInside()
            .placeholder(R.color.purple_200)
            .error(R.color.black)

        @BindingAdapter("setImage")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String) {
            if (imageUrl.isNotEmpty())
                Glide.with(view).load(imageUrl).apply(options).into(view)
        }
    }
}