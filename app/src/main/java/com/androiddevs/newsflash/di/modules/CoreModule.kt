package com.androiddevs.newsflash.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [APIBinder::class])
class CoreModule {

    companion object {
        const val PREF_NAME = "com.androiddevs.newsflash"
        const val BASE_URL = "com.androiddevs.newsflash"
    }

    @Singleton
    @Provides
    fun providesSharedPreferences(context: Application): SharedPreferences =
        context.applicationContext.getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )

}