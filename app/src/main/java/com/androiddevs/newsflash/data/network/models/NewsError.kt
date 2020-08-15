package com.androiddevs.newsflash.data.network.models

object NewsError {
    data class Error(
        val status: String? = null,
        val code: String? = null,
        val message: String? = null
    )
}