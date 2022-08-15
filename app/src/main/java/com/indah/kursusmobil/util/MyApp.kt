package com.indah.kursusmobil.util

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.indah.kursusmobil.core.di.appModule
import com.indah.kursusmobil.core.di.repositoryModule
import com.indah.kursusmobil.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, viewModelModule, repositoryModule))
        }
    }
}