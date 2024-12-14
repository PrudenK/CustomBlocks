package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.BorrarPiezas.borrarLinea
import com.pruden.tetris_2.Metodos.Perder.comprbarPerder
import com.pruden.tetris_2.Piezas.Piezas

fun bajar2x1(pieza: Piezas):Boolean{
    with(pieza){
        val puedeBajar = if (orientacion == 0) {
            matrizNumerica[getFilaCentro() + 2][getColumnaCentro()] == BLANCO
        } else if (orientacion == 2){
            matrizNumerica[getFilaCentro() + 1][getColumnaCentro()] == BLANCO
        }else if (orientacion == 1){
            matrizNumerica[getFilaCentro() + 1][getColumnaCentro()] == BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro()-1] == BLANCO
        }else {
            matrizNumerica[getFilaCentro() + 1][getColumnaCentro()] == BLANCO
                    && matrizNumerica[getFilaCentro() + 1][getColumnaCentro()+1] == BLANCO
        }

        if (puedeBajar) {
            limpiar()
            fila = (fila + 1)
            pintar()
        } else {
            borrarLinea()
            comprbarPerder()
            return true
        }
        return false
    }
}