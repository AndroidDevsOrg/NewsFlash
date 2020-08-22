package com.androiddevs.newsflash.ui.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.androiddevs.newsflash.data.network.apiwrapper.Status
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest
import com.androiddevs.newsflash.ui.viewModel.fakes.FakeNewsRepositoryImpl
import com.androiddevs.newsflash.di.components.DaggerFakeAppComponent
import com.androiddevs.newsflash.utils.DispatcherProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import javax.inject.Inject

@ExperimentalCoroutinesApi
class HomeFragmentViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Inject
    lateinit var fakeRepo: FakeNewsRepositoryImpl

    @Inject
    lateinit var testDispatcher: DispatcherProvider

    private val homeFragmentViewModel: HomeFragmentViewModel by lazy {
        HomeFragmentViewModel(fakeRepo, testDispatcher)
    }

    @Mock
    lateinit var observer: Observer<HomeScreenStates>

    private val headlinesRequest = TopHeadlinesRequest("in")

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        DaggerFakeAppComponent.create().apply {
            inject(this@HomeFragmentViewModelTest)
        }
    }

    @Test
    fun `when page is created,default state should be loading`() {
        homeFragmentViewModel.subscribeToUIState().observeForever(observer)
        verify(observer).onChanged(HomeScreenStates.Loading)
    }

    @Test
    fun `when headlines response is success, new state should be pushed`() = runBlockingTest {
        homeFragmentViewModel.subscribeToUIState().observeForever(observer)
        verify(observer).onChanged(HomeScreenStates.Loading)
        homeFragmentViewModel.getTopHeadlines(headlinesRequest)
        verify(observer).onChanged(HomeScreenStates.TopHeadlinesReceived(listOf()))
    }

    @Test
    fun `when headlines response is unsuccessful, error state should be pushed`() =
        runBlockingTest {
            fakeRepo.apiStatus = Status.ERROR
            homeFragmentViewModel.subscribeToUIState().observeForever(observer)
            verify(observer).onChanged(HomeScreenStates.Loading)
            homeFragmentViewModel.getTopHeadlines(headlinesRequest)
            verify(observer).onChanged(HomeScreenStates.ErrorState)
        }
}