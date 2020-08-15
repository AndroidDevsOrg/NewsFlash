package com.androiddevs.newsflash.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class AppDispatchers @Inject constructor() : IDispatchers {
    override val mainDispatchers: CoroutineDispatcher = Dispatchers.Main
    override val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
}

interface IDispatchers {
    val mainDispatchers: CoroutineDispatcher
    val ioDispatcher: CoroutineDispatcher
}
