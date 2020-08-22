package com.androiddevs.newsflash.data.network

import com.androiddevs.newsflash.data.network.models.News
import com.androiddevs.newsflash.data.network.models.Sources
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("sources")
    fun getNewsSources(
        @Query("category") category: String, @Query("language") language: String,
        @Query("country") country: String
    ): Sources

    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("sources") sources: String?,
        @Query("q") keyword: String?,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String?
    ): News

    @GET("everything")
    fun getEverything(
        @Query("q") keyword: String,
        @Query("qInTitle") keyWordInArtcile: String,
        @Query("sources") sources: String,
        @Query("domains") domain: String,
        @Query("excludeDomains") excludeDomains: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("language") language: String,
        @Query("sortBy") sortBy: String,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    ): News

}