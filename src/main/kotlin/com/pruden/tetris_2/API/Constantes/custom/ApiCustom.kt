package com.pruden.tetris_2.API.Constantes.custom

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pruden.tetris_2.API.Services.*
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
    val mundoService: MundoService = retrofitCustom.create(MundoService::class.java)
    val nivelService: NivelService = retrofitCustom.create(NivelService::class.java)
}