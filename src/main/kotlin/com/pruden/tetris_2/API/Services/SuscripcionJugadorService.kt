package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.SuscripcionJugador
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SuscripcionJugadorService {
    @POST(ConstantesCustomAPI.JUGADOR_SE_SUSCRIBE)
    suspend fun jugadorSeSuscribe(@Path("idJugador") idJugador: Int, @Path("tipo") tipo : Int): Response<ResponseBody>

    @GET(ConstantesCustomAPI.COMPROBAR_SI_JUGADOR_ES_PREMIUM)
    suspend fun comprobarSuscripcionDelJugador(@Path("idJugador") idJugador: Int): SuscripcionJugador
}