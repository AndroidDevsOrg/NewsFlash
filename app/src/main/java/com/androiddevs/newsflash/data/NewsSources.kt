package com.androiddevs.newsflash.data

object NewsSources
{

    data class Sources(
        val status: String? = null,
        val sources: List<Source> = listOf()
    )
    {
        data class Source(
            val id: String? = null,
            val name: String? = null,
            val description: String? = null,
            val url: String? = null,
            val category: String? = null,
            val language: String? = null,
            val country: String? = null
        )
    }
}