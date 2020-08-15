package com.androiddevs.newsflash.data.network.apiwrapper

suspend fun <T> handleResponse(apiBlock: suspend () -> T): Response<T> {
    return try {
        val response = apiBlock()
        if (response != null) {
            Response.success(response)
        } else {
            Response.error("Something went wrong. Please try again later")
        }
    } catch (exception: java.lang.Exception) {
        Response.error("Something went wrong. Please try again later", exception)
    }
}

data class Response<T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null,
    val errorException: Exception? = null
) {

    companion object {
        fun <T> success(data: T?): Response<T> {
            return Response(Status.SUCCESS, data)
        }

        fun <T> error(errorMessage: String? = null, exception: Exception? = null): Response<T> {
            return Response(Status.ERROR, message = errorMessage, errorException = exception)
        }
    }
}

enum class Status {
    SUCCESS, ERROR
}
