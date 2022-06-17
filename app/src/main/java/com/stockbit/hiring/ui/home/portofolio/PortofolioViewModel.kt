package com.stockbit.hiring.ui.home.portofolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PortofolioViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Portofolio Fragment"
    }
    val text: LiveData<String> = _text
}