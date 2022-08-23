package com.indah.kursusmobil.util

import com.chibatching.kotpref.KotprefModel
import com.indah.kursusmobil.core.data.source.model.User
import com.inyongtisto.myhelper.extension.toJson
import com.inyongtisto.myhelper.extension.toModel

object Prefs : KotprefModel() {

    var isLogin by booleanPref(false)
    var user by stringPref()

    fun setUser(data: User?) {
        user = data.toJson()
    }

    fun getUser(): User? {
        if (user.isEmpty()) return null
        return user.toModel(User::class.java)
    }
}

fun getKursusId() = Prefs.getUser()?.toko?.id


