package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar2x2
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerecha_O_2x2
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverIzquierda_O_2x2
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_O(override var fila: Int, override var columna: Int,
              override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private val CENTRO = 18
    private val NUMPIEZA = 1
    private val COLOR = Color.YELLOW


    private val FORMAS_O = arrayOf(
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA),
            intArrayOf(NUMPIEZA, NUMPIEZA)
        )
    )

    companion object {
        const val NUMPIEZA_O = 1
        val COLOR_O = Color.YELLOW!!
    }


    override fun rotar(): Boolean {
        return true
    }

    override fun limpiar() {
        limpiarPieza(this)
    }

    override fun pintar() {
        pintarPieza(this)
    }


    override fun bajar(): Boolean {
        return bajar2x2(this, intArrayOf(2,2))
    }

    override fun derecha(): Boolean {
        return moverDerecha_O_2x2(this)
    }

    override fun izquierda(): Boolean {
       return moverIzquierda_O_2x2(this)
    }

    override fun getForma(): Array<Array<IntArray>> {
        return FORMAS_O
    }

    override fun set_Orientacion(ori: Int) {
    }

    override fun puedeRotar(nuevaOrientacion: Int): Boolean {
        return true
    }

    override fun getColumnaCentro(): Int {
        return columna
    }

    override fun getFilaCentro(): Int {
        return fila
    }

    override fun getNumpieza(): Int {
        return NUMPIEZA
    }

    override fun getCentro(): Int {
        return CENTRO
    }

    override fun getColor(): Color {
        return COLOR
    }
}