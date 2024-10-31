package com.pruden.tetris_2.Metodos.DibujarTablero

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.controladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroPrincipal
import com.pruden.tetris_2.Metodos.IniciarPartida.setStackpane12x8
import com.pruden.tetris_2.Metodos.IniciarPartida.setStackpane18x10
import com.pruden.tetris_2.Metodos.IniciarPartida.setStackpane30x20

fun cambioDeTablero(){
    controladorPrincipal.cargarTablero()

    matrizNumerica = Array(FILAS + 1) { IntArray(COLUMNAS) }
    dibujarTableroPrincipal()

    if (FILAS == 20) {
        setStackpane18x10()
    } else if (FILAS == 14) {
        setStackpane12x8()
    } else if (FILAS == 32) {
        setStackpane30x20()
    }
}