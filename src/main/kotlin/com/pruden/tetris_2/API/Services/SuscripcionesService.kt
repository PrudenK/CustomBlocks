package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.Suscripcion
import retrofit2.Response
import retrofit2.http.GET

interface SuscripcionesService {
    @GET(ConstantesCustomAPI.OBTENER_SUSCRIPCIONES)
    suspend fun getAllSuscripciones(): Response<List<Suscripcion>>
}