package com.pruden.tetris_2.Piezas

import javafx.scene.paint.Color

interface FuncionesAuxPiezas {
    fun getForma(): Array<Array<IntArray>>
    fun getColumnaCentro(): Int
    fun getFilaCentro(): Int
    fun getNumpieza(): Int
    fun getCentro(): Int
    fun getColor(): Color
}