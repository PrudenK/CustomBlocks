package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAuxApi.PartidaGuardada
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path

interface PartidaGuardadaService {
    @POST(ConstantesCustomAPI.GUARDAR_PARTIDA)
    suspend fun guardarPartida(@Body partida: PartidaGuardada): Response<MutableList<PartidaGuardada>>

    @DELETE(ConstantesCustomAPI.BORRAR_PARTIDA_GUARDADA)
    suspend fun borrarPartida(@Path("idJugador") idJugador: Int, @Path("numPartidaGuardada") numPartidaGuardada: Int)
}