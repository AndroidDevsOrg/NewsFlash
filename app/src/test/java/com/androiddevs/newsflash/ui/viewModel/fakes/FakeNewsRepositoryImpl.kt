package com.androiddevs.newsflash.ui.viewModel.fakes

import com.androiddevs.newsflash.data.network.apiwrapper.Resource
import com.androiddevs.newsflash.data.network.apiwrapper.Status
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest
import com.androiddevs.newsflash.data.repository.contract.NewsRepository
import com.androiddevs.newsflash.data.repository.models.NewsArticle
import com.androiddevs.newsflash.utils.TestableAPIStatus
import javax.inject.Inject

class FakeNewsRepositoryImpl @Inject constructor() : NewsRepository, TestableAPIStatus {

    override var apiStatus = Status.SUCCESS


    override suspend fun getBusinessNews(topHeadlinesRequest: TopHeadlinesRequest): Resource<List<NewsArticle>> {
        return if (apiStatus == Status.SUCCESS) {
            getSuccessResponse()
        } else {
            getErrorResponse()
        }
    }


    fun getSuccessResponse(): Resource<List<NewsArticle>> {
        return Resource.success(listOf())
    }

    private fun getErrorResponse(): Resource<List<NewsArticle>> {
        return Resource.error("", null)
    }

}