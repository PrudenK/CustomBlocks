package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Piezas

fun moverDerechaIzquierda_3x2(pieza: Piezas, desplazamientos: IntArray, direccion: Int): Boolean {
    var puedeMoverse = true
    with(pieza){
        if (orientacion == 0) {
            puedeMoverse = matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[0]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[1]] == Globales.BLANCO
        } else if (orientacion == 2) {
            puedeMoverse = matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[2]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[3]] == Globales.BLANCO
        } else if (orientacion == 1) {
            puedeMoverse = matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[4]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[5]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[6]] == Globales.BLANCO
        } else if (orientacion == 3) {
            puedeMoverse = matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[7]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[8]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[9]] == Globales.BLANCO
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna + direccion)
            pintar()
        }
    }
    return puedeMoverse
}