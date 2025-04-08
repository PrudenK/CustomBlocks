package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar2x1
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.derecha_2x1
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.izquierda_2x1
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_Mini_I (override var fila: Int, override var columna: Int,
                    override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Pieza(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna + 1
    private var filaCentro = fila

    private val CENTRO = 378
    private val NUMPIEZA = 37
    private val COLOR = Color.web("#1686a4")

    private val FORMAS_MINI_I = arrayOf(
        arrayOf(
            intArrayOf(BLANCO, CENTRO),
            intArrayOf(BLANCO, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, CENTRO)
        ),
        arrayOf(
            intArrayOf(NUMPIEZA, BLANCO),
            intArrayOf(CENTRO, BLANCO)
        ),
        arrayOf(
            intArrayOf(CENTRO, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, CENTRO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_MINI_I = 37
        const val CENTRO_MINI_I = 378
        val COLOR_MINI_I= Color.web("#1686a4")!!
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
          if(filaCentro < Globales.FILAS-1){
              if (matrizNumerica[filaCentro +1][columnaCentro +1] == BLANCO){
                  true
              }else condicionRotarEspecial(this, intArrayOf(-1), intArrayOf(1),false, -1)
          }else condicionRotarEspecial(this, intArrayOf(-1), intArrayOf(1),false, -1)

        } else if (nuevaOrientacion == 1) {
            if(columnaCentro > 0){
                if (matrizNumerica[filaCentro +1][columnaCentro -1] == BLANCO){
                    true
                }else condicionRotarEspecial(this, intArrayOf(1), intArrayOf(1),true, 1)
            }else condicionRotarEspecial(this, intArrayOf(1), intArrayOf(1),true, 1)

        } else if (nuevaOrientacion == 2) {
            if (matrizNumerica[filaCentro -1][columnaCentro -1] == BLANCO){
                true
            }else condicionRotarEspecial(this, intArrayOf(-1), intArrayOf(1),false, 1)
        } else {
            if (columnaCentro < Globales.COLUMNAS-1){
                if (matrizNumerica[filaCentro -1][columnaCentro +1] == BLANCO){
                    true
                }else condicionRotarEspecial(this, intArrayOf(-1), intArrayOf(-1),true, -1)
            }else condicionRotarEspecial(this, intArrayOf(-1), intArrayOf(-1),true, -1)
        }
    }

    override fun bajar(): Boolean {
        return bajar2x1(this)
    }

    override fun derecha(): Boolean {
        return derecha_2x1(this)
    }

    override fun izquierda(): Boolean {
        return izquierda_2x1(this)
    }

    override fun getForma(): Array<Array<IntArray>> {
        return FORMAS_MINI_I
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
        return Pieza_Mini_I(this.fila, this.columna)
    }
}