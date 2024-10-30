package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.BorrarPiezas.borrarLinea
import com.pruden.tetris_2.Metodos.Perder.comprbarPerder
import com.pruden.tetris_2.Piezas.Piezas

fun bajar_5x1(pieza: Piezas): Boolean {
    val puedeBajar = if (pieza.getOrientacion() == 0) {
        matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() - 2] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() - 1] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro()] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + 1] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + 2] == BLANCO
    } else {
        matrizNumerica[pieza.getFilaCentro() + 3][pieza.getColumnaCentro()] == BLANCO
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