package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar_4x1
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.derecha_4x1
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.izquierda_4x1
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_I (override var fila: Int, override var columna: Int,
               override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = 28
    private val NUMPIEZA = 2
    private val COLOR = Color.CYAN

    private val FORMAS_I = arrayOf(
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, BLANCO, CENTRO, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO)
        ),
        arrayOf(
            intArrayOf(BLANCO, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, CENTRO, BLANCO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, BLANCO, BLANCO)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_I = 2
        const val CENTRO_I = 28
        val COLOR_I = Color.CYAN!!
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
            if (columnaCentro <= COLUMNAS - 3 && columnaCentro != 0) {
                if (matrizNumerica[filaCentro - 1][columnaCentro - 1] == BLANCO
                    && matrizNumerica[filaCentro - 1][columnaCentro + 1] == BLANCO
                    && matrizNumerica[filaCentro - 1][columnaCentro + 2] == BLANCO) {
                    true
                } else {
                    if (matrizNumerica[filaCentro - 1][columnaCentro + 1] != BLANCO) { // para el caso R0-2
                        return condicionRotarEspecial(this,intArrayOf(-1, -1, -1),intArrayOf(-1, -2, -3), true, -2)
                    } else if (matrizNumerica[filaCentro - 1][columnaCentro + 2] != 0) { // para el caso R0-1
                        return condicionRotarEspecial(this,intArrayOf(-1, -1, -1),intArrayOf(1, -1, -2), true, -1)
                    }
                    condicionRotarEspecial(this,intArrayOf(-1, -1, -1),intArrayOf(1, 2, 3), true, +1)
                }
            } else {
                if (columnaCentro == COLUMNAS - 2) {
                    if (matrizNumerica[filaCentro - 1][columnaCentro + 1] != BLANCO) {
                        condicionRotarEspecial(this,intArrayOf(-1, -1, -1),intArrayOf(-1, -2, -3), true, -2)
                    } else condicionRotarEspecial(this,intArrayOf(-1, -1, -1),intArrayOf(-1, -2, 1), true, -1)
                } else if (columnaCentro == COLUMNAS - 1) {
                    condicionRotarEspecial(this,intArrayOf(-1, -1, -1),intArrayOf(-1, -2, -3), true, -2)
                } else condicionRotarEspecial(this,intArrayOf(-1, -1, -1),intArrayOf(1, 2, 3), true, +1)
            }
        } else if (nuevaOrientacion == 1) {
            if (filaCentro <= FILAS - 3 && filaCentro != 0) {
                if (matrizNumerica[filaCentro - 1][columnaCentro + 1] == BLANCO
                    && matrizNumerica[filaCentro + 1][columnaCentro + 1] == BLANCO
                    && matrizNumerica[filaCentro + 2][columnaCentro + 1] == BLANCO) {
                    true
                } else {
                    if (matrizNumerica[filaCentro + 1][columnaCentro + 1] != BLANCO) { // R1-2
                        condicionRotarEspecial(this,intArrayOf(-1, -2, -3),intArrayOf(1, 1, 1), false, -2)
                    } else if (matrizNumerica[filaCentro + 2][columnaCentro + 1] != BLANCO) { // Para R1-1
                        condicionRotarEspecial(this,intArrayOf(1, -1, -2),intArrayOf(1, 1, 1), false, -1)
                    } else condicionRotarEspecial(this,intArrayOf(1, 2, 3),intArrayOf(1, 1, 1),  false, +1
                    ) // R1+1 (punto conflictivo (-1,1))
                }
            } else {
                if (filaCentro == FILAS - 2) {
                    if (matrizNumerica[filaCentro + 1][columnaCentro + 1] != BLANCO) { // R1-2
                        condicionRotarEspecial(this,intArrayOf(-1, -2, -3),intArrayOf(1, 1, 1), false, -2)
                    } else condicionRotarEspecial(this,intArrayOf(1, -1, -2),intArrayOf(1, 1, 1), false, -1)
                } else if (filaCentro == FILAS - 1) {
                    condicionRotarEspecial(this,intArrayOf(-1, -2, -3),intArrayOf(1, 1, 1), false, -2)
                } else condicionRotarEspecial(this,intArrayOf(-1, 1, 2),intArrayOf(1, 1, 1), false, +1)
            }
        } else if (nuevaOrientacion == 2) {
            if (columnaCentro >= 2 && columnaCentro != COLUMNAS - 1) {
                if (matrizNumerica[filaCentro + 1][columnaCentro - 2] == BLANCO
                    && matrizNumerica[filaCentro + 1][columnaCentro - 1] == BLANCO
                    && matrizNumerica[filaCentro + 1][columnaCentro + 1] == BLANCO) {
                    true
                } else {
                    if (matrizNumerica[filaCentro + 1][columnaCentro - 1] != BLANCO) { // R2+2
                        condicionRotarEspecial(this,intArrayOf(1, 1, 1),intArrayOf(1, 2, 3), true, +2)
                    } else if (matrizNumerica[filaCentro + 1][columnaCentro - 2] != 0) { // R2+1
                        condicionRotarEspecial(this,intArrayOf(1, 1, 1),intArrayOf(-1, 1, 2), true, +1)
                    } else condicionRotarEspecial(this,intArrayOf(1, 1, 1),intArrayOf(-1, -2, -3), true, -1)
                }
            } else {
                if (columnaCentro == 0) {
                    condicionRotarEspecial(this,intArrayOf(1, 1, 1),intArrayOf(1, 2, 3), true, +2)
                } else if (columnaCentro == 1) {
                    if (matrizNumerica[filaCentro + 1][columnaCentro - 1] != BLANCO) { // R2+2
                        condicionRotarEspecial(this,intArrayOf(1, 1, 1),intArrayOf(1, 2, 3), true, +2)
                    } else condicionRotarEspecial(this,intArrayOf(1, 1, 1),intArrayOf(-1, 1, 2), true, +1)
                } else condicionRotarEspecial(this,intArrayOf(1, 1, 1),intArrayOf(-1, -2, -3), true, -1)
            }
        } else {
            if (filaCentro >= 2 && filaCentro != FILAS - 1) {
                if (matrizNumerica[filaCentro + 1][columnaCentro - 1] == BLANCO
                    && matrizNumerica[filaCentro - 1][columnaCentro - 1] == BLANCO
                    && matrizNumerica[filaCentro - 2][columnaCentro - 1] == BLANCO) {
                    true
                } else {
                    if (matrizNumerica[filaCentro - 1][columnaCentro - 1] != BLANCO) {
                        condicionRotarEspecial(this,intArrayOf(1, 2, 3),intArrayOf(-1, -1, -1), false, +2)
                    } else if (matrizNumerica[filaCentro - 2][columnaCentro - 1] != BLANCO) {
                        condicionRotarEspecial(this,intArrayOf(-1, 1, 2),intArrayOf(-1, -1, -1), false, +1)
                    } else condicionRotarEspecial(this,intArrayOf(-1, -2, -3),intArrayOf(-1, -1, -1), false, -1)
                }
            } else {
                if (filaCentro == 0) { //Aquí omito una situación ilógica q en las otras si que tengo en cuenta
                    condicionRotarEspecial(this,intArrayOf(1, 2, 3),intArrayOf(-1, -1, -1), false, +2)
                } else if (filaCentro == 1) {
                    condicionRotarEspecial(this,intArrayOf(-1, 1, 2),intArrayOf(-1, -1, -1), false, +1)
                } else condicionRotarEspecial(this,intArrayOf(-1, -2, -3),intArrayOf(-1, -1, -1), false, -1)
            }
        }
    }
    override fun bajar(): Boolean {
        return bajar_4x1(this)
    }

    override fun derecha(): Boolean {
       return derecha_4x1(this)
    }

    override fun izquierda(): Boolean {
       return izquierda_4x1(this)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_I
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