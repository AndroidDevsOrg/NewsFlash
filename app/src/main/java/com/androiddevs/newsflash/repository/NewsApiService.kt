package com.androiddevs.newsflash.repository


import com.androiddevs.newsflash.BuildConfig
import com.androiddevs.newsflash.data.NewsResult
import com.androiddevs.newsflash.data.NewsSources
import io.reactivex.Observable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface NewsApiService {
    @GET("sources")
    fun getNewsSources(
        @Query("category") category: String,
        @Query("language") language: String,
        @Query("country") country: String
    ): Observable<NewsSources.Sources>

    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("sources") sources: String,
        @Query("q") keyword: String,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    ): Observable<NewsResult.News>

    @GET("everything")
    fun getEverything(
        @Query("q") keyword: String,
        @Query("qInTitle") keyWordInArtcile: String,
        @Query("sources") sources: String,
        @Query("domains") domain: String,
        @Query("excludeDomains") excludeDomains: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("language") language: String,
        @Query("sortBy") sortBy: String,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    ): Observable<NewsResult.News>


    companion object {
        fun create(): NewsApiService {

            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(object : Interceptor {
                    override fun intercept(chain: Interceptor.Chain): Response {
                        val original = chain.request()

                        val request = original.newBuilder()
                            .addHeader("X-Api-Key", BuildConfig.API_KEY)
                            .method(original.method, original.body)
                            .build()

                        return chain.proceed(request)
                    }
                })
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://newsapi.org/v2/")
                .client(okHttpClient)
                .build()

            return retrofit.create(NewsApiService::class.java)
        }

    }

}