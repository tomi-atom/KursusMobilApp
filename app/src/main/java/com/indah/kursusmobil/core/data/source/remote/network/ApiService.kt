package com.indah.kursusmobil.core.data.source.remote.network

import com.indah.kursusmobil.core.data.source.model.AlamatToko
import com.indah.kursusmobil.core.data.source.model.Jadwal
import com.indah.kursusmobil.core.data.source.remote.request.CreateKursusRequest
import com.indah.kursusmobil.core.data.source.remote.request.LoginRequest
import com.indah.kursusmobil.core.data.source.remote.request.RegisterRequest
import com.indah.kursusmobil.core.data.source.remote.request.UpdateProfileRequest
import com.indah.kursusmobil.core.data.source.remote.response.*
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body login: LoginRequest,
    ): Response<LoginResponse>

    // "https://127.0.0.1:8000/api/register"
    @POST("register")
    suspend fun register(
        @Body data: RegisterRequest
    ): Response<LoginResponse>

    @PUT("update-user/{id}")
    suspend fun updateUser(
        @Path("id") int: Int,
        @Body data: UpdateProfileRequest
    ): Response<LoginResponse>

    @Multipart
    @POST("upload-user/{id}")
    suspend fun uploadUser(
        @Path("id") int: Int? = null,
        @Part data: MultipartBody.Part? = null
    ): Response<LoginResponse>

    @POST("toko")
    suspend fun createToko(
        @Body data: CreateKursusRequest
    ): Response<BaseSingelResponse<TokoResponse>>

    @POST("kursus")
    suspend fun createKursus(
        @Body data: CreateKursusRequest
    ): Response<BaseSingelResponse<KursusResponse>>

    @POST("product")
    suspend fun createProduct(
        @Body data: CreateKursusRequest
    ): Response<BaseSingelResponse<ProductResponse>>

    @GET("toko-user/{id}")
    suspend fun getUser(
        @Path("id") int: Int? = null
    ): Response<LoginResponse>

    @GET("alamat-toko/{id}")
    suspend fun getAlamatToko(
        @Path("id") idToko: Int? = null
    ): Response<BaseListResponse<AlamatToko>>

    @GET("jadwal/{id}")
    suspend fun getJadwal(
        @Path("id") idToko: Int? = null
    ): Response<BaseListResponse<Jadwal>>

    @POST("alamat-toko")
    suspend fun createAlamatToko(
        @Body data: AlamatToko
    ): Response<BaseSingelResponse<AlamatToko>>

    @POST("jadwal")
    suspend fun createJadwal(
        @Body data: Jadwal
    ): Response<BaseSingelResponse<Jadwal>>

    @PUT("alamat-toko/{id}")
    suspend fun updateAlamatToko(
        @Path("id") id: Int? = null,
        @Body data: AlamatToko
    ): Response<BaseSingelResponse<AlamatToko>>

    @PUT("jadwal/{id}")
    suspend fun updateJadwal(
        @Path("id") id: String? = null,
        @Body data: Jadwal
    ): Response<BaseSingelResponse<Jadwal>>

    @DELETE("alamat-toko/{id}")
    suspend fun deleteAlamatToko(
        @Path("id") id: Int? = null
    ): Response<BaseSingelResponse<AlamatToko>>

    @DELETE("jadwal/{id}")
    suspend fun deleteJadwal(
        @Path("id") id: String? = null
    ): Response<BaseSingelResponse<Jadwal>>

}