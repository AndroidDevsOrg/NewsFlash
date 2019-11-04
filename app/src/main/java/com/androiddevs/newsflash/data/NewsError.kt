package com.androiddevs.newsflash.data

import com.google.gson.annotations.SerializedName

object NewsError
{
    data class Error(
        @SerializedName("status")
        val status: String,
        @SerializedName("code")
        val code: String,
        @SerializedName("message")
        val message: String
    )
}