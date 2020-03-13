package com.example.insidernews.adapters

import android.content.Context
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.insidernews.R
import com.example.insidernews.data.Articles
import kotlinx.android.synthetic.main.list_articles.view.*
import java.security.AccessControlContext

/**
 * Created by Enock on 2/24/20.
 */
class ArticlesAdapter(var context: Context, private val articlesList: ArrayList<Articles>): RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_articles, parent, false)
        return ArticlesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.bind(context, articlesList[position], position)
    }

    class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(context: Context, articles: Articles, position: Int){
            Glide.with(context)
                .load(articles.urlToImage)
                .into(itemView.imageView)
            itemView.headline_text.text = articles.title
            itemView.description_text.text = articles.description
            itemView.source_text.text = articles.source.name
            itemView.author_text.text = articles.author
        }
    }

}