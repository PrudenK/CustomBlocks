package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar3x3
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_3x3
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_F  (override var fila: Int, override var columna: Int,
                override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = 198
    private val NUMPIEZA = 19
    private val COLOR = Color.LEMONCHIFFON

    private val FORMAS_F = arrayOf(
        arrayOf(
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA),
            intArrayOf(NUMPIEZA, CENTRO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, BLANCO)
        ),
        arrayOf(
            intArrayOf(BLANCO, NUMPIEZA, BLANCO),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(BLANCO, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, CENTRO, NUMPIEZA),
            intArrayOf(NUMPIEZA, NUMPIEZA, BLANCO)
        ),
        arrayOf(
            intArrayOf(NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(BLANCO, NUMPIEZA, BLANCO)
        ), arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_F = 19
        const val CENTRO_F = 198
        val COLOR_F = Color.LEMONCHIFFON!!
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
            if (matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO 
                && matrizNumerica[filaCentro - 1][columnaCentro + 1] == BLANCO) {
                true
            } else condicionRotarEspecial(this,intArrayOf(1, 2),intArrayOf(-1, 0), false, +1)
        } else if (nuevaOrientacion == 1) {
            if (matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO
                && matrizNumerica[filaCentro + 1][columnaCentro + 1] == BLANCO) {
                true
            } else condicionRotarEspecial(this,intArrayOf(-1, 0),intArrayOf(-1, -2), true, -1)
        } else if (nuevaOrientacion == 2) {
            if (matrizNumerica[filaCentro + 1][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO) {
                true
            } else condicionRotarEspecial(this,intArrayOf(-2, -1),intArrayOf(0, 1), false, -1)
        } else {
            if (matrizNumerica[filaCentro - 1][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO) {
                true
            } else condicionRotarEspecial(this,intArrayOf(0, 1),intArrayOf(2, 1), true, +1)
        }
    }
    override fun bajar(): Boolean {
        return bajar3x3(this, intArrayOf(1, 1, 2, 2, 0, 0, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1))
    }

    override fun derecha(): Boolean {
       return moverDerechaIzquierda_3x3(this, intArrayOf(2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 0, 0, 2, 2, 1, 1), 1)
    }

    override fun izquierda(): Boolean {
       return moverDerechaIzquierda_3x3(this, intArrayOf(-1, - 1, -2, - 2, -1, - 1, -1, - 1, -1, - 1, -2, - 2, -1, - 1, -2, - 2, 0, 0, -2, - 2, -2, - 2, -1, - 1), -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_F
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

    override fun clonar(): Piezas {
        return Pieza_F(this.fila, this.columna)
    }
}