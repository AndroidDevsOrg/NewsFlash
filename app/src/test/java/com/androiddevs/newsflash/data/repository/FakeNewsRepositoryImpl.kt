package com.androiddevs.newsflash.data.repository

import com.androiddevs.newsflash.data.network.apiwrapper.Response
import com.androiddevs.newsflash.data.network.apiwrapper.Status
import com.androiddevs.newsflash.data.network.models.NewsResult
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest
import com.androiddevs.newsflash.data.repository.contract.NewsRepository
import com.androiddevs.newsflash.utils.TestableAPIStatus
import javax.inject.Inject

class FakeNewsRepositoryImpl @Inject constructor() : NewsRepository, TestableAPIStatus {

    override var apiStatus = Status.SUCCESS


    override suspend fun getBusinessNews(topHeadlinesRequest: TopHeadlinesRequest): Response<NewsResult.News> {
        return if (apiStatus == Status.SUCCESS) {
            getSuccessResponse()
        } else {
            getErrorResponse()
        }
    }


    fun getSuccessResponse(): Response<NewsResult.News> {
        return Response.success(NewsResult.News())
    }

    private fun getErrorResponse(): Response<NewsResult.News> {
        return Response.error("", null)
    }

}