package com.androiddevs.newsflash.di.components

import com.androiddevs.newsflash.data.repository.NewsRepositoryImplTest
import com.androiddevs.newsflash.di.modules.FakeAppBinders
import com.androiddevs.newsflash.ui.viewModel.HomeFragmentViewModelTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FakeAppBinders::class])
interface FakeAppComponent {
    fun inject(homeFragmentViewModelTest: HomeFragmentViewModelTest)
    fun inject(homeFragmentViewModelTest: NewsRepositoryImplTest)

    companion object {

    }
}