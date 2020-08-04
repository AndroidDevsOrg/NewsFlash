package com.androiddevs.newsflash.network

class ServiceProvider {

    fun provideNewsService(): NewsApiService = ApiClient.getNetworkClient().create(NewsApiService::class.java)
}