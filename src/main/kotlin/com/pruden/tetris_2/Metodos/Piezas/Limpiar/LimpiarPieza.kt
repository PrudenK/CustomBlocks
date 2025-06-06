package com.pruden.tetris_2.Metodos.Piezas.Limpiar

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarCasilla
import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Piezas.Pieza

fun limpiarPieza(pieza: Pieza){
    val forma = pieza.getForma()[pieza.orientacion]
    for (i in forma.indices) {
        for (j in forma[i].indices) {
            if (forma[i][j] == pieza.getNumpieza() || forma[i][j] == Globales.NUMPIEZA_PICO){
                matrizNumerica[pieza.fila + i][pieza.columna + j] = Globales.BLANCO
                pintarCasilla(FONDO, (pieza.fila + i).toDouble(), (pieza.columna + j).toDouble())
            }else if (forma[i][j] == pieza.getCentro() && pieza.getCentro() != Globales.CENTRO_BLANCO) {
                matrizNumerica[pieza.fila + i][pieza.columna + j] = Globales.BLANCO
                pintarCasilla(FONDO, (pieza.fila + i).toDouble(), (pieza.columna + j).toDouble())
            }
        }
    }
}