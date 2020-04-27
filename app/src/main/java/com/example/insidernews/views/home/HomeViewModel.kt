package com.example.insidernews.views.home

import androidx.lifecycle.ViewModel
import com.example.insidernews.adapters.ArticlesAdapter
import com.example.insidernews.data.Articles
import com.example.insidernews.network.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by cheruiyot
 * On 27,April,2020
 */
class HomeViewModel: ViewModel() {
    private val client by lazy {
        ApiClient.getClient()
    }
    private lateinit var articlesAdapter: ArticlesAdapter
    private lateinit var articleList: List<Articles>
    private var disposable = CompositeDisposable()

    init {
        fetchArticles()
    }

    private fun fetchArticles() {
        disposable.add(client.getALlArticles("technology")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {articles->
                    handleResponse(articles.articles)
                },
                this::onError))
    }
    private fun handleResponse(articles: List<Articles>) {
//        articleList = ArrayList(articles)
//        articlesAdapter = ArticlesAdapter(this.context!!, articleList)

    }

    private fun onError(e: Throwable){
        e.printStackTrace()
    }
}