package com.stockbit.repository.di

import com.stockbit.repository.*
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { CryptoRepositoryImpl(get(), get())}
}