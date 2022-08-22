package com.indah.kursusmobil.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.indah.kursusmobil.core.data.source.local.DummyData
import com.indah.kursusmobil.core.data.source.model.Category
import com.indah.kursusmobil.core.data.source.model.Kursus
import com.indah.kursusmobil.core.data.source.model.Product
import com.indah.kursusmobil.core.data.source.model.Slider
import java.util.*

class HomeViewModel : ViewModel() {

    val listKursus: LiveData<List<Kursus>> = MutableLiveData<List<Kursus>>().apply {
        value = DummyData.listKursus
    }


}