package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAuxApi.NivelJugador
import retrofit2.Response
import retrofit2.http.*

interface NivelJugadorService {
    @FormUrlEncoded
    @POST(ConstantesCustomAPI.COMPLETAR_NIVEL)
    suspend fun completarNivel(@Field("tiempo") tiempo: String, @Field("puntuacion") puntuacion : Int,
                               @Path("id") id: Int, @Path("idNivel") idNivel: Int): Response<NivelJugador>

    @POST(ConstantesCustomAPI.NIVEL_PERDIDO)
    suspend fun perderNivel(@Path("id") id: Int, @Path("idNivel") idNivel: Int)
}