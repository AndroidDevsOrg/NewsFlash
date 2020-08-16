package com.androiddevs.newsflash.data.repository

import com.androiddevs.newsflash.data.network.apiwrapper.Response
import com.androiddevs.newsflash.data.network.contract.NewsAPILayer
import com.androiddevs.newsflash.data.network.models.NewsResult
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest
import com.androiddevs.newsflash.data.repository.contract.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val apiLayer: NewsAPILayer) :
    NewsRepository {
    override suspend fun getBusinessNews(topHeadlinesRequest: TopHeadlinesRequest): Response<NewsResult.News> {
        return apiLayer.getBusinessNews(topHeadlinesRequest)
    }
}