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
    val nivelJugadorService: NivelJugadorService = retrofitCustom.create(NivelJugadorService::class.java)
    val logroService: LogrosService = retrofitCustom.create(LogrosService::class.java)
    val clanService: ClanService = retrofitCustom.create(ClanService::class.java)
    val suscripcionJugadorService: SuscripcionJugadorService = retrofitCustom.create(SuscripcionJugadorService::class.java)
    val mensajeClanService: MensajesClanService = retrofitCustom.create(MensajesClanService::class.java)
    val modoDeJuegoService: ModoDeJuegoService = retrofitCustom.create(ModoDeJuegoService::class.java)
    val partidaGuardadaService: PartidaGuardadaService = retrofitCustom.create(PartidaGuardadaService::class.java)
}