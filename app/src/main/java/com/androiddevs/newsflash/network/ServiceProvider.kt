package com.androiddevs.newsflash.network

class ServiceProvider {

    fun provideQuizService(): NewsApiService = ApiClient.getNetworkClient().create(NewsApiService::class.java)
}