package com.indah.kursusmobil.ui.jadwal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.indah.kursusmobil.core.data.source.model.AlamatToko

class JadwalViewModel(private val repo: com.indah.kursusmobil.core.data.repository.AppRepository) : ViewModel() {
    fun get() = repo.getAlamatToko().asLiveData()
    fun create(data: AlamatToko) = repo.createAlamatToko(data).asLiveData()
    fun update(data: AlamatToko) = repo.updateAlamatToko(data).asLiveData()
    fun delete(id: Int?) = repo.deleteAlamatToko(id).asLiveData()
}