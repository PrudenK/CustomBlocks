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