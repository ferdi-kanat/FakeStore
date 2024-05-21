package com.ferdikanat.fakestore.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.downloadImage(url: String) {
    Glide.with(this.context)
        .load(url)
        .into(this)
}