package com.pruden.tetris_2.API.Services

import com.google.gson.JsonObject
import com.pruden.tetris_2.API.ObjsAuxApi.Jugador
import com.pruden.tetris_2.API.ObjsAuxApi.LoginRequest
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAuxApi.JugadorInicioSesion
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface JugadorService {
    @GET(ConstantesCustomAPI.TODOS_JUGADORES)
    suspend fun getTodosJugadores(): MutableList<Jugador>

    @GET(ConstantesCustomAPI.INICIAR_SESION_DATOS)
    suspend fun getDatosIniciarSesion(@Path("idJugador") idJugador : Int): JugadorInicioSesion

    @GET(ConstantesCustomAPI.JUGADOR_POR_ID)
    suspend fun getJugadorPorId(@Path("id") id : Int): Jugador

    @POST(ConstantesCustomAPI.CREAR_JUGADOR)
    suspend fun crearJugador(@Body jugador: Jugador): Response<ResponseBody>

    @POST(ConstantesCustomAPI.INICIAR_SESION)
    suspend fun iniciarSesion(@Body loginRequest: LoginRequest): Response<JsonObject>

    @Multipart
    @POST(ConstantesCustomAPI.SUBIR_IMAGEN)
    suspend fun subirImagen(@Path("id") id: Int, @Part imagen: MultipartBody.Part): Response<ResponseBody>

    @POST(ConstantesCustomAPI.CERRAR_SESION)
    suspend fun cerrarSesion(@Path("id") id: Int)

    @POST(ConstantesCustomAPI.PING_JUGADOR)
    suspend fun ping(@Path("id") id: Int)

    @FormUrlEncoded
    @POST(ConstantesCustomAPI.ACTUALIZAR_NIVEL_EXP)
    suspend fun jugarActualizaNivelEXP(@Path("id") id: Int, @Field("exp") exp: Int, @Field("nivel") nivel: Int)

    @GET(ConstantesCustomAPI.RANKING_JUGADOR)
    suspend fun getRankingJugador(@Path("id") id: Int): Int
}