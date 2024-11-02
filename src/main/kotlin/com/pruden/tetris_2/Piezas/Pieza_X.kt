package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar3x3
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_3x3
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_X (override var fila: Int, override var columna: Int,
               override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = 88
    private val NUMPIEZA = 8
    private val COLOR = Color.BURLYWOOD

    private val FORMAS_X = arrayOf(
        arrayOf(
            intArrayOf(BLANCO, NUMPIEZA, BLANCO),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(BLANCO, NUMPIEZA, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_X = 8
        const val CENTRO_X = 88
        val COLOR_X = Color.BURLYWOOD!!
    }

    override fun limpiar() {
        limpiarPieza(this)
    }

    override fun pintar() {
        val filaColumna = pintarPieza(this)
        filaCentro = filaColumna[0]
        columnaCentro = filaColumna[1]
    }

    override fun rotar(): Boolean {
        return true
    }

    override fun bajar(): Boolean {
        return bajar3x3(this, intArrayOf(1,1, 2,2, 1,1))
    }

    override fun derecha(): Boolean {
       return moverDerechaIzquierda_3x3(this, intArrayOf(1,1, 2,2, 1,1), 1)
    }

    override fun izquierda(): Boolean {
       return moverDerechaIzquierda_3x3(this, intArrayOf(-1, -1,-2, -2,-1, -1), -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_X
    }


    override fun getColumnaCentro(): Int {
        return columnaCentro
    }

    override fun getFilaCentro(): Int {
        return filaCentro
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

    override fun set_Orientacion(ori: Int) {
        orientacion = ori
    }

    override fun puedeRotar(nuevaOrientacion: Int): Boolean {
        return false
    }

}