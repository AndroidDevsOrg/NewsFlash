package com.androiddevs.newsflash.data.network.apiwrapper

suspend fun <T> handleResponse(apiBlock: suspend () -> T): Resource<T> {
    return try {
        val response = apiBlock()
        if (response != null) {
            Resource.success(response)
        } else {
            Resource.getDefaultError()
        }
    } catch (exception: java.lang.Exception) {
        Resource.error("Something went wrong. Please try again later", exception)
    }
}

data class Resource<T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null,
    val errorException: Exception? = null
) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data)
        }

        fun <T> error(errorMessage: String? = null, exception: Exception? = null): Resource<T> {
            return Resource(Status.ERROR, message = errorMessage, errorException = exception)
        }

        fun <T> getDefaultError(): Resource<T> {
            return error("Something went wrong. Please try again later")
        }
    }
}

enum class Status {
    SUCCESS, ERROR
}
