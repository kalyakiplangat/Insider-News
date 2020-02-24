package com.example.insidernews.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Enock on 2/24/20.
 */

data class Articles(
    @SerializedName("author")
    var author: String,
    @SerializedName("content")
    var content: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("publishedAt")
    var publishedAt: String,
    @SerializedName("source")
    var source: Source,
    @SerializedName("title")
    var title: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("urlToImage")
    var urlToImage: String
): Serializable
