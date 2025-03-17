package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Piezas

fun moverDerecha_1x1(pieza: Piezas): Boolean{
    with(pieza){
        if (columna != Globales.COLUMNAS - 1) {
            if (matrizNumerica[fila][columna + 1] == 0) {
                limpiar()
                columna +=1
                pintar()
                return true
            }
        }
        return false
    }
}

fun moverIzquierda_1x1(pieza: Piezas): Boolean{
    with(pieza){
        if (columna > 0) {
            if (matrizNumerica[fila][columna - 1] == 0) {
                limpiar()
                columna -=1
                pintar()
                return true
            }
        }
        return false
    }
}