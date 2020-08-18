package com.androiddevs.newsflash.data.network

import com.androiddevs.newsflash.data.network.apiwrapper.Response
import com.androiddevs.newsflash.data.network.apiwrapper.Status
import com.androiddevs.newsflash.data.network.apiwrapper.handleResponse
import com.androiddevs.newsflash.data.network.contract.NewsAPILayer
import com.androiddevs.newsflash.data.network.models.NewsResult
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest
import com.androiddevs.newsflash.utils.TestableAPIStatus
import com.androiddevs.newsflash.utils.loadModelFromResource

class NewsAPILayerImpl : NewsAPILayer, TestableAPIStatus {

    override var apiStatus = Status.SUCCESS
    private val successResponsePath = "news_top_headline_response/success_response.json"


    override suspend fun getBusinessNews(topHeadlinesRequest: TopHeadlinesRequest): Response<NewsResult.News> {
        return if (apiStatus == Status.SUCCESS) {
            val response =
                loadModelFromResource<NewsResult.News>(
                    ClassLoader.getSystemClassLoader(),
                    successResponsePath
                )
            Response.success(response)
        } else {
            Response.error("Something went wrong. Please try again later", null)
        }

    }
}