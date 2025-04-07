package com.pruden.tetris_2.API.Services

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.Clan
import com.pruden.tetris_2.API.ObjsAux.ItemClan
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
    ): Response<Clan>

    @GET(ConstantesCustomAPI.JUGADORES_DE_UN_CLAN)
    suspend fun getJugadoresDeUnClan(@Path("id") id: Int): List<Jugador>

    @GET(ConstantesCustomAPI.DATOS_DE_UN_CLAN)
    suspend fun getDatosDeUnClan(@Path("id") id: Int): Clan

    @GET(ConstantesCustomAPI.TODOS_LOS_CLANES)
    suspend fun getTodosLosClanes(): List<ItemClan>

    @POST(ConstantesCustomAPI.JUGADOR_SE_UNE_A_UN_CLAN)
    suspend fun jugadorSeUneAUnClan(@Path("id") id: Int, @Path("idJugador") idJugador: Int) : Response<ResponseBody>

    @POST(ConstantesCustomAPI.JUGADOR_ABANDONA_SU_CLAN)
    suspend fun jugadorAbandonaClan(@Path("idJugador") idJugador: Int)
}