package com.androiddevs.newsflash.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevs.newsflash.data.network.apiwrapper.Status
import com.androiddevs.newsflash.data.network.models.TopHeadlinesRequest
import com.androiddevs.newsflash.data.repository.contract.NewsRepository
import com.androiddevs.newsflash.data.repository.models.NewsArticle
import com.androiddevs.newsflash.utils.DispatcherProvider
import kotlinx.coroutines.launch

class HomeFragmentViewModel constructor(
    private val newsRepository: NewsRepository,
    private val appDispatchers: DispatcherProvider
) : ViewModel() {

    private val screenStates: MutableLiveData<HomeScreenStates> =
        MutableLiveData(HomeScreenStates.Loading)

    fun subscribeToUIState(): LiveData<HomeScreenStates> = screenStates

    init {

    }

    fun getTopHeadlines(headlinesRequest: TopHeadlinesRequest) {
        viewModelScope.launch(appDispatchers.ioDispatcher) {
            val response = newsRepository.getBusinessNews(headlinesRequest)
            if (response.status == Status.SUCCESS) {
                response.data?.let {
                    screenStates.postValue(HomeScreenStates.TopHeadlinesReceived(it))
                } ?: kotlin.run {
                    screenStates.postValue(HomeScreenStates.ErrorState)
                }
            } else {
                screenStates.postValue(HomeScreenStates.ErrorState)
            }
        }
    }

}

sealed class HomeScreenStates {
    object Loading : HomeScreenStates()
    object ErrorState : HomeScreenStates()
    data class TopHeadlinesReceived(val articleList: List<NewsArticle>) :
        HomeScreenStates()
}