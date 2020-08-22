package com.androiddevs.newsflash.data.repository.fakes

import com.androiddevs.newsflash.data.network.apiwrapper.Resource
import com.androiddevs.newsflash.data.network.apiwrapper.Status
import com.androiddevs.newsflash.data.network.contract.NewsAPILayer
import com.androiddevs.newsflash.data.network.models.News
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest
import com.androiddevs.newsflash.utils.TestableAPIStatus
import com.androiddevs.newsflash.utils.loadModelFromResource

class FakeNewsAPILayerImpl : NewsAPILayer, TestableAPIStatus {

    override var apiStatus = Status.SUCCESS
    private val successResponsePath = "news_top_headline_response/success_response.json"


    override suspend fun getBusinessNews(topHeadlinesRequest: TopHeadlinesRequest): Resource<News> {
        return if (apiStatus == Status.SUCCESS) {
            val response =
                loadModelFromResource<News>(
                    ClassLoader.getSystemClassLoader(),
                    successResponsePath
                )
            Resource.success(response)
        } else {
            Resource.error("Something went wrong. Please try again later", null)
        }

    }
}