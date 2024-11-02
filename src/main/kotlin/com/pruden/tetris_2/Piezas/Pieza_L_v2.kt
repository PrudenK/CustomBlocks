package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar3x3
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_3x3
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_L_v2 (override var fila: Int, override var columna: Int,
                  override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = CENTRO_BLANCO
    private val NUMPIEZA = 13
    private val COLOR = Color.DEEPSKYBLUE

    private val FORMAS_L_v2 = arrayOf(
        arrayOf(
            intArrayOf(NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, CENTRO, BLANCO),
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA),
            intArrayOf(NUMPIEZA, CENTRO, BLANCO),
            intArrayOf(NUMPIEZA, BLANCO, BLANCO)
        ),
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA),
            intArrayOf(BLANCO, CENTRO, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, NUMPIEZA),
            intArrayOf(BLANCO, CENTRO, NUMPIEZA),
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA)
        )
    )

    companion object {
        const val NUMPIEZA_L_v2 = 13
        val COLOR_L_v2 = Color.DEEPSKYBLUE!!
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
        if (nuevaOrientacion == 0) {
            if (columnaCentro != COLUMNAS - 1) {
                return matrizNumerica[filaCentro - 1][columnaCentro - 1] == BLANCO
                        && matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO
            }
        } else if (nuevaOrientacion == 1) {
            if (filaCentro != FILAS - 1) {
                return matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO
                        && matrizNumerica[filaCentro - 1][columnaCentro + 1] == BLANCO
            }
        } else if (nuevaOrientacion == 2) {
            if (columnaCentro != 0) {
                return matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO
                        && matrizNumerica[filaCentro + 1][columnaCentro + 1] == BLANCO
            }
        } else {
            if (filaCentro != 0) {
                return matrizNumerica[filaCentro + 1][columnaCentro - 1] == BLANCO
                        && matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO
            }
        }
        return false
    }

    override fun bajar(): Boolean {
        return bajar3x3(this, intArrayOf(2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2))
    }

    override fun derecha(): Boolean {
       return moverDerechaIzquierda_3x3(this, intArrayOf(0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2),1)
    }

    override fun izquierda(): Boolean {
       return moverDerechaIzquierda_3x3(this, intArrayOf(-2, -2, -2, -2, -2, -2, -2, -2, 0, 0, 0, 0, -2, -2, -2, -2, -2, -2, 0, 0, 0, 0,-2, -2),-1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_L_v2
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