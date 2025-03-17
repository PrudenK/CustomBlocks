package com.pruden.tetris_2.Metodos.Matriz

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarCasilla

fun rellenarMatriz() {
    for (i in matrizNumerica.indices) {
        for (j in matrizNumerica[0].indices) {
            if (i == Globales.FILAS) {
                matrizNumerica[i][j] = Globales.BORDE_TABLERO
            } else {
                matrizNumerica[i][j] = Globales.BLANCO
                //pintarCasilla(FONDO, i.toDouble(), j.toDouble())
            }
        }
    }
}

fun borrarCasillas(){
    for (i in matrizNumerica.indices-1) {
        for (j in matrizNumerica[0].indices) {
            pintarCasilla(FONDO, i.toDouble(), j.toDouble())
        }
    }
}



fun imprimirMatriz_TAB() {
    val ancho = 4
    for (i in matrizNumerica.indices) {
        for (j in matrizNumerica[0].indices) {
            print(String.format("%" + ancho + "d", matrizNumerica[i][j]))
        }
        println()
    }
    println("\n\n\n\n")
}
