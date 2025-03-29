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

    @GET(ConstantesCustomAPI.MODOS_DE_JUEGO_DE_UN_JUGADOR)
    suspend fun getModosDeJuegoDeUnJugador(@Path("idJugador") idJugador: Int): List<ModoDeJuegoAPI>
}