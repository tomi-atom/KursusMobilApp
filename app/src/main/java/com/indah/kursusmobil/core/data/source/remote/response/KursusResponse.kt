package com.indah.kursusmobil.core.data.source.remote.response

data class KursusResponse(
        val id: String? = null,
        val id_peserta: String?,
        val biaya: Int?,
        val jemput: Boolean = false,
        val biaya_jemput: Int?,
        val sim: Boolean = false,
        val biaya_sim: Int?,
        val diskon: Int?,
        val status: String?,
)