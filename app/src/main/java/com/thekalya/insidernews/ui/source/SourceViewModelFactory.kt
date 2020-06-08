package com.thekalya.insidernews.ui.source

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by cheruiyot
 * On 01,May,2020
 */
class SourceViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SourceViewModel::class.java)){
            return SourceViewModel() as T
        }
        throw IllegalArgumentException("unknown viewModel")
    }
}