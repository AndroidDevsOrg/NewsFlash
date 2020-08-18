package com.androiddevs.newsflash.data.repository

import com.androiddevs.newsflash.data.network.NewsAPILayerImpl
import com.androiddevs.newsflash.data.network.apiwrapper.Status
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest
import com.androiddevs.newsflash.di.components.DaggerFakeAppComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import javax.inject.Inject

@ExperimentalCoroutinesApi
class NewsRepositoryImplTest {

    @Inject
    lateinit var fakeAPILayer: NewsAPILayerImpl

    private val repository by lazy { NewsRepositoryImpl(fakeAPILayer) }

    private val headlinesRequest = TopHeadlinesRequest("in")

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        DaggerFakeAppComponent.create().apply {
            inject(this@NewsRepositoryImplTest)
        }
    }

    @Test
    fun `when a successful request is made, repository should return proper values`() =
        runBlockingTest {
            val response = repository.getBusinessNews(headlinesRequest)
            assert(response.data != null)
        }

    @Test
    fun `when the api is unsuccessful, repository should return proper error message`() =
        runBlockingTest {
            fakeAPILayer.apiStatus = Status.ERROR
            val response = repository.getBusinessNews(headlinesRequest)
            assert(response.message!!.isNotEmpty())
        }
}

