package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.BorrarPiezas.borrarLinea
import com.pruden.tetris_2.Metodos.Perder.comprbarPerder
import com.pruden.tetris_2.Piezas.Pieza

fun bajar1x1(pieza : Pieza) : Boolean{
    with(pieza){
        if (matrizNumerica[fila + 1][columna] == 0) {
            limpiar()
            fila += 1
            pintar()
            return false
        } else {
            pintar()
            borrarLinea()
            comprbarPerder()
            return true
        }
    }
}