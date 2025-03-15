package com.pruden.tetris_2.Metodos.Publicidad

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import java.util.*


fun abrirBanner(web: String){
    val pb: ProcessBuilder = if (System.getProperty("os.name").lowercase(Locale.getDefault()).contains("win")) {
        ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", web)
    } else {
        ProcessBuilder("firefox", web)
    }
    pb.start()
}