package com.pruden.tetris_2.Metodos.BorrarPiezas

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.objPuntuacionBajar
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Metodos.Media.Audio.efectoSonido
import com.pruden.tetris_2.Metodos.ModoCampa.FinDelNivel.comprobarPasarNivel
import com.pruden.tetris_2.Metodos.Timelines.timelineMascara

val listaPuntuaiones = listOf(0,100,300,500,800,1200)

fun puntuaciones(lineasBorradas: Int) {
    var puntuacion = 0

    puntuacion += listaPuntuaiones[lineasBorradas]

    if (tipoTableroPrin == 3 || tipoTableroPrin == 4 ||tipoTableroPrin == 2) timelineMascara(lineasBorradas)

    if (lineasBorradas == 4 || lineasBorradas == 5) {
        efectoSonido("/Musica/Efectos/lineasTetris.mp3")
    } else if (lineasBorradas != 0) {
        efectoSonido("/Musica/Efectos/romperLineas.mp3")
    }

    cPrin.labelPuntuacion.text = (cPrin.labelPuntuacion.text.split("/")[0].toInt() + puntuacion).toString() + objPuntuacionBajar

    comprobarPasarNivel()
}