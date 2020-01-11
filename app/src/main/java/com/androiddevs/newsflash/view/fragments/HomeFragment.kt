package com.androiddevs.newsflash.view.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.androiddevs.newsflash.R
import com.androiddevs.newsflash.data.NewsResult
import com.androiddevs.newsflash.databinding.FragmentHomeBinding
import com.androiddevs.newsflash.databinding.FragmentHomeBinding.inflate
import com.androiddevs.newsflash.databinding.HomeNewsRowBinding
import com.androiddevs.newsflash.repository.NewsApiService
import com.androiddevs.newsflash.view.adapter.HomeNewsRecyelerAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private val newsApiService by lazy { NewsApiService.create() }
    private lateinit var disposable: Disposable
    private lateinit var newsList: ArrayList<NewsResult.News.Article>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeBinding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        newsList = ArrayList()
        disposable = newsApiService.getTopHeadlines("us", "", "", "", 10, 0)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                for (article in result.articles) {
                    newsList.add(article)
                }
                homeRecyclerView.adapter = HomeNewsRecyelerAdapter(newsList)
                homeRecyclerView.layoutManager = LinearLayoutManager(context)
            }, { error -> Log.v("Error", error.message.toString()) })
        return homeBinding.root
    }


}
