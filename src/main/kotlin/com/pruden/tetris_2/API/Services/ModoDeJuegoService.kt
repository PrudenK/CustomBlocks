package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.ModoDeJuegoAPI
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ModoDeJuegoService {
    @Multipart
    @POST(ConstantesCustomAPI.CREAR_MODO_DE_JUEGO)
    suspend fun crearModoDeJuego(
        @Part("modoJuego") modoJuegoJson: RequestBody,
        @Part imagen: MultipartBody.Part? = null
    ): Response<List<ModoDeJuegoAPI>>

    @DELETE(ConstantesCustomAPI.ELIMINAR_MODO_DE_JUEGO)
    suspend fun borrarModoDeJuego(@Path("idJugador") idJugador: Int, @Path("idNumModo") idNumModo: Int)
}