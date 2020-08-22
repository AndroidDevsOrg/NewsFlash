package com.androiddevs.newsflash.data.network.models

data class News(
    val status: String? = null,
    val totalResults: Int = 0,
    val articles: List<Article> = listOf()
) {
    data class Article(
        val source: Source? = null,
        val author: String,
        val title: String,
        val description: String,
        val url: String,
        val urlToImage: String,
        val publishedAt: String? = null,
        val content: String? = null
    ) {
        data class Source(
            val id: String? = null,
            val name: String? = null
        )
    }
}