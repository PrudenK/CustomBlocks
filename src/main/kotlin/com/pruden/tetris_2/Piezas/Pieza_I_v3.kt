package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar_5x1
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_5x1
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_I_v3 (override var fila: Int, override var columna: Int,
                  override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = 238
    private val NUMPIEZA = 23
    private val COLOR =  Color.web("#bdebff")

    private val FORMAS_I_v3 = arrayOf(
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, NUMPIEZA, CENTRO, NUMPIEZA, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        ), arrayOf(
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, CENTRO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO, BLANCO)
        ),arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, NUMPIEZA, CENTRO, NUMPIEZA, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_I_v3 = 23
        const val CENTRO_I_v3 = 238
        val COLOR_I_v3 =  Color.web("#bdebff")!!
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

    override fun puedeRotar(nuevaOrientacion: Int): Boolean {
        condicionEspecial_b = false
        return if (nuevaOrientacion == 0) {
            if (columnaCentro != 0 && columnaCentro != 1 && columnaCentro != Globales.COLUMNAS - 1 && columnaCentro != Globales.COLUMNAS - 2) {
                if (matrizNumerica[filaCentro][columnaCentro - 2] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro + 2] == BLANCO) {
                    true
                } else {
                    if (matrizNumerica[filaCentro][columnaCentro - 2] != BLANCO
                        || matrizNumerica[filaCentro][columnaCentro - 1] != BLANCO) {
                        if (matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO) {
                            condicionRotarEspecial(this,intArrayOf(0, 0, 0, 0),intArrayOf(-1, 1, 2, 3), true, 1)
                        } else condicionRotarEspecial(this,intArrayOf(0, 0, 0, 0),intArrayOf(1, 2, 3, 4), true, 2)
                    } else {
                        if (matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO) {
                            condicionRotarEspecial(this,intArrayOf(0, 0, 0, 0),intArrayOf(1, -1, -2, -3), true, -1)
                        } else condicionRotarEspecial(this,intArrayOf(0, 0, 0, 0),intArrayOf(-1, -2, -3, -4), true, -2)
                    }
                }
            } else {
                if (columnaCentro == 0) {
                    condicionRotarEspecial(this,intArrayOf(0, 0, 0, 0),intArrayOf(1, 2, 3, 4), true, 2)
                } else if (columnaCentro == 1) {
                    if (matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO) {
                        condicionRotarEspecial(this,intArrayOf(0, 0, 0, 0),intArrayOf(-1, 1, 2, 3), true, 1)
                    } else condicionRotarEspecial(this,intArrayOf(0, 0, 0, 0),intArrayOf(1, 2, 3, 4), true, 2)
                } else if (columnaCentro == Globales.COLUMNAS - 1) {
                    condicionRotarEspecial(this,intArrayOf(0, 0, 0, 0),intArrayOf(-1, -2, -3, -4), true, -2)
                } else {
                    if (matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO) {
                        condicionRotarEspecial(this,intArrayOf(0, 0, 0, 0),intArrayOf(1, -1, -2, -3), true, -1)
                    } else condicionRotarEspecial(this,intArrayOf(0, 0, 0, 0),intArrayOf(-1, -2, -3, -4), true, -2)
                }
            }
        } else {
            if (filaCentro != 0 && filaCentro != 1 && filaCentro != Globales.FILAS - 1 && filaCentro != Globales.FILAS - 2) {
                if (matrizNumerica[filaCentro - 2][columnaCentro] == BLANCO
                    && matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO
                    && matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO
                    && matrizNumerica[filaCentro + 2][columnaCentro] == BLANCO) {
                    true
                } else {
                    if (matrizNumerica[filaCentro + 1][columnaCentro] != BLANCO
                        || matrizNumerica[filaCentro + 2][columnaCentro] != BLANCO) {
                        if (matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO) {
                            condicionRotarEspecial(this,intArrayOf(1, -1, -2, -3),intArrayOf(0, 0, 0, 0), false, -1)
                        } else condicionRotarEspecial(this,intArrayOf(-1, -2, -3, -4),intArrayOf(0, 0, 0, 0), false, -2)
                    } else {
                        if (matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO) {
                            condicionRotarEspecial(this,intArrayOf(-1, 1, 2, 3),intArrayOf(0, 0, 0, 0), false, 1)
                        } else condicionRotarEspecial(this,intArrayOf(1, 2, 3, 4),intArrayOf(0, 0, 0, 0), false, 2)
                    }
                }
            } else {
                if (filaCentro == 0) {
                    condicionRotarEspecial(this,intArrayOf(1, 2, 3, 4),intArrayOf(0, 0, 0, 0), false, 2)
                } else if (filaCentro == 1) {
                    condicionRotarEspecial(this,intArrayOf(-1, 1, 2, 3),intArrayOf(0, 0, 0, 0), false, 1)
                } else if (filaCentro == Globales.FILAS - 1) {
                    condicionRotarEspecial(this,intArrayOf(-1, -2, -3, -4),intArrayOf(0, 0, 0, 0), false, -2)
                } else {
                    if (matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO) {
                        condicionRotarEspecial(this,intArrayOf(1, -1, -2, -3),intArrayOf(0, 0, 0, 0), false, -1)
                    } else condicionRotarEspecial(this,intArrayOf(-1, -2, -3, -4),intArrayOf(0, 0, 0, 0), false, -2)
                }
            }
        }
    }

    override fun bajar(): Boolean {
        return bajar_5x1(this)
    }

    override fun derecha(): Boolean {
       return moverDerechaIzquierda_5x1(this, 1)
    }

    override fun izquierda(): Boolean {
       return moverDerechaIzquierda_5x1(this, -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_I_v3
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
        return Pieza_I_v3(this.fila, this.columna)
    }
}