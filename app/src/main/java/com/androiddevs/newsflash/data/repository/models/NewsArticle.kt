package com.androiddevs.newsflash.data.repository.models


data class NewsArticle(
    val sourceName: String,
    val authorName: String = "",
    val articleTitle: String,
    val description: String,
    val articleUrl: String,
    val imageUrl: String,
    val publishedDate: String = ""
)

