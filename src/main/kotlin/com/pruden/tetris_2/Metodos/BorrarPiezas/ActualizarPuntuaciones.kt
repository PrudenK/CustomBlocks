package com.pruden.tetris_2.Metodos.BorrarPiezas

import com.pruden.tetris_2.Metodos.Media.Audio.efectoSonido
import javafx.scene.control.Label



fun puntuaciones(lineasBorradas: Int, label_puntuacion: Label) {
    var puntuacion = 0

    if (lineasBorradas == 1) {
        puntuacion += 100
    } else if (lineasBorradas == 2) {
        puntuacion += 300
    } else if (lineasBorradas == 3) {
        puntuacion += 500
    } else if (lineasBorradas == 4) {
        puntuacion += 800
    } else if (lineasBorradas == 5) {
        puntuacion += 1200
    }

    if (lineasBorradas == 4 || lineasBorradas == 5) {
        efectoSonido("/Musica/Efectos/lineasTetris.mp3")
    } else if (lineasBorradas != 0) {
        efectoSonido("/Musica/Efectos/romperLineas.mp3")
    }

    label_puntuacion.text = (label_puntuacion.text.toInt() + puntuacion).toString()
}