package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ClanService {
    @Multipart
    @POST(ConstantesCustomAPI.CREAR_CLAN)
    suspend fun crearClan(
        @Part imagen: MultipartBody.Part?,
        @Part("nombre") nombre: RequestBody,
        @Part("descripcion") descripcion: RequestBody,
        @Part("ubicacion") ubicacion: RequestBody,
        @Part("idLider") idLider: RequestBody
    ): Response<ResponseBody>
}