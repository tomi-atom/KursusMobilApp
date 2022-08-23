package com.indah.kursusmobil.core.data.source.model

data class Kursus(
    val id: Int? = null,
    val id_peserta: String?,
    val biaya: Int?,
    val jemput: Boolean = false,
    val biaya_jemput: Int?,
    val sim: Boolean = false,
    val biaya_sim: Int?,
    val diskon: Int?,
    val status: String?,
    val name: String? = null,
    val image: String? = null,
    val kota: String? = null,

)