package com.pruden.tetris_2

import com.pruden.tetris_2.Metodos.Publicidad.PublicidadService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiPublicidad {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constantes.PATH_PUBLICIDAD)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: PublicidadService = retrofit.create(PublicidadService::class.java)

}