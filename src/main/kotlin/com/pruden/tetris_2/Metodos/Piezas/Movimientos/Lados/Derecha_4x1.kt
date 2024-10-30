package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Piezas

fun derecha_4x1(pieza: Piezas) {
    var puedeMoverse = true
    if (pieza.orientacion == 0) {

        puedeMoverse = if (pieza.getColumnaCentro() != COLUMNAS - 3) {
            matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + 3] == 0
        } else {
            false
        }
    } else if (pieza.orientacion == 2) {
        puedeMoverse = if (pieza.getColumnaCentro() != COLUMNAS - 2) {
            matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + 2] == 0
        } else {
            false
        }
    } else if (pieza.orientacion == 3) {
        if (pieza.getColumnaCentro() != COLUMNAS - 1) {
            for (i in -2..1) {
                if (matrizNumerica[pieza.getFilaCentro() + i][pieza.getColumnaCentro() + 1] != 0) {
                    puedeMoverse = false
                    break
                }
            }
        } else {
            puedeMoverse = false
        }
    } else if (pieza.orientacion == 1) {
        if (pieza.getColumnaCentro() != COLUMNAS - 1) {
            for (i in -1..2) {
                if (matrizNumerica[pieza.getFilaCentro() + i][pieza.getColumnaCentro() + 1] != 0) {
                    puedeMoverse = false
                    break
                }
            }
        } else {
            puedeMoverse = false
        }
    }
    if (puedeMoverse) {
        pieza.limpiar()
        pieza.columna = (pieza.columna + 1)
        pieza.pintar()
    }
}