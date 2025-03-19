package com.pruden.tetris_2.Constantes

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pruden.tetris_2.Metodos.Publicidad.Anuncio
import com.pruden.tetris_2.Metodos.Publicidad.PublicidadService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiPublicidad {
    private val retrofit = Retrofit.Builder()
        .baseUrl(ConstantesAPI.PATH_PUBLICIDAD)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())  // Adaptador para coroutines
        .build()

    val publicidadService: PublicidadService = retrofit.create(PublicidadService::class.java)

    var anuncios = listOf<Anuncio>()
}