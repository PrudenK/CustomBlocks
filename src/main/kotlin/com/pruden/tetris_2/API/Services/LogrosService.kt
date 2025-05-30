package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import retrofit2.http.POST
import retrofit2.http.Path

interface LogrosService {
    @POST(ConstantesCustomAPI.COMPLETAR_LOGRO)
    suspend fun completarLogro(@Path("id") id: Int, @Path("idJugador") idJugador: Int)
}