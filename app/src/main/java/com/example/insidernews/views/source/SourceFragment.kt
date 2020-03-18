package com.example.insidernews.views.source


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.insidernews.R
import com.example.insidernews.adapters.SourceAdapter
import com.example.insidernews.data.Category
import com.example.insidernews.network.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * A simple [Fragment] subclass.
 */
class SourceFragment : Fragment() {
    private val client by lazy {
        ApiClient.getClient()
    }
    private lateinit var recyclerView: RecyclerView
    private var adapter: SourceAdapter? = null
    private lateinit var sourceList: ArrayList<Category>
    private lateinit var disposable: CompositeDisposable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_source, container, false)
        disposable = CompositeDisposable()
        recyclerView = view.findViewById(R.id.recyclerView)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        fetchCategories()
        return view
    }

    private fun fetchCategories() {
        disposable.add(client.getArticlesSource("technology")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { category->loadCategories(category.sources)},
                this::onError
            ))
    }

    private fun loadCategories(categories: List<Category>) {
        sourceList = ArrayList(categories)
        adapter = SourceAdapter(this.context!!, sourceList)
        recyclerView.adapter = adapter
    }
    private fun onError(e: Throwable){
        e.printStackTrace()
    }
}
