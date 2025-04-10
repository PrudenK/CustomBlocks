package com.pruden.tetris_2.API.Constantes.publicidad

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pruden.tetris_2.API.ObjsAuxApi.Anuncio
import com.pruden.tetris_2.API.Services.PublicidadService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiPublicidad {
    private val retrofitPublicidad = Retrofit.Builder()
        .baseUrl(ConstantesPublicidadAPI.PATH_PUBLICIDAD)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())  // Adaptador para coroutines
        .build()

    val publicidadService: PublicidadService = retrofitPublicidad.create(PublicidadService::class.java)

    var anuncios = listOf<Anuncio>()
}