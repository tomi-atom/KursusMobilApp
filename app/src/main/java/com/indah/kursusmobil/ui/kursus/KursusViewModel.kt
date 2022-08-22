package com.indah.kursusmobil.ui.kursus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.indah.kursusmobil.core.data.source.remote.request.CreateKursusRequest

class KursusViewModel(val repo: com.indah.kursusmobil.core.data.repository.AppRepository) : ViewModel() {
    fun createToko(data: CreateKursusRequest) = repo.createToko(data).asLiveData()
}