package com.androiddevs.newsflash.di.components

import android.app.Application
import com.androiddevs.newsflash.di.modules.CoreBinder
import com.androiddevs.newsflash.di.modules.CoreModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [CoreBinder::class, CoreModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}