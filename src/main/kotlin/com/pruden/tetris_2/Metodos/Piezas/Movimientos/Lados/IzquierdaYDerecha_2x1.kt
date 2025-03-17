package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Piezas

fun derecha_2x1(pieza: Piezas): Boolean {
    var puedeMoverse = true
    with(pieza){
        puedeMoverse = if (orientacion == 0) {
            (matrizNumerica[getFilaCentro()][getColumnaCentro()+1] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro()+1][getColumnaCentro()+1] == Globales.BLANCO)
        } else if (orientacion == 2) {
            (matrizNumerica[getFilaCentro()-1][getColumnaCentro()+1] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro()+1] == Globales.BLANCO)
        } else if (orientacion == 1) {
            matrizNumerica[getFilaCentro()][getColumnaCentro()+1] == Globales.BLANCO
        } else {
            matrizNumerica[getFilaCentro()][getColumnaCentro()+2] == Globales.BLANCO
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna + 1)
            pintar()
        }
    }
    return puedeMoverse
}

fun izquierda_2x1(pieza: Piezas): Boolean {
    var puedeMoverse = true
    with(pieza){
        puedeMoverse = if (orientacion == 0) {
            (matrizNumerica[getFilaCentro()][getColumnaCentro()-1] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro()+1][getColumnaCentro()-1] == Globales.BLANCO)
        } else if (orientacion == 2) {
            (matrizNumerica[getFilaCentro()-1][getColumnaCentro()-1] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro()-1] == Globales.BLANCO)
        } else if (orientacion == 1) {
            matrizNumerica[getFilaCentro()][getColumnaCentro()-2] == Globales.BLANCO
        } else {
            matrizNumerica[getFilaCentro()][getColumnaCentro()-1] == Globales.BLANCO
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna - 1)
            pintar()
        }
    }
    return puedeMoverse
}