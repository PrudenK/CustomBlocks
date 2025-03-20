package com.pruden.tetris_2.Constantes.custom.API

import com.pruden.tetris_2.BaseDeDatos.Objs.EstaPiezas
import com.pruden.tetris_2.Constantes.custom.ConstantesCustomAPI
import retrofit2.http.Body
import retrofit2.http.POST

interface EstaPiezasService {
    @POST(ConstantesCustomAPI.SUBIR_ESTA_PIEZAS)
    suspend fun subirEstaPiezas(@Body estaPiezas: EstaPiezas)
}