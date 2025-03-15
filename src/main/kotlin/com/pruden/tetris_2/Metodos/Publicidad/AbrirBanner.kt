package com.pruden.tetris_2.Metodos.Publicidad

import java.util.*


fun abrirBanner(web: String, id: Int){
    val pb: ProcessBuilder = if (System.getProperty("os.name").lowercase(Locale.getDefault()).contains("win")) {
        ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", web)
    } else {
        ProcessBuilder("firefox", web)
    }
    onClickAnuncio(id)
    pb.start()
}