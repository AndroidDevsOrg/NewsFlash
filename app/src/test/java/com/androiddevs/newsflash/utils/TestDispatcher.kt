package com.androiddevs.newsflash.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class TestDispatcher : IDispatchers {
    override val mainDispatchers: CoroutineDispatcher = Dispatchers.Default
    override val ioDispatcher: CoroutineDispatcher = Dispatchers.Default
}