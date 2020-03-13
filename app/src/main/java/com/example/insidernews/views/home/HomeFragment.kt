package com.example.insidernews.views.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.insidernews.R
import com.example.insidernews.adapters.ArticlesAdapter
import com.example.insidernews.data.Articles
import com.example.insidernews.network.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private val client by lazy {
        ApiClient.getClient()
    }

    private lateinit var recyclerView: RecyclerView
    private  var adapter: ArticlesAdapter? = null
    private lateinit var articleList: ArrayList<Articles>
    private lateinit var disposable: CompositeDisposable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_home, container, false)
        disposable = CompositeDisposable()
        recyclerView = rootView.findViewById(R.id.recycler)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        setHasOptionsMenu(true)
        fetchArticles()
        return rootView
    }

    private fun fetchArticles() {
        disposable.add(client.getALlArticles("technology")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {articles->handleResponse(articles.articles)},
                this::onError))
    }

    private fun handleResponse(articles: List<Articles>) {
        articleList = ArrayList(articles)
        adapter = ArticlesAdapter(this.context!!, articleList)
        recyclerView.adapter = adapter
    }

    private fun onError(e: Throwable){
        e.printStackTrace()
    }

}
