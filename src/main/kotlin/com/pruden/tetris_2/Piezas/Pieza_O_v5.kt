package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar3x3
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_3x3
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_O_v5(override var fila: Int, override var columna: Int,
                 override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Pieza(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = 428
    private val NUMPIEZA = 42
    private val COLOR = Color.web("#D1EBD4")

    private val FORMAS_O_v5 = arrayOf(
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, CENTRO, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_O_v5 = 42
        const val CENTRO_O_v5 = 428
        val COLOR_O_v5 = Color.web("#D1EBD4")!!
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
        return bajar3x3(this, intArrayOf(2,2, 2,2, 2,2))
    }

    override fun derecha(): Boolean {
        return moverDerechaIzquierda_3x3(this, intArrayOf(2,2, 2,2, 2,2), 1)
    }

    override fun izquierda(): Boolean {
        return moverDerechaIzquierda_3x3(this, intArrayOf(-2, -2,-2, -2,-2, -2), -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_O_v5
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

    override fun puedeRotar(nuevaOrientacion: Int): Boolean {
        return false
    }

    override fun clonar(): Pieza {
        return Pieza_O_v5(this.fila, this.columna)
    }
}