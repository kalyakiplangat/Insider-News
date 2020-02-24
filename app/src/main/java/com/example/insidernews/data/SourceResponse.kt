package com.example.insidernews.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Enock on 2/24/20.
 */
data class SourceResponse(
    @SerializedName("sources")
    var sources: List<Category>,
    @SerializedName("status")
    var status: String // ok
)