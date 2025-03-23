package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.Mundo
import retrofit2.http.GET

interface MundoService {
    @GET(ConstantesCustomAPI.OBTENER_MUNDOS)
    suspend fun getAllMundos(): List<Mundo>
}