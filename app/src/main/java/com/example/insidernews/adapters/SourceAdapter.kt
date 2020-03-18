package com.example.insidernews.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.insidernews.R
import com.example.insidernews.data.Category
import kotlinx.android.synthetic.main.source_category.view.*

class SourceAdapter(val context: Context, private val categoryList: ArrayList<Category>) :
    RecyclerView.Adapter<SourceAdapter.SourceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.source_category, parent, false)
        return SourceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
        holder.bind(context, categoryList[position], position )
    }

    class SourceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(context: Context, category: Category, position: Int){
            itemView.source_text.text = category.category
            itemView.description_text.text = category.description
            itemView.category_text.text = category.name
        }
    }

}