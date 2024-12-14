package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Piezas

fun moverDerechaIzquierda_4x4(pieza: Piezas, desplazamientos: IntArray, direccion: Int) : Boolean { //1 o -1
    var puedeMoverse = true
    with(pieza){
        if (orientacion == 0) {
            puedeMoverse =
                matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[0]] == BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[1]] == BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[2]] == BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[3]] == BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[4]] == BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[5]] == BLANCO
                        && matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + desplazamientos[6]] == BLANCO
                        && matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + desplazamientos[7]] == BLANCO
        } else if (orientacion == 2) {
            puedeMoverse =
                matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + desplazamientos[8]] == BLANCO
                        && matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + desplazamientos[9]] == BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[10]] == BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[11]] == BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[12]] == BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[13]] == BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[14]] == BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[15]] == BLANCO
        } else if (orientacion == 1) {
            puedeMoverse =
                matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[16]] == BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[17]] == BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[18]] == BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[19]] == BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[20]] == BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[21]] == BLANCO
                        && matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + desplazamientos[22]] == BLANCO
                        && matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + desplazamientos[23]] == BLANCO
        } else if (orientacion == 3) {
            puedeMoverse =
                matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + desplazamientos[24]] == BLANCO
                        && matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + desplazamientos[25]] == BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[26]] == BLANCO
                        && matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[27]] == BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[28]] == BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[29]] == BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[30]] == BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[31]] == BLANCO
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna + direccion)
            pintar()
        }
    }
    return puedeMoverse
}