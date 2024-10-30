package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.BorrarPiezas.borrarLinea
import com.pruden.tetris_2.Metodos.Perder.comprbarPerder
import com.pruden.tetris_2.Piezas.Piezas

fun bajar_4x1(pieza: Piezas): Boolean {
    var puedeBajar = true
    if (pieza.getOrientacion() == 0) {
        for (i in -1..2) {
            if (matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + i] != 0) {
                puedeBajar = false
                break
            }
        }
    } else if (pieza.getOrientacion() == 2) {
        for (i in -2..1) {
            if (matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + i] != 0) {
                puedeBajar = false
                break
            }
        }
    } else if (pieza.getOrientacion() == 3) {
        puedeBajar = matrizNumerica[pieza.getFilaCentro() + 2][pieza.getColumnaCentro()] == 0
    } else if (pieza.getOrientacion() == 1) {
        puedeBajar = matrizNumerica[pieza.getFilaCentro() + 3][pieza.getColumnaCentro()] == 0
    }
    if (puedeBajar) {
        pieza.limpiar()
        pieza.fila = (pieza.fila + 1)
        pieza.pintar()
    } else {
        borrarLinea()
        comprbarPerder()
        return true
    }
    return false
}