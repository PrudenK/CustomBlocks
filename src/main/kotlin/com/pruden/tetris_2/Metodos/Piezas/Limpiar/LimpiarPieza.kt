package com.pruden.tetris_2.Metodos.Piezas.Limpiar

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.CENTRO_BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarCasilla
import com.pruden.tetris_2.Piezas.Piezas

fun limpiarPieza(pieza: Piezas){
    val forma = pieza.getForma()[pieza.orientacion]
    for (i in forma.indices) {
        for (j in forma[i].indices) {
            if (forma[i][j] == pieza.getNumpieza()){
                matrizNumerica[pieza.fila + i][pieza.columna + j] = BLANCO
                pintarCasilla(FONDO, (pieza.fila + i).toDouble(), (pieza.columna + j).toDouble())
            }else if (forma[i][j] == pieza.getCentro() && pieza.getCentro() != CENTRO_BLANCO) {
                matrizNumerica[pieza.fila + i][pieza.columna + j] = BLANCO
                pintarCasilla(FONDO, (pieza.fila + i).toDouble(), (pieza.columna + j).toDouble())
            }
        }
    }
}