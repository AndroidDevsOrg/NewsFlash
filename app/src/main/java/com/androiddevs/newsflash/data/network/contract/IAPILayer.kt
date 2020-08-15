package com.androiddevs.newsflash.data.network.contract

import com.androiddevs.newsflash.data.network.apiwrapper.Response
import com.androiddevs.newsflash.data.network.models.NewsResult
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest

interface IAPILayer {

    suspend fun getBusinessNews(topHeadlinesRequest: TopHeadlinesRequest): Response<NewsResult.News>
}