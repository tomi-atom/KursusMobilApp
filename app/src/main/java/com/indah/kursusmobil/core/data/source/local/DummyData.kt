package com.indah.kursusmobil.core.data.source.local

import com.indah.kursusmobil.R
import com.indah.kursusmobil.core.data.source.model.Category
import com.indah.kursusmobil.core.data.source.model.Product
import com.indah.kursusmobil.core.data.source.model.Slider
import com.indah.kursusmobil.core.data.source.model.Jadwal
import com.indah.kursusmobil.core.data.source.model.Kursus

object DummyData {
    val listCategory = listOf(
            Category(id = "1", name = "Elektronik", image = R.drawable.asset_elektronik),

    )

    val listSlider = listOf(
            Slider(id = "1", name = "Slider1", image = R.drawable.asset_slider1),

    )

    val listProduct = listOf(
            Product(id = "1", name = "OPPO A16 RAM 3/32GB | 13MP TRIPLE CAMERA | FINGERPRINT | 5000mAh - Space Silver", harga = 1859000, pengirirman = "Tangerang", terjual = 150, rating = 5.0, discount = 0, grosir = true, image = R.drawable.asset_produk1),

    )
    val listJadwal = listOf(
        Jadwal(id = "1", id_kursus = "2", id_instruktur = "Instruktur",id_mobil = "Avanza", tanggal = "20-8-2022", jam_mulai = "14.00", jam_akhir = "16.00", status = "Kursus"),

    )
    val listKursus = listOf(
        Kursus(id = "1", id_peserta = "2", biaya = 1500000,jemput = false, biaya_jemput = 0,sim = false, biaya_sim = 0, diskon = 0,status  = "Kursus "),

        )
}