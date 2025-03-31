package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.PartidaGuardada
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

interface PartidaGuardadaService {
    @POST(ConstantesCustomAPI.GUARDAR_PARTIDA)
    suspend fun guardarPartida(@Body partida: PartidaGuardada): retrofit2.Response<ResponseBody>
}