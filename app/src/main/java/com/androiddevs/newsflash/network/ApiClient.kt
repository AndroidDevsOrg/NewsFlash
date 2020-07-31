package com.androiddevs.newsflash.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val mRetrofitClient: Retrofit by lazy {
        Retrofit.Builder()
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://newsapi.org/v2/")
            .build()
    }

    fun getNetworkClient(): Retrofit = mRetrofitClient

}