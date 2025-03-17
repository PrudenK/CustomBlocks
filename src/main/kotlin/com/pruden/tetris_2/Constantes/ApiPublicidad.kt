package com.pruden.tetris_2.Constantes

import com.pruden.tetris_2.Metodos.Publicidad.Anuncio
import com.pruden.tetris_2.Metodos.Publicidad.PublicidadService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiPublicidad {
    private val retrofit = Retrofit.Builder()
        .baseUrl(ConstantesAPI.PATH_PUBLICIDAD)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: PublicidadService = retrofit.create(PublicidadService::class.java)

    var anuncios = listOf<Anuncio>()
}