package com.example.insidernews.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.insidernews.data.Articles
import com.example.insidernews.databinding.ListArticlesBinding

/**
 * Created by Enock on 2/24/20.
 */
class ArticlesAdapter(var context: Context, private val articlesList: List<Articles>) :
    RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ListArticlesBinding.inflate(inflater)
        return ArticlesViewHolder(binding)
    }

    override fun getItemCount() = articlesList.size

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val article = articlesList[position]
        holder.bind(article)
    }

    class ArticlesViewHolder(private var binding: ListArticlesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(articles: Articles) {
            binding.article = articles
            binding.executePendingBindings()
        }
    }

}