package com.pruden.tetris_2.Metodos.Publicidad

import com.pruden.tetris_2.ApiPublicidad
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun obtenerAnuncios() {
    ApiPublicidad.apiService.getAnuncios().enqueue(object : Callback<List<Anuncio>> {
        override fun onResponse(call: Call<List<Anuncio>>, response: Response<List<Anuncio>>) {
            if (response.isSuccessful) {
                val anuncios = response.body()
                ApiPublicidad.anuncios = anuncios!!
                println("Anuncios recibidos: $anuncios")
            } else {
                println("Error: ${response.code()}")
            }
        }

        override fun onFailure(call: Call<List<Anuncio>>, t: Throwable) {
            println("Error en la conexión: ${t.message}")
        }
    })
}