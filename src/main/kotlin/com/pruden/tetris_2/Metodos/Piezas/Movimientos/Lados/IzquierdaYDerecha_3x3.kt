package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Constantes.ConstantesPiezas
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Pieza_U
import com.pruden.tetris_2.Piezas.Pieza_V
import com.pruden.tetris_2.Piezas.Piezas

fun moverDerechaIzquierda_3x3(pieza: Piezas, desplazamientos: IntArray, direccion: Int) : Boolean { //1 o -1
    var puedeMoverse = true
    with(pieza){
        if (orientacion == 0) {
            puedeMoverse = if (pieza is Pieza_U || pieza is Pieza_V) {
                matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[0]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[1]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[2]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[3]] == ConstantesPiezas.BLANCO
            } else {
                matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[0]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[1]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[2]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[3]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[4]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[5]] == ConstantesPiezas.BLANCO
            }
        } else if (orientacion == 2) {
            puedeMoverse = if (pieza is Pieza_U || pieza is Pieza_V) {
                matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[8]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[9]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[10]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[11]] == ConstantesPiezas.BLANCO
            } else {
                matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[6]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[7]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[8]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[9]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[10]] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[11]] == ConstantesPiezas.BLANCO
            }
        } else if (orientacion == 1) {
            puedeMoverse = matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[12]] == ConstantesPiezas.BLANCO
                    && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[13]] == ConstantesPiezas.BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[14]] == ConstantesPiezas.BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[15]] == ConstantesPiezas.BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[16]] == ConstantesPiezas.BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[17]] == ConstantesPiezas.BLANCO
        } else if (orientacion == 3) {
            puedeMoverse = matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[18]] == ConstantesPiezas.BLANCO
                    && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[19]] == ConstantesPiezas.BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[20]] == ConstantesPiezas.BLANCO
                    && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[21]] == ConstantesPiezas.BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[22]] == ConstantesPiezas.BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[23]] == ConstantesPiezas.BLANCO
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna + direccion)
            pintar()
        }
    }
    return puedeMoverse
}