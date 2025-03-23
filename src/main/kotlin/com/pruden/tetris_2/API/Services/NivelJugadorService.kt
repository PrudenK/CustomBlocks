package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.NivelJugador
import retrofit2.http.*

interface NivelJugadorService {
    @GET(ConstantesCustomAPI.NIVEL_JUGADOR)
    suspend fun getNivelesJugador(@Path("id") id : Int): MutableList<NivelJugador>

    @FormUrlEncoded
    @POST(ConstantesCustomAPI.COMPLETAR_NIVEL)
    suspend fun completarNivel(@Field("tiempo") tiempo: String, @Field("puntuacion") puntuacion : Int,
                               @Path("id") id: Int, @Path("idNivel") idNivel: Int)

    @POST(ConstantesCustomAPI.NIVEL_PERDIDO)
    suspend fun perderNivel(@Path("id") id: Int, @Path("idNivel") idNivel: Int)
}