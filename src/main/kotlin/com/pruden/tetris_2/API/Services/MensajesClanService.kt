package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAuxApi.MensajeClan
import retrofit2.http.GET
import retrofit2.http.Path

interface MensajesClanService {
    @GET(ConstantesCustomAPI.GET_MENSAJES_DE_UN_CLAN)
    suspend fun getMensajesDeUnClan(@Path("idClan") id: Int): List<MensajeClan>
}