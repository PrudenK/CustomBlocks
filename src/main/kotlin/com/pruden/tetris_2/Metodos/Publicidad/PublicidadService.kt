package com.pruden.tetris_2.Metodos.Publicidad

import com.pruden.tetris_2.Constantes.publicidad.ConstantesPublicidadAPI
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