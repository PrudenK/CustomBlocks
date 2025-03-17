package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Piezas

fun moverDerechaIzquierda_4x4(pieza: Piezas, desplazamientos: IntArray, direccion: Int) : Boolean { //1 o -1
    var puedeMoverse = true
    with(pieza){
        if (orientacion == 0) {
            puedeMoverse =
                matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[0]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[1]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[2]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[3]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[4]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[5]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + desplazamientos[6]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + desplazamientos[7]] == Globales.BLANCO
        } else if (orientacion == 2) {
            puedeMoverse =
                matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + desplazamientos[8]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + desplazamientos[9]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[10]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[11]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[12]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[13]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[14]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[15]] == Globales.BLANCO
        } else if (orientacion == 1) {
            puedeMoverse =
                matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[16]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[17]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[18]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[19]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[20]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[21]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + desplazamientos[22]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + desplazamientos[23]] == Globales.BLANCO
        } else if (orientacion == 3) {
            puedeMoverse =
                matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + desplazamientos[24]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + desplazamientos[25]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[26]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[27]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[28]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[29]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[30]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[31]] == Globales.BLANCO
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna + direccion)
            pintar()
        }
    }
    return puedeMoverse
}