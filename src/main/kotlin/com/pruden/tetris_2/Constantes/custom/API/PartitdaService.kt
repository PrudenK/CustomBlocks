package com.pruden.tetris_2.Constantes.custom.API

import com.pruden.tetris_2.BaseDeDatos.Objs.Partida
import com.pruden.tetris_2.Constantes.custom.ConstantesCustomAPI
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PartitdaService {

    @POST(ConstantesCustomAPI.SUBIR_PARTIDA)
    suspend fun subirPartida(@Body partida: Partida): Response<ResponseBody>
}