package com.androiddevs.newsflash.data

object NewsError {
    data class Error(
        val status: String? = null,
        val code: String? = null,
        val message: String? = null
    )
}