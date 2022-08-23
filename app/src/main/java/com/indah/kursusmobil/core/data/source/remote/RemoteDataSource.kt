package com.indah.kursusmobil.core.data.source.remote

import com.indah.kursusmobil.core.data.source.model.Jadwal
import com.indah.kursusmobil.core.data.source.remote.network.ApiService
import com.indah.kursusmobil.core.data.source.remote.request.CreateKursusRequest
import com.indah.kursusmobil.core.data.source.remote.request.LoginRequest
import com.indah.kursusmobil.core.data.source.remote.request.RegisterRequest
import com.indah.kursusmobil.core.data.source.remote.request.UpdateProfileRequest
import com.indah.kursusmobil.util.getKursusId
import okhttp3.MultipartBody

class RemoteDataSource(private val api: ApiService) {

    suspend fun login(data: LoginRequest) = api.login(data)

    suspend fun register(data: RegisterRequest) = api.register(data)

    suspend fun updateUser(data: UpdateProfileRequest) = api.updateUser(data.id, data)

    suspend fun uploadUser(id: Int? = null, fileImage: MultipartBody.Part? = null) =
        api.uploadUser(id, fileImage)

    suspend fun createToko(data: CreateKursusRequest) = api.createToko(data)

    suspend fun getUser(id: Int? = null) = api.getUser(id)

    suspend fun getJadwal() = api.getJadwal(getKursusId())
    suspend fun createJadwal(data: Jadwal) = api.createJadwal(data)
    suspend fun updateJadwal(data: Jadwal) = api.updateJadwal(data.id, data)
    suspend fun deleteJadwal(id: String?) = api.deleteJadwal(id)

}