package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar_3x2
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_3x2
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_T (override var fila: Int, override var columna: Int,
               override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = 38
    private val NUMPIEZA = 3
    private val COLOR = Color.BLUEVIOLET

    private val FORMAS_T = arrayOf(
        arrayOf(
            intArrayOf(BLANCO, NUMPIEZA, BLANCO),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, BLANCO)
        ),
        arrayOf(
            intArrayOf(BLANCO, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, CENTRO, NUMPIEZA),
            intArrayOf(BLANCO, NUMPIEZA, BLANCO)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(BLANCO, NUMPIEZA, BLANCO)
        ),
        arrayOf(
            intArrayOf(BLANCO, NUMPIEZA, BLANCO),
            intArrayOf(NUMPIEZA, CENTRO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_T = 3
        const val CENTRO_T = 38
        val COLOR_T = Color.BLUEVIOLET!!
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
        condicionEspecial_b = false
        return if (nuevaOrientacion == 0) {
            if (columnaCentro != COLUMNAS - 1) {
                if (matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO) {
                    true
                } else condicionRotarEspecial(this,intArrayOf(-1, 0),intArrayOf(-1, -2), true, -1)
            } else condicionRotarEspecial(this,intArrayOf(-1, 0),intArrayOf(-1, -2), true, -1)
        } else if (nuevaOrientacion == 1) {
            if (filaCentro != FILAS - 1) {
                if (matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO) {
                    true
                } else condicionRotarEspecial(this,intArrayOf(-2, -1),intArrayOf(0, 1), false, -1)
            } else condicionRotarEspecial(this,intArrayOf(-2, -1),intArrayOf(0, 1), false, -1)
        } else if (nuevaOrientacion == 2) {
            if (columnaCentro != 0) {
                if (matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO) {
                    true
                } else condicionRotarEspecial(this,intArrayOf(1, 0),intArrayOf(1, 2), true, +1)
            } else condicionRotarEspecial(this,intArrayOf(1, 0),intArrayOf(1, 2), true, +1)
        } else {
            if (filaCentro != 0) {
                if (matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO) {
                    true
                } else condicionRotarEspecial(this,intArrayOf(1, 2),intArrayOf(-1, 0), false, +1)
            } else condicionRotarEspecial(this,intArrayOf(1, 2),intArrayOf(-1, 0), false, +1)
        }
    }
    override fun bajar(): Boolean {
        return bajar_3x2(this, intArrayOf(1, 1, 1, 1, 2, 1, 2, 1, 2, 1))
    }

    override fun derecha(): Boolean {
       return moverDerechaIzquierda_3x2(this, intArrayOf(2, 1, 2, 1, 1, 2, 1, 1, 1, 1), 1)
    }

    override fun izquierda(): Boolean {
       return moverDerechaIzquierda_3x2(this, intArrayOf(-2, -1, -2, -1, -1, -1, -1, -1, -2, -1), -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_T
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