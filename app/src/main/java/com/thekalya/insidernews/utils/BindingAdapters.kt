package com.thekalya.insidernews.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thekalya.insidernews.R

/**
 * Created by cheruiyot
 * On 30,April,2020
 */
@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, imgUrl: String){
    Glide.with(imageView.context)
        .load(imgUrl)
        .apply(RequestOptions()
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image))
        .into(imageView)
}