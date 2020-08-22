package com.androiddevs.newsflash.data.network.contract

import com.androiddevs.newsflash.data.network.apiwrapper.Resource
import com.androiddevs.newsflash.data.network.models.News
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest

interface NewsAPILayer {
    suspend fun getBusinessNews(topHeadlinesRequest: TopHeadlinesRequest): Resource<News>
}