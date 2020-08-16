package com.androiddevs.newsflash.data.repository

import com.androiddevs.newsflash.data.network.apiwrapper.Response
import com.androiddevs.newsflash.data.network.apiwrapper.Status
import com.androiddevs.newsflash.data.network.models.NewsResult
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest
import com.androiddevs.newsflash.data.repository.contract.NewsRepository
import javax.inject.Inject

class FakeNewsRepositoryImpl @Inject constructor() : NewsRepository {

    var apiStatus = Status.SUCCESS
    val successResponsePath = "news_top_headline_response/success_response.json"

    override suspend fun getBusinessNews(topHeadlinesRequest: TopHeadlinesRequest): Response<NewsResult.News> {
        return if (apiStatus == Status.SUCCESS) {
            getSuccessResponse()
        } else {
            getErrorResponse()
        }
    }


    fun getSuccessResponse(): Response<NewsResult.News> {
//        val response =
//            loadModelFromResource<NewsResult.News>(ClassLoader.getSystemClassLoader(), successResponsePath)
        return Response.success(NewsResult.News())
    }

    private fun getErrorResponse(): Response<NewsResult.News> {
        return Response.error("", null)
    }

}