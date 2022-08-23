package com.indah.kursusmobil.core.data.source.remote.response

data class JadwalResponse(
        val id: String? = null,
        val id_kursus: String? = null,
        val id_instruktur: String? = null,
        val id_mobil: String?= null,
        val tanggal: String?= null,
        val jam_mulai: String?= null,
        val jam_akhir: String?= null,
        val status: String?= null,
)