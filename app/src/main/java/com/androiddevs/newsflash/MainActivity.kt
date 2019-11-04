package com.androiddevs.newsflash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androiddevs.newsflash.repository.NewsApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity()
{

    val newsApiService by lazy { NewsApiService.create() }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //delete all the code below before making UI

        var disposable: Disposable? = null

        disposable = newsApiService.getNewsSources("science", "en", "us")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                Log.v("success_sources", result.sources[0].description)
            }, { error -> Log.v("error_sources", error.message.toString()) })




        disposable = newsApiService.getTopHeadlines("us", "", "", "", 3, 0)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                Log.v("topnews_success", result.articles[0].description)
            }, { error -> Log.v("topnews_error", error.message.toString()) })

        disposable = newsApiService.getEverything(
            "quantum computer",
            "",
            "",
            "",
            "",
            "",
            "",
            "en",
            "popularity",
            3,
            1
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                    result ->


                for (article in result.articles)
                    Log.v("news ", article.description)

            }, { error -> Log.v("topnews_error", error.message.toString()) })


    }
}
