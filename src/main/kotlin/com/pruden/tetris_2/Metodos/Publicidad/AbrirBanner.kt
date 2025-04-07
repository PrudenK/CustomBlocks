package com.pruden.tetris_2.Metodos.Publicidad

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