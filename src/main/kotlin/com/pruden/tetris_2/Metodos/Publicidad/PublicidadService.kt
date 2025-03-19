package com.pruden.tetris_2.Metodos.Publicidad

import com.pruden.tetris_2.Constantes.ConstantesAPI
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface PublicidadService {
    @GET(ConstantesAPI.TODOS_ANUNCIOS)
    suspend fun getAnuncios(): List<Anuncio>

    @PUT(ConstantesAPI.PATH_CLICK_PUBLICIDAD)
    suspend fun onClickAnuncio(@Path("id") id: Int): ResponseBody
}