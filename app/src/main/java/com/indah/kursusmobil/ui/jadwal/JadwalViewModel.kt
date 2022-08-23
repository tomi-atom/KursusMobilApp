package com.indah.kursusmobil.ui.jadwal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.indah.kursusmobil.core.data.source.model.Jadwal

class JadwalViewModel(private val repo: com.indah.kursusmobil.core.data.repository.AppRepository) : ViewModel() {
    fun get() = repo.getJadwal().asLiveData()
    fun create(data: Jadwal) = repo.createJadwal(data).asLiveData()
    fun update(data: Jadwal) = repo.updateJadwal(data).asLiveData()
    fun delete(id: String?) = repo.deleteJadwal(id).asLiveData()
}