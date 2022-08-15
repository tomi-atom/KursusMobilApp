package com.indah.kursusmobil.core.di

import com.indah.kursusmobil.ui.alamatToko.AlamatTokoViewModel
import com.indah.kursusmobil.ui.auth.AuthViewModel
import com.indah.kursusmobil.ui.navigation.NavViewModel
import com.indah.kursusmobil.ui.toko.TokoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AuthViewModel(get()) }
    viewModel { TokoViewModel(get()) }
    viewModel { NavViewModel(get()) }
    viewModel { AlamatTokoViewModel(get()) }
}