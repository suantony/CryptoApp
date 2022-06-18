package com.stockbit.hiring.di

import com.stockbit.hiring.ui.home.watchlist.WatchListViewModel
import com.stockbit.hiring.ui.login.LoginViewModel
import com.stockbit.local.di.localModule
import com.stockbit.remote.di.createRemoteModule
import com.stockbit.repository.di.repositoryModule
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel() }
    viewModel { WatchListViewModel(get()) }
}

val appComponent =
    listOf (
        createRemoteModule("https://min-api.cryptocompare.com/"),
        localModule,
        repositoryModule,
        viewModelModule
    )