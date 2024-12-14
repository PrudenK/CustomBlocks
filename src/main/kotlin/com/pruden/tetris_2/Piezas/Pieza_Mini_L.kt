package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar2x2
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_2x2
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_Mini_L (override var fila: Int, override var columna: Int,
                    override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna + 1
    private var filaCentro = fila

    private val CENTRO = 398
    private val NUMPIEZA = 39
    private val COLOR = Color.web("#127c23")

    private val FORMAS_MINI_L = arrayOf(
        arrayOf(
            intArrayOf(NUMPIEZA, BLANCO),
            intArrayOf(CENTRO, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(CENTRO, NUMPIEZA),
            intArrayOf(NUMPIEZA, BLANCO)
        ),
        arrayOf(
            intArrayOf(NUMPIEZA, CENTRO),
            intArrayOf(BLANCO, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(BLANCO, NUMPIEZA),
            intArrayOf(NUMPIEZA, CENTRO)
        )
    )

    companion object {
        const val NUMPIEZA_MINI_L = 39
        const val CENTRO_MINI_L = 398
        val COLOR_MINI_L = Color.web("#127c23")!!
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
            if (matrizNumerica[filaCentro -1][columnaCentro -1] == BLANCO){
                true
            }else condicionRotarEspecial(this, intArrayOf(0), intArrayOf(1),true, 1)
                    || condicionRotarEspecial(this, intArrayOf(1,1), intArrayOf(-1,0), false, 1)
        } else if (nuevaOrientacion == 1) {
            if (matrizNumerica[filaCentro -1][columnaCentro +1] == BLANCO){
                true
            }else condicionRotarEspecial(this, intArrayOf(0, -1), intArrayOf(-1, -1),true, -1)
                    || condicionRotarEspecial(this, intArrayOf(0), intArrayOf(1), false, 1)
        } else if (nuevaOrientacion == 2) {
            if (matrizNumerica[filaCentro +1][columnaCentro +1] == BLANCO){
                true
            }else condicionRotarEspecial(this, intArrayOf(-1,-1), intArrayOf(0,1),false, -1)
                    || condicionRotarEspecial(this, intArrayOf(0), intArrayOf(-1),true, -1)
        } else {
            if (matrizNumerica[filaCentro +1][columnaCentro -1] == BLANCO){
                true
            }else condicionRotarEspecial(this, intArrayOf(-1), intArrayOf(0),false, -1)
                    || condicionRotarEspecial(this, intArrayOf(0,1), intArrayOf(1,1),true, 1)
        }
    }

    override fun bajar(): Boolean {
        return bajar2x2(this, intArrayOf(1,1, 1,2, 2,1, 1,1))
    }

    override fun derecha(): Boolean {
        return moverDerechaIzquierda_2x2(this, intArrayOf(1,2, 1,1, 2,1, 1,1), 1)
    }

    override fun izquierda(): Boolean {
        return moverDerechaIzquierda_2x2(this, intArrayOf(-1,-1, -2,-1, -1,-1, -1, -2), -1)
    }

    override fun getForma(): Array<Array<IntArray>> {
        return FORMAS_MINI_L
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