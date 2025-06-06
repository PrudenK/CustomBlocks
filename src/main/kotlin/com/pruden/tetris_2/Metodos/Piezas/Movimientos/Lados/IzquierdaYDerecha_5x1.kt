package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Pieza

fun moverDerechaIzquierda_5x1(pieza: Pieza, dech_o_izq: Int): Boolean { //1 o -1
    var puedeMoverse = true
    with(pieza) {
        puedeMoverse = if (orientacion == 0) {
            matrizNumerica[getFilaCentro()][getColumnaCentro() + 3 * dech_o_izq] == Globales.BLANCO
        } else {
            matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + dech_o_izq] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + dech_o_izq] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro() + dech_o_izq] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + dech_o_izq] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + dech_o_izq] == Globales.BLANCO
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna + dech_o_izq)
            pintar()
        }
    }
    return puedeMoverse
}