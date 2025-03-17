package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones

import com.pruden.tetris_2.Constantes.ConstantesPiezas
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Piezas


fun condicionRotarEspecial(pieza : Piezas, dFilas : IntArray, dColumnas : IntArray, columnaB: Boolean, movimiento: Int): Boolean {
    with(pieza) {
        var condicion = true
        for (i in dFilas.indices){
            if(matrizNumerica[getFilaCentro() + dFilas[i]][getColumnaCentro() + dColumnas[i]] != ConstantesPiezas.BLANCO){
                condicion = false; break
            }
        }
        return if (condicion) {
            limpiar()
            if (columnaB) {
                columna += movimiento
            } else fila += movimiento
            condicionEspecial_b = true
            true
        } else false
    }
}
