package com.androiddevs.newsflash.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.androiddevs.newsflash.R
import com.androiddevs.newsflash.data.NewsResult
import com.androiddevs.newsflash.databinding.HomeNewsRowBinding
import com.bumptech.glide.Glide

class HomeNewsRecyelerAdapter(private var newsList: ArrayList<NewsResult.News.Article>) :
    RecyclerView.Adapter<HomeNewsRecyelerAdapter.ViewHolder>() {

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

        Glide.with(holder.itemView.context)
            .load(newsArticle.urlToImage)
            .into(holder.image)
    }

    class ViewHolder(binding: HomeNewsRowBinding) : RecyclerView.ViewHolder(binding.root) {
        private var binding: HomeNewsRowBinding? = binding

        val image: ImageView = binding.image

        fun bind(obj: NewsResult.News.Article) {
            binding!!.setVariable(com.androiddevs.newsflash.BR.news, obj)
        }

    }
}