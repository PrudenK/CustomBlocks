package com.pruden.tetris_2.API.Constantes.custom

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pruden.tetris_2.API.Services.EstaPiezasService
import com.pruden.tetris_2.API.Services.JugadorService
import com.pruden.tetris_2.API.Services.PartitdaService
import com.pruden.tetris_2.API.Services.SuscripcionesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCustom {
    private val retrofitCustom = Retrofit.Builder()
        .baseUrl(ConstantesCustomAPI.PATH_CUSTOM)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val jugadorService: JugadorService = retrofitCustom.create(JugadorService::class.java)
    val partidaService: PartitdaService = retrofitCustom.create(PartitdaService::class.java)
    val estaPiezasService: EstaPiezasService = retrofitCustom.create(EstaPiezasService::class.java)
    val suscripcionService: SuscripcionesService = retrofitCustom.create(SuscripcionesService::class.java)

}