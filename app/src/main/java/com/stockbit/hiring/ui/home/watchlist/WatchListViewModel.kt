package com.stockbit.hiring.ui.home.watchlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WatchListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is watchlist Fragment"
    }
    val text: LiveData<String> = _text
}