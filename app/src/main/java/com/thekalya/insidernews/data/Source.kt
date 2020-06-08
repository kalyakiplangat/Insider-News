package com.thekalya.insidernews.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Enock on 2/24/20.
 */
data class Source(
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String
):Serializable