package com.indah.kursusmobil.core.di

import org.koin.dsl.module

val repositoryModule = module {
    single { com.indah.kursusmobil.core.data.repository.AppRepository(get(), get()) }
}