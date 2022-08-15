package com.indah.kursusmobil.core.data.source.remote.request

data class RegisterRequest(
    val name: String,
    val email: String,
    val phone_number: String,
    val password: String
)