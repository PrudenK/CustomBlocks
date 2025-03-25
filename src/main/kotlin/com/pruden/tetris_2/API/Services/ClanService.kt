package com.pruden.tetris_2.API.Services

import com.google.gson.JsonObject
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.Jugador
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ClanService {
    @Multipart
    @POST(ConstantesCustomAPI.CREAR_CLAN)
    suspend fun crearClan(
        @Part imagen: MultipartBody.Part?,
        @Part("nombre") nombre: RequestBody,
        @Part("descripcion") descripcion: RequestBody,
        @Part("ubicacion") ubicacion: RequestBody,
        @Part("idLider") idLider: RequestBody
    ): Response<ResponseBody>

    @GET(ConstantesCustomAPI.JUGADORES_DE_UN_CLAN)
    suspend fun getJugadoresDeUnClan(@Path("id") id: Int): List<Jugador>
}