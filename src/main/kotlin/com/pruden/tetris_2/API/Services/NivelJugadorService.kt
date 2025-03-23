package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.NivelJugador
import retrofit2.http.GET
import retrofit2.http.Path

interface NivelJugadorService {
    @GET(ConstantesCustomAPI.NIVEL_JUGADOR)
    suspend fun getNivelesJugador(@Path("id") id : Int): MutableList<NivelJugador>
}