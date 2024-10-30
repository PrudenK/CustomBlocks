package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Piezas

fun moverDerechaIzquierda_3x2(pieza: Piezas, desplazamientos: IntArray, direccion: Int) {
    var puedeMoverse = true
    if (pieza.getOrientacion() == 0) {
        puedeMoverse = matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[0]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() - 1][pieza.getColumnaCentro() + desplazamientos[1]] == BLANCO
    } else if (pieza.getOrientacion() == 2) {
        puedeMoverse = matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[2]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + desplazamientos[3]] == BLANCO
    } else if (pieza.getOrientacion() == 1) {
        puedeMoverse = matrizNumerica[pieza.getFilaCentro() - 1][pieza.getColumnaCentro() + desplazamientos[4]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[5]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + desplazamientos[6]] == BLANCO
    } else if (pieza.getOrientacion() == 3) {
        puedeMoverse = matrizNumerica[pieza.getFilaCentro() - 1][pieza.getColumnaCentro() + desplazamientos[7]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[8]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + desplazamientos[9]] == BLANCO
    }
    if (puedeMoverse) {
        pieza.limpiar()
        pieza.columna = (pieza.columna + direccion)
        pieza.pintar()
    }
}