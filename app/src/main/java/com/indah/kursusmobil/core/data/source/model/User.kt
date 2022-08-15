package com.indah.kursusmobil.core.data.source.model

data class User(
    val email: String?,
    val email_verified_at: Any?,
    val id: Int?,
    val name: String?,
    val image: String?,
    val phone_number: String?,
    val updated_at: String?,
    val created_at: String?,
    var toko: Toko?
)