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

interface ModoDeJuegoService {
    @Multipart
    @POST(ConstantesCustomAPI.CREAR_MODO_DE_JUEGO)
    suspend fun crearModoDeJuego(
        @Part("modoJuego") modoJuegoJson: RequestBody,
        @Part imagen: MultipartBody.Part? = null
    ): Response<ResponseBody>
}