package com.ybdevelopers.newsapplication.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.ybdevelopers.newsapplication.R

class CommonBindingAdapter {
    companion object {

        @BindingAdapter("setImage")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String) {
            if (imageUrl.isNotEmpty())
                Glide.with(view.context).load(imageUrl).placeholder(R.drawable.bharat_agri)
                    .into(view)
            else
                Glide.with(view.context).load(R.drawable.bharat_agri).into(view)
        }
    }
}