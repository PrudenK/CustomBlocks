package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar3x3
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_3x3
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_V (override var fila: Int, override var columna: Int,
               override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = 318
    private val NUMPIEZA = 31
    private val COLOR = Color.web("#947cff")

    private val FORMAS_V = arrayOf(
        arrayOf(
            intArrayOf(NUMPIEZA, BLANCO, NUMPIEZA),
            intArrayOf(BLANCO, CENTRO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, NUMPIEZA),
            intArrayOf(BLANCO, CENTRO, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, CENTRO, BLANCO),
            intArrayOf(NUMPIEZA, BLANCO, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, CENTRO, BLANCO),
            intArrayOf(NUMPIEZA, BLANCO, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_V = 31
        const val CENTRO_V = 318
        val COLOR_V = Color.web("#947cff")!!
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
                if (matrizNumerica[filaCentro - 1][columnaCentro + 1] == BLANCO) {
                    true
                } else condicionRotarEspecial(this,intArrayOf(-1, -1, 0),intArrayOf(0, -2, -1), true, -1)
            } else condicionRotarEspecial(this,intArrayOf(-1, -1, 0),intArrayOf(0, -2, -1), true, -1)
        } else if (nuevaOrientacion == 1) {
            if (filaCentro != FILAS - 1) {
                if (matrizNumerica[filaCentro + 1][columnaCentro + 1] == BLANCO) {
                    true
                } else condicionRotarEspecial(this,intArrayOf(0, -1, -2),intArrayOf(1, 0, 1), false, -1)
            } else condicionRotarEspecial(this,intArrayOf(0, -1, -2),intArrayOf(1, 0, 1), false, -1)
        } else if (nuevaOrientacion == 2) {
            if (columnaCentro != 0) {
                if (matrizNumerica[filaCentro + 1][columnaCentro - 1] == BLANCO) {
                    true
                } else condicionRotarEspecial(this,intArrayOf(1, 0, 1),intArrayOf(0, 1, 2), true, 1)
            } else condicionRotarEspecial(this,intArrayOf(1, 0, 1),intArrayOf(0, 1, 2), true, 1)
        } else {
            if (filaCentro != 0) {
                if (matrizNumerica[filaCentro - 1][columnaCentro - 1] == BLANCO) {
                    true
                } else condicionRotarEspecial(this,intArrayOf(0, 1, 2),intArrayOf(-1, 0, -1), false, 1)
            } else condicionRotarEspecial(this,intArrayOf(0, 1, 2),intArrayOf(-1, 0, -1), false, 1)
        }
    }

    override fun bajar(): Boolean {
        return bajar3x3(this, intArrayOf(0, 0, 1, 1, 0, 0, 2, 2, 1, 1, 2, 2, -7, -7, 1, 1, 0, 2, 0, 2, 1, 1, -7, -7))
    }

    override fun derecha(): Boolean {
       return moverDerechaIzquierda_3x3(this, intArrayOf(0, 2, 1, 1, -7, -7, -7, -7, 1, 1, 2, 0, 2, 2, 1, 1, 2, 2, 0, 0, 1, 1, 0, 0), 1)
    }

    override fun izquierda(): Boolean {
       return moverDerechaIzquierda_3x3(this, intArrayOf(0, -2, -1, -1, -7, -7, -7, -7, -1, -1, -2, 0, 0, 0, -1, -1, 0, 0, -2, -2, -1, -1, -2, -2), -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_V
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