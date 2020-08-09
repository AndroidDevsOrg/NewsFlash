package com.androiddevs.newsflash.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.androiddevs.newsflash.data.NewsResult
import com.androiddevs.newsflash.data.TopHeadlinesRequest
import com.androiddevs.newsflash.network.ApiResponse
import com.androiddevs.newsflash.repository.NewsRepository

class HomeFragmentViewModel : ViewModel() {

    private var newsRepository = NewsRepository()

    fun getTopHeadlines(topHeadlinesRequest: TopHeadlinesRequest): LiveData<ApiResponse<NewsResult.News>> {
        return newsRepository.getBusinessNews(topHeadlinesRequest)
    }
}