package com.example.insidernews.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by cheruiyot
 * On 30,April,2020
 */
@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, imgUrl: String){
    Glide.with(imageView.context)
        .load(imgUrl)
        .into(imageView)
}