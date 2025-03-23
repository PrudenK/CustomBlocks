package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.MundoJugador
import retrofit2.http.GET
import retrofit2.http.Path

interface MundoJugadorService {
    @GET(ConstantesCustomAPI.MUNDO_JUGADOR)
    suspend fun getMundosDelJugador(@Path("id") id: Int): MutableList<MundoJugador>
}