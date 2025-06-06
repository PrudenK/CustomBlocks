package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.BorrarPiezas.borrarLinea
import com.pruden.tetris_2.Metodos.Perder.comprbarPerder
import com.pruden.tetris_2.Piezas.Pieza

fun bajar_3x1(pieza: Pieza): Boolean {
    with(pieza) {
        val puedeBajar = if (orientacion == 0) {
            matrizNumerica[getFilaCentro() + 1][getColumnaCentro() - 1] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro()] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + 1] == Globales.BLANCO
        } else {
            matrizNumerica[getFilaCentro() + 2][getColumnaCentro()] == Globales.BLANCO
        }
        if (puedeBajar) {
            limpiar()
            fila = (fila + 1)
            pintar()
        } else {
            borrarLinea()
            comprbarPerder()
            return true
        }
        return false
    }
}