package com.indah.kursusmobil.core.di

import com.indah.kursusmobil.ui.jadwal.JadwalViewModel
import com.indah.kursusmobil.ui.auth.AuthViewModel
import com.indah.kursusmobil.ui.navigation.NavViewModel
import com.indah.kursusmobil.ui.kursus.KursusViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AuthViewModel(get()) }
    viewModel { KursusViewModel(get()) }
    viewModel { NavViewModel(get()) }
    viewModel { JadwalViewModel(get()) }
}