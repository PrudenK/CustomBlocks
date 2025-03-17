package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar3x3
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_3x3
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_C (override var fila: Int, override var columna: Int,
               override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = CENTRO_BLANCO
    private val NUMPIEZA = 25
    private val COLOR = Color.web("fe5e27")

    private val FORMAS_C = arrayOf(
        arrayOf(
            intArrayOf(NUMPIEZA, BLANCO, NUMPIEZA),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA),
            intArrayOf(NUMPIEZA, CENTRO, BLANCO),
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(NUMPIEZA, BLANCO, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA),
            intArrayOf(BLANCO, CENTRO, NUMPIEZA),
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA)
        ),arrayOf(
            intArrayOf(BLANCO, BLANCO,BLANCO, BLANCO,BLANCO),
            intArrayOf(BLANCO, NUMPIEZA,BLANCO, NUMPIEZA,BLANCO),
            intArrayOf(BLANCO, NUMPIEZA,CENTRO, NUMPIEZA,BLANCO),
            intArrayOf(BLANCO, NUMPIEZA,NUMPIEZA, NUMPIEZA,BLANCO),
            intArrayOf(BLANCO, BLANCO,BLANCO, BLANCO,BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_C = 25
        val COLOR_C = Color.web("fe5e27")!!
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
        return rotarNormal(this,4)
    }

    override fun puedeRotar(nuevaOrientacion: Int): Boolean {
        return if (nuevaOrientacion == 0) {
            matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO
        } else if (nuevaOrientacion == 1) {
            matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO
        } else if (nuevaOrientacion == 2) {
            matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO
        } else {
            matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO
        }
    }

    override fun bajar(): Boolean {
        return bajar3x3(this, intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 2, 2, 2, 2, 0, 2, 0, 2, 0, 2, 0, 2, 2, 2))
    }

    override fun derecha(): Boolean {
       return moverDerechaIzquierda_3x3(this, intArrayOf(0, 2, 0, 2, 2, 2, 2, 2, 0, 2, 0, 2, 2, 2, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2), 1)
    }

    override fun izquierda(): Boolean {
       return moverDerechaIzquierda_3x3(this, intArrayOf(0, -2, 0, -2, -2, -2, -2, -2, 0, -2, 0, -2, -2, -2, -2, -2, -2, -2, -2, -2, 0, 0, -2, -2), -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_C
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

}