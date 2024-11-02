package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Piezas

fun moverDerechaIzquierda_3x2(pieza: Piezas, desplazamientos: IntArray, direccion: Int): Boolean {
    var puedeMoverse = true
    with(pieza){
        if (orientacion == 0) {
            puedeMoverse = matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[0]] == BLANCO
                    && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[1]] == BLANCO
        } else if (orientacion == 2) {
            puedeMoverse = matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[2]] == BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[3]] == BLANCO
        } else if (orientacion == 1) {
            puedeMoverse = matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[4]] == BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[5]] == BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[6]] == BLANCO
        } else if (orientacion == 3) {
            puedeMoverse = matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[7]] == BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[8]] == BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[9]] == BLANCO
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna + direccion)
            pintar()
        }
    }
    return puedeMoverse
}