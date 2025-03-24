package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.LogroJugador
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LogrosService {
    @GET(ConstantesCustomAPI.LOGROS_DEL_JUGADOR)
    suspend fun getLogrosDelJugador(@Path("id") id: Int): List<LogroJugador>

    @POST(ConstantesCustomAPI.COMPLETAR_LOGRO)
    suspend fun completarLogro(@Path("id") id: Int, @Path("idJugador") idJugador: Int)
}