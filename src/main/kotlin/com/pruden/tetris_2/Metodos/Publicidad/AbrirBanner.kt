package com.pruden.tetris_2.Metodos.Publicidad

import com.pruden.tetris_2.ApiPublicidad
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

val web = "https://www.mercadonegro.pe/medios/digital/tecnologia/black-friday-katana-15-y-katana-17-entre-las-portatiles-mas-buscadas-de-msi/"

fun abrirBanner(){
    val pb: ProcessBuilder = if (System.getProperty("os.name").lowercase(Locale.getDefault()).contains("win")) {
        ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", web)
    } else {
        ProcessBuilder("firefox", web)
    }
    pb.start()

    cPrin.imgPublicidad.image
}

fun obtenerAnuncios() {
    ApiPublicidad.apiService.getAnuncios().enqueue(object : Callback<List<Anuncio>> {
        override fun onResponse(call: Call<List<Anuncio>>, response: Response<List<Anuncio>>) {
            if (response.isSuccessful) {
                val anuncios = response.body()
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