package com.pruden.tetris_2.Constantes.custom.API

import com.google.gson.JsonObject
import com.pruden.tetris_2.BaseDeDatos.Objs.Jugador
import com.pruden.tetris_2.BaseDeDatos.Objs.LoginRequest
import com.pruden.tetris_2.Constantes.custom.ConstantesCustomAPI
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface JugadorService {
    @GET(ConstantesCustomAPI.TODOS_JUGADORES)
    suspend fun getTodosJugadores(): List<Jugador>

    @GET(ConstantesCustomAPI.JUGADOR_POR_ID)
    suspend fun getJugadorPorId(@Path("id") id : Int): Jugador

    @POST(ConstantesCustomAPI.CREAR_JUGADOR)
    suspend fun crearJugador(@Body jugador: Jugador): Response<ResponseBody>

    @POST(ConstantesCustomAPI.INICIAR_SESION)
    suspend fun iniciarSesion(@Body loginRequest: LoginRequest): Response<JsonObject>
}