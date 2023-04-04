package com.thmanyah.podcast.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.thmanyah.podcast.R

object ImageLoader {

    fun loadImage(activity: Context?, imageView: ImageView?, url: String?) {
        if (url == null ||imageView == null) return
        Glide.with(activity!!)
            .load(url)
            .apply(RequestOptions())
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.logo)
            .into(imageView)
    }
}