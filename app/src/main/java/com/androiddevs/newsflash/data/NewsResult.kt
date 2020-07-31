package com.androiddevs.newsflash.data

object NewsResult
{

    data class News(
        val status: String? = null,
        val totalResults: Int = 0,
        val articles: List<Article> = listOf()
    )
    {
        data class Article(
            val source: Source? = null,
            val author: String? = null,
            val title: String? = null,
            val description: String? = null,
            val url: String? = null,
            val urlToImage: String? = null,
            val publishedAt: String? = null,
            val content: String? = null
        )
        {
            data class Source(
                val id: String? = null,
                val name: String? = null
            )
        }
    }
}