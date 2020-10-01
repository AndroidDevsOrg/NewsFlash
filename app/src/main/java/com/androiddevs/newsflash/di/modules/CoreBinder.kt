package com.androiddevs.newsflash.di.modules

import com.androiddevs.newsflash.data.local.shared_preferences.PreferencesHelper
import com.androiddevs.newsflash.data.local.shared_preferences.PreferencesHelperImpl
import com.androiddevs.newsflash.data.network.NewsAPILayerImpl
import com.androiddevs.newsflash.data.network.contract.NewsAPILayer
import com.androiddevs.newsflash.utils.AppDispatchers
import com.androiddevs.newsflash.utils.DispatcherProvider
import dagger.Binds
import dagger.Module


@Module
abstract class CoreBinder {

    @Binds
    abstract fun bindsSharedPreferenceHelper(preferencesHelperImpl: PreferencesHelperImpl): PreferencesHelper

    @Binds
    abstract fun bindsDispatchers(appDispatchers: AppDispatchers): DispatcherProvider

    @Binds
    abstract fun bindsNewsRepo(newsAPILayerImpl: NewsAPILayerImpl): NewsAPILayer
}