package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar_3x1
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_3x1
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_I_v2 (override var fila: Int, override var columna: Int,
                  override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = 248
    private val NUMPIEZA = 24
    private val COLOR =  Color.web("#f776f7")

    private val FORMAS_I_v2 = arrayOf(
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, BLANCO)
        ), arrayOf(
            intArrayOf(BLANCO, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, CENTRO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_I_v2 = 24
        const val CENTRO_I_v2 = 248
        val COLOR_I_v2 =  Color.web("#f776f7")!!
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
            if (columnaCentro != 0 && columnaCentro != COLUMNAS - 1) {
                if (matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO) {
                    true
                } else condicionRotarEspecial(this,intArrayOf(0, 0),intArrayOf(-1, -2), true, -1) ||
                        condicionRotarEspecial(this,intArrayOf(0, 0),intArrayOf(1, 2), true, 1)
            } else {
                if (columnaCentro != 0) {
                    condicionRotarEspecial(this,intArrayOf(0, 0),intArrayOf(-1, -2), true, -1)
                } else condicionRotarEspecial(this,intArrayOf(0, 0),intArrayOf(1, 2), true, 1)
            }
        } else {
            if (filaCentro != 0 && filaCentro != FILAS - 1) {
                if (matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO
                    && matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO) {
                    true
                } else condicionRotarEspecial(this,intArrayOf(-1, -2),intArrayOf(0, 0), false, -1) ||
                        condicionRotarEspecial(this,intArrayOf(1, 2),intArrayOf(0, 0), false, 1)
            } else condicionRotarEspecial(this,intArrayOf(-1, -2),intArrayOf(0, 0), false, -1) ||
                    condicionRotarEspecial(this,intArrayOf(1, 2),intArrayOf(0, 0), false, 1)
        }
    }

    override fun bajar(): Boolean {
        return bajar_3x1(this)
    }

    override fun derecha(): Boolean {
       return moverDerechaIzquierda_3x1(this, 1)
    }

    override fun izquierda(): Boolean {
       return moverDerechaIzquierda_3x1(this, -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_I_v2
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