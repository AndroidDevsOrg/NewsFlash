package com.androiddevs.newsflash.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import javax.inject.Inject


@ExperimentalCoroutinesApi
class TestDispatcher @Inject constructor() : DispatcherProvider {
    override val mainDispatchers: CoroutineDispatcher = TestCoroutineDispatcher()
    override val ioDispatcher: CoroutineDispatcher = TestCoroutineDispatcher()
}