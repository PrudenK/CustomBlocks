package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Piezas


fun condicionRotarEspecial(pieza : Piezas, dFilas : IntArray, dColumnas : IntArray, columnaB: Boolean, movimiento: Int): Boolean {

    with(pieza) {

        var condicion = true
        println(0)
        for (i in dFilas.indices){
            if(matrizNumerica[getFilaCentro() + dFilas[i]][getColumnaCentro() + dColumnas[i]] != BLANCO){
                println(1)
                condicion = false; break
            }
        }
        println(2)
        return if (condicion) {
            println(3)
            limpiar()
            if (columnaB) {
                columna += movimiento
            } else fila += movimiento
            condicionEspecial_b = true
            true
        } else false
    }
}
