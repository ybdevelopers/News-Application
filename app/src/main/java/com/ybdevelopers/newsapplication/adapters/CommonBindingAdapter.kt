package com.ybdevelopers.newsapplication.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class CommonBindingAdapter {
    companion object {

        @BindingAdapter("setImage")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String) {
            if (imageUrl.isNotEmpty())
                Picasso.get().load(imageUrl).into(view)
        }
    }
}