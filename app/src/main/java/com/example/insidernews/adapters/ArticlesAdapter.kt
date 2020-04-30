package com.example.insidernews.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.insidernews.R
import com.example.insidernews.data.Articles
import com.example.insidernews.databinding.ListArticlesBinding
import kotlinx.android.synthetic.main.list_articles.view.*

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