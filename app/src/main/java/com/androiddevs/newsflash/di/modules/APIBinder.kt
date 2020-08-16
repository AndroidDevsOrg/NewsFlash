package com.androiddevs.newsflash.di.modules

import com.androiddevs.newsflash.data.network.NewsAPILayerImpl
import com.androiddevs.newsflash.data.network.contract.NewsAPILayer
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module(includes = [APIBinder.APIModule::class])
abstract class APIBinder {

    companion object {
        const val PREF_NAME = "com.androiddevs.newsflash"
        const val BASE_URL = "https://newsapi.org/v2/"
    }

    @Binds
    abstract fun bindsAPILayer(newsApiLayerImpl: NewsAPILayerImpl): NewsAPILayer

    @Module
    internal object APIModule {
        @Provides
        fun provideRetrofitInstance(gsonConverterFactory: GsonConverterFactory): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build()


        @Provides
        fun providesGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()
    }
}