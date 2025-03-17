package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar3x3
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_3x3
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_Twin_O_v2 (override var fila: Int, override var columna: Int,
                       override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = 498
    private val NUMPIEZA = 49
    private val COLOR = Color.web("#ede5b6")

    private val FORMAS_TWIN_O_v2 = arrayOf(
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA, BLANCO),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(NUMPIEZA, NUMPIEZA, BLANCO)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, CENTRO, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_TWIN_O_v2 = 49
        const val CENTRO_TWIN_O_v2 = 498
        val COLOR_TWIN_O_v2 = Color.web("#ede5b6")!!
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
        return rotarNormal(this,2)
    }
    // TODO, de momento sin rotaciones especiales superiores
    override fun puedeRotar(nuevaOrientacion: Int): Boolean {
        condicionEspecial_b = false
        return if (nuevaOrientacion == 0) {
            if (matrizNumerica[filaCentro - 1][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro + 1][columnaCentro + 1] == BLANCO
            ) {
                true
            } else condicionRotarEspecial(this,intArrayOf(-1, -2, -2),intArrayOf(-1, -1, 0), false, -1)
        } else {
            if (matrizNumerica[filaCentro - 1][columnaCentro + 1] == BLANCO
                && matrizNumerica[filaCentro+1][columnaCentro - 1] == BLANCO) {
                true
            } else condicionRotarEspecial(this,intArrayOf(-1, -2, -2),intArrayOf(1,1, 0), false, -1)
        }
    }
    override fun bajar(): Boolean {
        return bajar3x3(this, intArrayOf(1,1, 2,2, 2,2, -7,-7, -7,-7, -7,-7, 2,2, 2,2, 1,1))
    }

    override fun derecha(): Boolean {
        return moverDerechaIzquierda_3x3(this, intArrayOf(1,1, 2,2, 2,2, -7,-7, -7,-7, -7,-7, 2,2, 2,2, 1,1), 1)
    }

    override fun izquierda(): Boolean {
        return moverDerechaIzquierda_3x3(this, intArrayOf(-2,-2, -2,-2, -1,-1, -7,-7, -7,-7, -7,-7, -1,-1, -2,-2, -2,-2), -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_TWIN_O_v2
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