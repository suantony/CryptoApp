package com.stockbit.hiring.ui.home.watchlist

import androidx.lifecycle.asLiveData
import com.stockbit.common.base.BaseViewModel
import com.stockbit.repository.CryptoRepositoryImpl

class WatchListViewModel(cryptoRepositoryImpl : CryptoRepositoryImpl) : BaseViewModel() {

    var cryptoData = cryptoRepositoryImpl.getCryptoData().asLiveData()
}