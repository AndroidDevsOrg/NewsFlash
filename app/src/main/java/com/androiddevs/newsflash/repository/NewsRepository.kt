package com.androiddevs.newsflash.repository

import androidx.lifecycle.LiveData
import com.androiddevs.newsflash.data.NewsSources
import com.androiddevs.newsflash.network.ApiResponse
import com.androiddevs.newsflash.network.ServiceProvider

class NewsRepository {
    private val serviceProvider = ServiceProvider()
    val newsService by lazy {
        serviceProvider.provideNewsService()
    }
    fun getBusinessNews(): LiveData<ApiResponse<NewsSources>> {
        return newsService.getTopHeadlines()
    }
}