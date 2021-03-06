package com.thekalya.insidernews.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thekalya.insidernews.GeneralResponse
import com.thekalya.insidernews.data.Articles
import com.thekalya.insidernews.network.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by cheruiyot
 * On 27,April,2020
 */
class HomeViewModel : ViewModel() {
    private val client by lazy {
        ApiClient.getClient()
    }

    private val status = MutableLiveData<GeneralResponse>()
    var articles = MutableLiveData<List<Articles>>()

    val navigateToArticle = MutableLiveData<Articles>()


    private var disposable = CompositeDisposable()

    init {
        fetchArticles()
    }

    private fun fetchArticles() {
        disposable.add(client.getALlArticles("technology")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    status.value = GeneralResponse.SUCCESS
                    articles.value = result.articles
                },
                {
                    this::onError
                    status.value = GeneralResponse.ERROR
                }
            )
        )
    }


    private fun onError(e: Throwable) {
        e.printStackTrace()
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
        Log.i("HomeViewModel", "HomeViewModel is cleared")
    }
}