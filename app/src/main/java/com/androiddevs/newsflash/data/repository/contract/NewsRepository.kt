package com.androiddevs.newsflash.data.repository.contract

import com.androiddevs.newsflash.data.network.apiwrapper.Resource
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest
import com.androiddevs.newsflash.data.repository.models.NewsArticle

interface NewsRepository {
    suspend fun getBusinessNews(topHeadlinesRequest: TopHeadlinesRequest): Resource<List<NewsArticle>>
}