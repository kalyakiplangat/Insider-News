package com.example.insidernews.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.insidernews.R
import com.example.insidernews.data.Source

class SourceAdapter(val context: Context, private val sourceList: List<Source>): RecyclerView.Adapter<SourceAdapter.SourceViewHolder> (){


    class SourceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_articles, parent, false)
        return SourceViewHolder(view)
    }
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}