package com.androiddevs.newsflash.network

import retrofit2.Call
import retrofit2.Response

class ApiResponse<T> {

    var code: Int = 0
    var body: T?
    var errorMessage: String? = null
    var shouldShowRetryButton: Boolean = false
    private var retrofitCall: Call<T>

    constructor(error: Throwable, call: Call<T>) {
        code = 500
        body = null
        errorMessage = error.message
        shouldShowRetryButton = true
        this.retrofitCall = call
    }

    constructor(response: Response<T>, call: Call<T>) {
        this.retrofitCall = call
        code = response.code()
        if (response.isSuccessful) {
            body = response.body()
        } else {
            shouldShowRetryButton = true
            var message: String? = null
            response.errorBody()?.let {
                message = it.string()
            }
            if (message.isNullOrEmpty()) {
                message = response.message()
            }
            errorMessage = message
            body = null
        }
    }
}