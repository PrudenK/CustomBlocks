package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.ObjsAux.EstadisticasModo
import com.pruden.tetris_2.API.ObjsAux.Partida
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.JugadorRanking
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PartitdaService {

    @POST(ConstantesCustomAPI.SUBIR_PARTIDA)
    suspend fun subirPartida(@Body partida: Partida): Response<ResponseBody>

    @GET(ConstantesCustomAPI.ESTA_MODOS_PARTIDA)
    suspend fun getEstadisticasPorModoYUsuario(@Path("idJugador") idJugador: Int, @Path("modo") modo: String): EstadisticasModo

    @GET(ConstantesCustomAPI.MEJORES_PARTIDAS)
    suspend fun getMejoresPartidas(@Path("pais") pais: String, @Path("modo") modo: String): List<JugadorRanking>

    @GET(ConstantesCustomAPI.PARTIDAS_DEL_JUGADOR)
    suspend fun getPartidasDelJugador(@Path("idJugador") idJugador: Int, @Path("modo") modo: String): List<Partida>

    @GET(ConstantesCustomAPI.NUM_PARTIDAS_CLASICAS)
    suspend fun getNumPartidasClasicas(@Path("id") id: Int): Response<Int>

    @GET(ConstantesCustomAPI.NUM_LINEAS)
    suspend fun getNumLineas(@Path("id") id: Int): Int
}