package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar_5x1
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_5x1
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_I_v3 (override var fila: Int, override var columna: Int) : Piezas(fila, columna) {
    private var orientacion = 0
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


    private var condicionEspecial_b = false

    private fun condicionRotar_especial(d_f1: Int, d_c1: Int, d_f2: Int, d_c2: Int, d_f3: Int, d_c3: Int, d_f4: Int, d_c4: Int, 
                                        columna_bolean: Boolean, movimiento: Int): Boolean {
        return if (matrizNumerica[filaCentro + d_f1][columnaCentro + d_c1] == BLANCO 
            && matrizNumerica[filaCentro + d_f2][columnaCentro + d_c2] == BLANCO 
            && matrizNumerica[filaCentro + d_f3][columnaCentro + d_c3] == BLANCO 
            && matrizNumerica[filaCentro + d_f4][columnaCentro + d_c4] == BLANCO) {
            limpiar()
            if (columna_bolean) {
                columna += movimiento
            } else fila += movimiento
            condicionEspecial_b = true
            true
        } else false
    }

    private fun puedeRotar(nuevaOrientacion: Int): Boolean {
        condicionEspecial_b = false
        return if (nuevaOrientacion == 0) {
            if (columnaCentro != 0 && columnaCentro != 1 && columnaCentro != COLUMNAS - 1 && columnaCentro != COLUMNAS - 2) {
                if (matrizNumerica[filaCentro][columnaCentro - 2] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro + 2] == BLANCO) {
                    true
                } else {
                    if (matrizNumerica[filaCentro][columnaCentro - 2] != BLANCO
                        || matrizNumerica[filaCentro][columnaCentro - 1] != BLANCO) {
                        if (matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO) {
                            condicionRotar_especial( 0, -1, 0, 1, 0, 2, 0, 3, true, 1)
                        } else condicionRotar_especial( 0, 1, 0, 2, 0, 3, 0, 4, true, 2)
                    } else {
                        if (matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO) {
                            condicionRotar_especial( 0, 1, 0, -1, 0, -2, 0, -3, true, -1)
                        } else condicionRotar_especial( 0, -1, 0, -2, 0, -3, 0, -4, true, -2)
                    }
                }
            } else {
                if (columnaCentro == 0) {
                    condicionRotar_especial( 0, 1, 0, 2, 0, 3, 0, 4, true, 2)
                } else if (columnaCentro == 1) {
                    if (matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO) {
                        condicionRotar_especial( 0, -1, 0, 1, 0, 2, 0, 3, true, 1)
                    } else condicionRotar_especial( 0, 1, 0, 2, 0, 3, 0, 4, true, 2)
                } else if (columnaCentro == COLUMNAS - 1) {
                    condicionRotar_especial( 0, -1, 0, -2, 0, -3, 0, -4, true, -2)
                } else {
                    if (matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO) {
                        condicionRotar_especial( 0, 1, 0, -1, 0, -2, 0, -3, true, -1)
                    } else condicionRotar_especial( 0, -1, 0, -2, 0, -3, 0, -4, true, -2)
                }
            }
        } else {
            if (filaCentro != 0 && filaCentro != 1 && filaCentro != FILAS - 1 && filaCentro != FILAS - 2) {
                if (matrizNumerica[filaCentro - 2][columnaCentro] == BLANCO
                    && matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO
                    && matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO
                    && matrizNumerica[filaCentro + 2][columnaCentro] == BLANCO) {
                    true
                } else {
                    if (matrizNumerica[filaCentro + 1][columnaCentro] != BLANCO
                        || matrizNumerica[filaCentro + 2][columnaCentro] != BLANCO) {
                        if (matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO) {
                            condicionRotar_especial( 1, 0, -1, 0, -2, 0, -3, 0, false, -1)
                        } else condicionRotar_especial( -1, 0, -2, 0, -3, 0, -4, 0, false, -2)
                    } else {
                        if (matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO) {
                            condicionRotar_especial( -1, 0, 1, 0, 2, 0, 3, 0, false, 1)
                        } else condicionRotar_especial( 1, 0, 2, 0, 3, 0, 4, 0, false, 2)
                    }
                }
            } else {
                if (filaCentro == 0) {
                    condicionRotar_especial( 1, 0, 2, 0, 3, 0, 4, 0, false, 2)
                } else if (filaCentro == 1) {
                    condicionRotar_especial( -1, 0, 1, 0, 2, 0, 3, 0, false, 1)
                } else if (filaCentro == FILAS - 1) {
                    condicionRotar_especial( -1, 0, -2, 0, -3, 0, -4, 0, false, -2)
                } else {
                    if (matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO) {
                        condicionRotar_especial( 1, 0, -1, 0, -2, 0, -3, 0, false, -1)
                    } else condicionRotar_especial( -1, 0, -2, 0, -3, 0, -4, 0, false, -2)
                }
            }
        }
    }

    override fun rotar(): Boolean {
        val nuevaOrientacion = (orientacion + 1) % 2
        if (puedeRotar(nuevaOrientacion)) {
            if (!condicionEspecial_b) {
                limpiar()
            }
            orientacion = nuevaOrientacion
            pintar()
            return true
        }
        return false
    }


    override fun bajar(): Boolean {
        return bajar_5x1(this)
    }

    override fun derecha() {
        moverDerechaIzquierda_5x1(this, 1)
    }

    override fun izquierda() {
        moverDerechaIzquierda_5x1(this, -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_I_v3
    }

    override fun getOrientacion(): Int {
        return orientacion
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