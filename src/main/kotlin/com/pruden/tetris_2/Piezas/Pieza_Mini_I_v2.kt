package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar2x2
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_2x2
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_Mini_I_v2 (override var fila: Int, override var columna: Int,
                       override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Pieza(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna + 1
    private var filaCentro = fila

    private val CENTRO = 408
    private val NUMPIEZA = 40
    private val COLOR = Color.web("#c659f6")

    private val FORMAS_MINI_I_v2 = arrayOf(
        arrayOf(
            intArrayOf(BLANCO, NUMPIEZA),
            intArrayOf(CENTRO, BLANCO)
        ),
        arrayOf(
            intArrayOf(CENTRO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(BLANCO, CENTRO),
            intArrayOf(NUMPIEZA, BLANCO)
        ),
        arrayOf(
            intArrayOf(NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, CENTRO)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, CENTRO, BLANCO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_MINI_I_v2 = 40
        const val CENTRO_MINI_I_v2 = 408
        val COLOR_MINI_I_v2 = Color.web("#c659f6")!!
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
        return rotarNormal(this, 4)
    }

    override fun puedeRotar(nuevaOrientacion: Int): Boolean {
        condicionEspecial_b = false
        return if (nuevaOrientacion == 0) {
            if (matrizNumerica[filaCentro][columnaCentro -1] == BLANCO
                && matrizNumerica[filaCentro-1][columnaCentro] == BLANCO){
                true
            }else condicionRotarEspecial(this, intArrayOf(-1), intArrayOf(1),true, 1)

        } else if (nuevaOrientacion == 1) {
            if (matrizNumerica[filaCentro][columnaCentro +1] == BLANCO
                && matrizNumerica[filaCentro-1][columnaCentro] == BLANCO){
                true
            }else condicionRotarEspecial(this, intArrayOf(-1), intArrayOf(-1),true, -1)

        } else if (nuevaOrientacion == 2) {
            if (matrizNumerica[filaCentro][columnaCentro +1] == BLANCO
                && matrizNumerica[filaCentro+1][columnaCentro] == BLANCO){
                true
            }else condicionRotarEspecial(this, intArrayOf(0), intArrayOf(2),true, 1)

        } else {
            if (matrizNumerica[filaCentro][columnaCentro -1] == BLANCO &&
                matrizNumerica[filaCentro +1][columnaCentro] == BLANCO){
                true
            }else condicionRotarEspecial(this, intArrayOf(0), intArrayOf(-2),true, -1)

        }
    }

    override fun bajar(): Boolean {
        return bajar2x2(this, intArrayOf(1,0, 2,1, 1,2, 0,1))
    }

    override fun derecha(): Boolean {
        return moverDerechaIzquierda_2x2(this, intArrayOf(2,1, 1,0, 1,2, 0,1), 1)
    }

    override fun izquierda(): Boolean {
        return moverDerechaIzquierda_2x2(this, intArrayOf(0,-1, -1,-2, -1,0, -2, -1), -1)
    }

    override fun getForma(): Array<Array<IntArray>> {
        return FORMAS_MINI_I_v2
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

    override fun clonar(): Pieza {
        return Pieza_Mini_I_v2(this.fila, this.columna)
    }
}