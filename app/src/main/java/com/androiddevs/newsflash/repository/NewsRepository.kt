package com.androiddevs.newsflash.repository

import androidx.lifecycle.LiveData
import com.androiddevs.newsflash.constants.API_KEY
import com.androiddevs.newsflash.data.NewsResult
import com.androiddevs.newsflash.data.TopHeadlinesRequest
import com.androiddevs.newsflash.network.ApiResponse
import com.androiddevs.newsflash.network.ServiceProvider

class NewsRepository {
    private val serviceProvider = ServiceProvider()
    private val newsService by lazy {
        serviceProvider.provideNewsService()
    }

    fun getBusinessNews(topHeadlinesRequest: TopHeadlinesRequest): LiveData<ApiResponse<NewsResult.News>> {
        return newsService.getTopHeadlines(
            topHeadlinesRequest.country,
            topHeadlinesRequest.category,
            topHeadlinesRequest.sources,
            topHeadlinesRequest.keyword,
            topHeadlinesRequest.pageSize,
            topHeadlinesRequest.page,
            API_KEY
        )
    }
}