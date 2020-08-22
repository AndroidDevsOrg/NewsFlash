package com.androiddevs.newsflash.data.repository.mapper

import com.androiddevs.newsflash.data.network.models.News
import com.androiddevs.newsflash.data.repository.models.NewsArticle

fun News.Article.toNewsArticle(): NewsArticle {
    return NewsArticle(
        source?.name ?: "",
        author,
        title,
        description,
        url,
        urlToImage,
        publishedAt ?: ""
    )
}