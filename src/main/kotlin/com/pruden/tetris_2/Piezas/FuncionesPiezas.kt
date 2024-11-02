package com.pruden.tetris_2.Piezas

import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Label
import javafx.scene.paint.Color

interface FuncionesPiezas {
    fun rotar(): Boolean

    fun limpiar()

    fun pintar()

    fun getForma(): Array<Array<IntArray>>

    fun getColumnaCentro(): Int

    fun getFilaCentro(): Int

    fun getNumpieza(): Int

    fun getCentro(): Int

    fun getColor(): Color

    fun bajar(): Boolean

    fun derecha(): Boolean

    fun izquierda(): Boolean

    fun set_Orientacion(ori: Int)

    fun puedeRotar(nuevaOrientacion: Int) : Boolean
}