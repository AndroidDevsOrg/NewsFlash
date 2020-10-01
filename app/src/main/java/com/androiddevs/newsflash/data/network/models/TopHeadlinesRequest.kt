package com.androiddevs.newsflash.data.network.models

data class TopHeadlinesRequest(
    var country: String? = null,
    var category: String? = null,
    var sources: String? = null,
    var keyword: String? = null,
    var pageSize: Int = 0,
    var page: Int = 0
) {
    companion object {
        fun getDefaultParams(): TopHeadlinesRequest =
            TopHeadlinesRequest("in", pageSize = 10, page = 0)
    }
}