package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.BorrarPiezas.borrarLinea
import com.pruden.tetris_2.Metodos.Perder.comprbarPerder
import com.pruden.tetris_2.Piezas.Piezas

fun bajar_4x1(pieza: Piezas): Boolean {
    with(pieza) {
        var puedeBajar = true
        if (orientacion == 0) {
            for (i in -1..2) {
                if (matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + i] != 0) {
                    puedeBajar = false
                    break
                }
            }
        } else if (orientacion == 2) {
            for (i in -2..1) {
                if (matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + i] != 0) {
                    puedeBajar = false
                    break
                }
            }
        } else if (orientacion == 3) {
            puedeBajar = matrizNumerica[getFilaCentro() + 2][getColumnaCentro()] == 0
        } else if (orientacion == 1) {
            puedeBajar = matrizNumerica[getFilaCentro() + 3][getColumnaCentro()] == 0
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