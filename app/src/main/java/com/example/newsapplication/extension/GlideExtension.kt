package com.example.newsapplication.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(url: String?) {
    Glide.with(this)
        .load(url)
        .apply(RequestOptions.placeholderOf(android.R.drawable.ic_delete).error(android.R.drawable.ic_delete))
        .centerCrop().into(this)
}