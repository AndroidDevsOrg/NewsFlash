package com.androiddevs.newsflash.data.network

import com.androiddevs.newsflash.constants.API_KEY
import com.androiddevs.newsflash.data.network.apiwrapper.Response
import com.androiddevs.newsflash.data.network.apiwrapper.handleResponse
import com.androiddevs.newsflash.data.network.contract.IAPILayer
import com.androiddevs.newsflash.data.network.models.NewsResult
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest
import retrofit2.Retrofit
import javax.inject.Inject

class APILayer @Inject constructor(retrofit: Retrofit) :
    IAPILayer {

    private val newsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }

    override suspend fun getBusinessNews(topHeadlinesRequest: TopHeadlinesRequest): Response<NewsResult.News> {
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