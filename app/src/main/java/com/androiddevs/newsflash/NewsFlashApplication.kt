package com.androiddevs.newsflash

import android.app.Application
import com.androiddevs.newsflash.di.CoreInjector
import com.androiddevs.newsflash.di.components.DaggerAppComponent


class NewsFlashApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CoreInjector.injector = DaggerAppComponent.builder()
            .application(this).build()
    }
}