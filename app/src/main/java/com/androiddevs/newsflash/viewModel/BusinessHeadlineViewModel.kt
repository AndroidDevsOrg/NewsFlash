package com.androiddevs.newsflash.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.androiddevs.newsflash.data.NewsSources
import com.androiddevs.newsflash.network.ApiResponse
import com.androiddevs.newsflash.repository.NewsRepository

class BusinessHeadlineViewModel: ViewModel() {

    private var newsRepository = NewsRepository()

    private fun getBusinessNews(): LiveData<ApiResponse<NewsSources>> {
        newsRepository
    }
}