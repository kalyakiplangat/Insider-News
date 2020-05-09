package com.example.insidernews.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.insidernews.data.Category
import com.example.insidernews.databinding.SourceCategoryBinding
import com.example.insidernews.views.detailsnews.DetailActivity

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
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("url", categories.url)
            context.startActivity(intent)
        }
    }

    class SourceViewHolder(private val binding: SourceCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category){
            binding.category = category
            binding.executePendingBindings()
        }
    }

}