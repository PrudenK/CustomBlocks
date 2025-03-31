package com.pruden.tetris_2.Metodos.DibujarTablero

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.DibujarTablero.General.cargarTablero
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroPrincipal
import com.pruden.tetris_2.Metodos.IniciarPartida.setStackpane12x8
import com.pruden.tetris_2.Metodos.IniciarPartida.setStackpane18x10
import com.pruden.tetris_2.Metodos.IniciarPartida.setStackpane30x20

fun cambioDeTablero(){
    cargarTablero()

    matrizNumerica = Array(Globales.FILAS + 1) { IntArray(Globales.COLUMNAS) }
    dibujarTableroPrincipal()

    when (Globales.FILAS) {
        20 -> setStackpane18x10()
        14 -> setStackpane12x8()
        32 -> setStackpane30x20()
    }
}