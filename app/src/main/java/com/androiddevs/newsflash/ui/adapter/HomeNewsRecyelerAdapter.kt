package com.androiddevs.newsflash.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.androiddevs.newsflash.R
import com.androiddevs.newsflash.data.network.models.News
import com.androiddevs.newsflash.databinding.HomeNewsRowBinding


class HomeNewsRecyclerAdapter(private var newsList: ArrayList<News.Article>) :
    RecyclerView.Adapter<HomeNewsRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val homeNewsRowBinding: HomeNewsRowBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.home_news_row,
            parent,
            false
        )

        return ViewHolder(homeNewsRowBinding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsArticle = newsList[position]
        holder.bind(newsArticle)
    }

    class ViewHolder(val binding: HomeNewsRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(obj: News.Article) {
            binding.setVariable(com.androiddevs.newsflash.BR.news, obj)
        }

    }
}