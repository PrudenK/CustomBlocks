package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Pieza_U
import com.pruden.tetris_2.Piezas.Pieza_V
import com.pruden.tetris_2.Piezas.Pieza

fun moverDerechaIzquierda_3x3(pieza: Pieza, desplazamientos: IntArray, direccion: Int) : Boolean { //1 o -1
    var puedeMoverse = true
    with(pieza){
        if (orientacion == 0) {
            puedeMoverse = if (pieza is Pieza_U || pieza is Pieza_V) {
                matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[0]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[1]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[2]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[3]] == Globales.BLANCO
            } else {
                matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[0]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[1]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[2]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[3]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[4]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[5]] == Globales.BLANCO
            }
        } else if (orientacion == 2) {
            puedeMoverse = if (pieza is Pieza_U || pieza is Pieza_V) {
                matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[8]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[9]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[10]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[11]] == Globales.BLANCO
            } else {
                matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[6]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[7]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[8]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[9]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[10]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[11]] == Globales.BLANCO
            }
        } else if (orientacion == 1) {
            puedeMoverse = matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[12]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[13]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[14]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[15]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[16]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[17]] == Globales.BLANCO
        } else if (orientacion == 3) {
            puedeMoverse = matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[18]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[19]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[20]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[21]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[22]] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[23]] == Globales.BLANCO
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna + direccion)
            pintar()
        }
    }
    return puedeMoverse
}