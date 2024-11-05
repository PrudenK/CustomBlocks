package com.pruden.tetris_2.Metodos.BorrarPiezas

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Metodos.DibujarTablero.General.cambiarParesImparesTablero3y4
import com.pruden.tetris_2.Metodos.Media.Audio.efectoSonido
import com.pruden.tetris_2.Metodos.Timelines.timelineMascara
import javafx.scene.control.Label



fun puntuaciones(lineasBorradas: Int) {
    var puntuacion = 0

         if (lineasBorradas == 1) puntuacion += 100
    else if (lineasBorradas == 2) puntuacion += 300
    else if (lineasBorradas == 3) puntuacion += 500
    else if (lineasBorradas == 4) puntuacion += 800
    else if (lineasBorradas == 5) puntuacion += 1200

    if (tipoTableroPrin == 3 || tipoTableroPrin == 4 ||tipoTableroPrin == 2) timelineMascara(lineasBorradas)

    if (lineasBorradas == 4 || lineasBorradas == 5) {
        efectoSonido("/Musica/Efectos/lineasTetris.mp3")
    } else if (lineasBorradas != 0) {
        efectoSonido("/Musica/Efectos/romperLineas.mp3")
    }

    cPrin.labelPuntuacion.text = (cPrin.labelPuntuacion.text.toInt() + puntuacion).toString()
}