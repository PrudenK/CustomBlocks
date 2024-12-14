package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Piezas

fun derecha_2x1(pieza: Piezas): Boolean {
    var puedeMoverse = true
    with(pieza){
        puedeMoverse = if (orientacion == 0) {
            (matrizNumerica[getFilaCentro()][getColumnaCentro()+1] == BLANCO
                    && matrizNumerica[getFilaCentro()+1][getColumnaCentro()+1] == BLANCO)
        } else if (orientacion == 2) {
            (matrizNumerica[getFilaCentro()-1][getColumnaCentro()+1] == BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro()+1] == BLANCO)
        } else if (orientacion == 1) {
            matrizNumerica[getFilaCentro()][getColumnaCentro()+1] == BLANCO
        } else {
            matrizNumerica[getFilaCentro()][getColumnaCentro()+2] == BLANCO
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
            (matrizNumerica[getFilaCentro()][getColumnaCentro()-1] == BLANCO
                    && matrizNumerica[getFilaCentro()+1][getColumnaCentro()-1] == BLANCO)
        } else if (orientacion == 2) {
            (matrizNumerica[getFilaCentro()-1][getColumnaCentro()-1] == BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro()-1] == BLANCO)
        } else if (orientacion == 1) {
            matrizNumerica[getFilaCentro()][getColumnaCentro()-2] == BLANCO
        } else {
            matrizNumerica[getFilaCentro()][getColumnaCentro()-1] == BLANCO
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna - 1)
            pintar()
        }
    }
    return puedeMoverse
}