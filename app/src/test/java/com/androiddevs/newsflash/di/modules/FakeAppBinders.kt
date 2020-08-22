package com.androiddevs.newsflash.di.modules

import com.androiddevs.newsflash.data.repository.fakes.FakeNewsAPILayerImpl
import com.androiddevs.newsflash.ui.viewModel.fakes.FakeNewsRepositoryImpl
import com.androiddevs.newsflash.utils.DispatcherProvider
import com.androiddevs.newsflash.utils.TestDispatcher
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [FakeAppBinders.FakeAppModule::class])
abstract class FakeAppBinders {

    @Binds
    abstract fun bindTestDispatchers(testDispatcher: TestDispatcher): DispatcherProvider


    @Module
    internal object FakeAppModule {

        @Provides
        fun provideFakeRepository(): FakeNewsRepositoryImpl = FakeNewsRepositoryImpl()

        @Provides
        fun provideFakeApiLayer(): FakeNewsAPILayerImpl = FakeNewsAPILayerImpl()
    }

}