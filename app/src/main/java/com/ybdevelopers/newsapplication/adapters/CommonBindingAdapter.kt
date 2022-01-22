package com.ybdevelopers.newsapplication.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.ybdevelopers.newsapplication.R

class CommonBindingAdapter {
    companion object {

        @BindingAdapter("setImage")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String) {
            if (imageUrl.isNotEmpty())
                Picasso.get().load(imageUrl).into(view)
            else
                Picasso.get().load(R.drawable.bharat_agri).into(view)
        }
    }
}