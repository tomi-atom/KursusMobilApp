package com.indah.kursusmobil.util

fun String?.defaultError(): String {
    return this ?: Constants.DEFALUT_ERROR
}