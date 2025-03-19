package com.pruden.tetris_2.Metodos.Publicidad

import com.pruden.tetris_2.Constantes.ApiPublicidad
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun onClickAnuncio(id: Int) {
    ApiPublicidad.publicidadService.onClickAnuncio(id).enqueue(object : Callback<ResponseBody> {
        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            if (response.isSuccessful) {
                println("Anuncio con ID $id actualizado correctamente.")
            } else {
                println("Error en la actualización del anuncio: Código ${response.code()}")
            }
        }

        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            println("Error en la conexión: ${t.message}")
        }
    })
}