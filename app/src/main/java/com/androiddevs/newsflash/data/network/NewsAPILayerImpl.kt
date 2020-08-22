package com.androiddevs.newsflash.data.network

import com.androiddevs.newsflash.constants.API_KEY
import com.androiddevs.newsflash.data.network.apiwrapper.Resource
import com.androiddevs.newsflash.data.network.apiwrapper.handleResponse
import com.androiddevs.newsflash.data.network.contract.NewsAPILayer
import com.androiddevs.newsflash.data.network.models.News
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest
import retrofit2.Retrofit
import javax.inject.Inject

class NewsAPILayerImpl @Inject constructor(retrofit: Retrofit) :
    NewsAPILayer {

    private val newsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }

    override suspend fun getBusinessNews(topHeadlinesRequest: TopHeadlinesRequest): Resource<News> {
        return handleResponse {
            newsApiService.getTopHeadlines(
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
}