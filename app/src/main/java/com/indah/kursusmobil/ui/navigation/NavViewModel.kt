package com.indah.kursusmobil.ui.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

class NavViewModel(val repo: com.indah.kursusmobil.core.data.repository.AppRepository) : ViewModel() {
    fun getUser(id: Int) = repo.getUser(id).asLiveData()
}