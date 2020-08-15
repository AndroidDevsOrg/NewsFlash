package com.androiddevs.newsflash.di.modules

import com.androiddevs.newsflash.data.local.shared_preferences.PreferencesHelper
import com.androiddevs.newsflash.data.local.shared_preferences.PreferencesHelperImpl
import com.androiddevs.newsflash.utils.AppDispatchers
import com.androiddevs.newsflash.utils.IDispatchers
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
abstract class CoreBinder {

    @Binds
    abstract fun bindsSharedPreferenceHelper(preferencesHelperImpl: PreferencesHelperImpl): PreferencesHelper

    @Binds
    abstract fun bindsDispatchers(appDispatchers: AppDispatchers): IDispatchers
}