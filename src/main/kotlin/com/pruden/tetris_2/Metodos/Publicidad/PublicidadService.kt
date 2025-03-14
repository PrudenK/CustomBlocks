package com.pruden.tetris_2.Metodos.Publicidad

import com.pruden.tetris_2.Constantes
import retrofit2.Call
import retrofit2.http.GET

interface PublicidadService {
    @GET(Constantes.TODOS_ANUNCIOS)
    fun getAnuncios(): Call<List<Anuncio>>
}