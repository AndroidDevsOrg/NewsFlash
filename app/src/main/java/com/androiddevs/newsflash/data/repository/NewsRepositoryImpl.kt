package com.androiddevs.newsflash.data.repository

import com.androiddevs.newsflash.data.network.apiwrapper.Resource
import com.androiddevs.newsflash.data.network.apiwrapper.Status
import com.androiddevs.newsflash.data.network.contract.NewsAPILayer
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest
import com.androiddevs.newsflash.data.repository.contract.NewsRepository
import com.androiddevs.newsflash.data.repository.mapper.toNewsArticle
import com.androiddevs.newsflash.data.repository.models.NewsArticle
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val apiLayer: NewsAPILayer) :
    NewsRepository {
    override suspend fun getBusinessNews(topHeadlinesRequest: TopHeadlinesRequest): Resource<List<NewsArticle>> {
        val response = apiLayer.getBusinessNews(topHeadlinesRequest)
        if (response.status == Status.SUCCESS) {
            response.data?.let {
                val articles = it.articles.map { it.toNewsArticle() }
                return Resource.success(articles)
            } ?: run {
                return Resource.getDefaultError()
            }
        } else {
            return Resource.error(response.message, response.errorException)
        }
    }
}