package com.androiddevs.newsflash.view.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.newsflash.R
import com.androiddevs.newsflash.constants.SUCCESS_CODE
import com.androiddevs.newsflash.data.NewsResult
import com.androiddevs.newsflash.data.TopHeadlinesRequest
import com.androiddevs.newsflash.viewModel.HomeFragmentViewModel

class HomeFragment : Fragment() {

    private val homeFragmentViewModel: HomeFragmentViewModel by lazy {
        ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
    }

    private var articleList: List<NewsResult.News.Article> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_business_headline, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getTopHeadlinesFromNetwork()
    }

    private fun  getTopHeadlinesFromNetwork() {
        homeFragmentViewModel.getTopHeadlines(TopHeadlinesRequest()).observe(this, Observer { apiResponse ->
            if (!apiResponse.shouldShowRetryButton) {
                    apiResponse?.body?.let {
                        articleList = it.articles
                    }
                }
        })
    }

}
