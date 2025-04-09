package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones


import com.pruden.tetris_2.Piezas.Pieza_P
import com.pruden.tetris_2.Piezas.Pieza

fun rotarNormal(pieza : Pieza, mod : Int): Boolean {
    with(pieza){
        val nuevaOrientacion = (orientacion + 1) % mod
        if (puedeRotar(nuevaOrientacion)) {
            if (!condicionEspecial_b) {
                limpiar()
            }
            orientacion = nuevaOrientacion
            pintar()
            return true
        }
        return false

    }
}
