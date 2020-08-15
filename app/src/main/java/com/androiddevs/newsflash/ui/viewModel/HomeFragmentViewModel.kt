package com.androiddevs.newsflash.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeFragmentViewModel : ViewModel() {

    private val screenStates: MutableLiveData<HomeScreenStates> =
        MutableLiveData(HomeScreenStates.Loading)

    fun subscribeToUIState(): LiveData<HomeScreenStates> = screenStates
}

sealed class HomeScreenStates {
    object Loading : HomeScreenStates()
}