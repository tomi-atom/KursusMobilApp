package com.indah.kursusmobil.ui.toko

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.indah.kursusmobil.core.data.source.remote.request.CreateTokoRequest

class TokoViewModel(val repo: com.indah.kursusmobil.core.data.repository.AppRepository) : ViewModel() {
    fun createToko(data: CreateTokoRequest) = repo.createToko(data).asLiveData()
}