package com.androiddevs.newsflash.data.repository

import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest

interface INewsRepository {
    fun getBusinessNews(topHeadlinesRequest: TopHeadlinesRequest)
}