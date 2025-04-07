package com.pruden.tetris_2.Metodos.Publicidad

import com.pruden.tetris_2.API.Constantes.publicidad.ApiPublicidad
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


fun abrirBanner(web: String, id: Int = -1){
    val pb: ProcessBuilder = if (System.getProperty("os.name").lowercase(Locale.getDefault()).contains("win")) {
        ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", web)
    } else {
        ProcessBuilder("firefox", web)
    }

    if(id != -1) onClickAnuncio(id)

    pb.start()
}

fun obtenerAnuncios() {
    CoroutineScope(Dispatchers.IO).launch{
        ApiPublicidad.anuncios = ApiPublicidad.publicidadService.getAnuncios()
    }
}

private fun onClickAnuncio(id: Int) {
    CoroutineScope(Dispatchers.IO).launch {
        ApiPublicidad.publicidadService.onClickAnuncio(id)
    }
}