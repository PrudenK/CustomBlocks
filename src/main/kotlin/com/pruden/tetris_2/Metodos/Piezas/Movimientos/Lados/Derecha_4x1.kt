package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Pieza

fun derecha_4x1(pieza: Pieza): Boolean {
    var puedeMoverse = true
    with(pieza){
        if (orientacion == 0) {

            puedeMoverse = if (getColumnaCentro() != Globales.COLUMNAS - 3) {
                matrizNumerica[getFilaCentro()][getColumnaCentro() + 3] == 0
            } else {
                false
            }
        } else if (orientacion == 2) {
            puedeMoverse = if (getColumnaCentro() != Globales.COLUMNAS - 2) {
                matrizNumerica[getFilaCentro()][getColumnaCentro() + 2] == 0
            } else {
                false
            }
        } else if (orientacion == 3) {
            if (getColumnaCentro() != Globales.COLUMNAS - 1) {
                for (i in -2..1) {
                    if (matrizNumerica[getFilaCentro() + i][getColumnaCentro() + 1] != 0) {
                        puedeMoverse = false
                        break
                    }
                }
            } else {
                puedeMoverse = false
            }
        } else if (orientacion == 1) {
            if (getColumnaCentro() != Globales.COLUMNAS - 1) {
                for (i in -1..2) {
                    if (matrizNumerica[getFilaCentro() + i][getColumnaCentro() + 1] != 0) {
                        puedeMoverse = false
                        break
                    }
                }
            } else {
                puedeMoverse = false
            }
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna + 1)
            pintar()
        }
    }
    return puedeMoverse
}