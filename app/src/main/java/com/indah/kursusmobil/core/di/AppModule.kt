package com.indah.kursusmobil.core.di

import com.indah.kursusmobil.core.data.source.local.LocalDataSource
import com.indah.kursusmobil.core.data.source.remote.RemoteDataSource
import com.indah.kursusmobil.core.data.source.remote.network.ApiConfig
import org.koin.dsl.module

val appModule = module {
    single { ApiConfig.provideApiService }

    single { RemoteDataSource(get()) }

    single { LocalDataSource() }
}