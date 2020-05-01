package com.example.insidernews.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.insidernews.R
import com.example.insidernews.data.Category
import com.example.insidernews.databinding.SourceCategoryBinding
import kotlinx.android.synthetic.main.source_category.view.*

class SourceAdapter(val context: Context, private val categoryList: List<Category>) :
    RecyclerView.Adapter<SourceAdapter.SourceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = SourceCategoryBinding.inflate(inflater)
        return SourceViewHolder(binding)
    }

    override fun getItemCount() = categoryList.size

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
       val categories = categoryList[position]
        holder.bind(categories)
    }

    class SourceViewHolder(val binding: SourceCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category){
            binding.category = category
            binding.executePendingBindings()
        }
    }

}