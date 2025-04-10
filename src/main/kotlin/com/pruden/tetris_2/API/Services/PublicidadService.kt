package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.publicidad.ConstantesPublicidadAPI
import com.pruden.tetris_2.API.ObjsAuxApi.Anuncio
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface PublicidadService {
    @GET(ConstantesPublicidadAPI.TODOS_ANUNCIOS)
    suspend fun getAnuncios(): List<Anuncio>

    @PUT(ConstantesPublicidadAPI.PATH_CLICK_PUBLICIDAD)
    suspend fun onClickAnuncio(@Path("id") id: Int): ResponseBody
}