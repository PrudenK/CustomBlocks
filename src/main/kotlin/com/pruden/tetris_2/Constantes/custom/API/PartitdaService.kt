package com.pruden.tetris_2.Constantes.custom.API

import com.pruden.tetris_2.BaseDeDatos.Objs.EstadisticasModo
import com.pruden.tetris_2.BaseDeDatos.Objs.Partida
import com.pruden.tetris_2.Constantes.custom.ConstantesCustomAPI
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
}