package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.Nivel
import retrofit2.http.GET

interface NivelService {
    @GET(ConstantesCustomAPI.OBTENER_NIVELES)
    suspend fun getAllNiveles(): List<Nivel>
}