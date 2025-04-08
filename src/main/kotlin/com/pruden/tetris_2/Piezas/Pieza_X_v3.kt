package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar4x4
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_4x4
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_X_v3 (override var fila: Int, override var columna: Int,
                  override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Pieza(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = 468
    private val NUMPIEZA = 46
    private val COLOR = Color.web("#9b8f4d")

    private val FORMAS_X_v3 = arrayOf(
        arrayOf(
            intArrayOf(NUMPIEZA, BLANCO, BLANCO, NUMPIEZA),
            intArrayOf(BLANCO, CENTRO, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA, BLANCO),
            intArrayOf(NUMPIEZA, BLANCO, BLANCO, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, BLANCO, BLANCO, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, BLANCO, BLANCO, NUMPIEZA)
        )
    )

    companion object {
        const val NUMPIEZA_X_v3 = 46
        const val CENTRO_X_v3 = 468
        val COLOR_X_v3 = Color.web("#9b8f4d")!!
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
        return bajar4x4(this, intArrayOf(0,3, 2,2, 2,2, 0,3))
    }

    override fun derecha(): Boolean {
        return moverDerechaIzquierda_4x4(this, intArrayOf(0,3, 2,2, 2,2, 0,3), 1)
    }

    override fun izquierda(): Boolean {
        return moverDerechaIzquierda_4x4(this, intArrayOf(1,-2, -1,-1, -1,-1, 1,-2), -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_X_v3
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
        return Pieza_X_v3(this.fila, this.columna)
    }
}