package com.pruden.tetris_2.Constantes.custom

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pruden.tetris_2.Constantes.custom.API.JugadorService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCustom {
    private val retrofitCustom = Retrofit.Builder()
        .baseUrl(ConstantesCustomAPI.PATH_CUSTOM)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val jugadorService: JugadorService = retrofitCustom.create(JugadorService::class.java)

}