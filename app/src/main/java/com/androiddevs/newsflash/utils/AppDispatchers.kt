package com.androiddevs.newsflash.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

interface DispatcherProvider {
    val mainDispatchers: CoroutineDispatcher
    val ioDispatcher: CoroutineDispatcher
}

class AppDispatchers @Inject constructor() : DispatcherProvider {
    override val mainDispatchers: CoroutineDispatcher = Dispatchers.Main
    override val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

}
