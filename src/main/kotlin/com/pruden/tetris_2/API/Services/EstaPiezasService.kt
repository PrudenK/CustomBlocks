package com.pruden.tetris_2.API.Services

import com.google.gson.JsonObject
import com.pruden.tetris_2.API.ObjsAux.EstaPiezas
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EstaPiezasService {
    @POST(ConstantesCustomAPI.SUBIR_ESTA_PIEZAS)
    suspend fun subirEstaPiezas(@Body estaPiezas: EstaPiezas)

    @GET(ConstantesCustomAPI.ESTA_PIEZAS_POR_JUGADOR)
    suspend fun getEstaPiezasPorJugador(@Path("id") id: Int): JsonObject
}