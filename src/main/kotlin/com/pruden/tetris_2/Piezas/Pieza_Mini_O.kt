package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar1x1
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerecha_1x1
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverIzquierda_1x1
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_Mini_O (override var fila: Int, override var columna: Int,
                    override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private val CENTRO = 368
    private val NUMPIEZA = 1
    private val COLOR = Color.web("#7d0202")


    private val FORMAS_MINI_O = arrayOf(
        arrayOf(
            intArrayOf(CENTRO)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, CENTRO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        )
    )

    companion object {
        const val CENTRO_MINI_O = 368
        val COLOR_MINI_O = Color.web("#7d0202")!!
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
        return bajar1x1(this)
    }

    override fun derecha(): Boolean {
       return moverDerecha_1x1(this)
    }

    override fun izquierda(): Boolean {
        return moverIzquierda_1x1(this)
    }

    override fun getForma(): Array<Array<IntArray>> {
        return FORMAS_MINI_O
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