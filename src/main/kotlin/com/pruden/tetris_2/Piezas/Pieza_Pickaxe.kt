package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar3x3
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_3x3
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_Pickaxe (override var fila: Int, override var columna: Int,
                     override var orientacion : Int = 2, override var condicionEspecial_b : Boolean = false)
    : Pieza(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = Globales.CENTRO_PIEZA_PICO
    private val NUMPIEZA = 53
    private val NUMPIEZA_AUX = Globales.NUMPIEZA_PICO
    private val COLOR = Color.web("#7bf3f5")

    private val FORMAS_PICKAXE = arrayOf(
        arrayOf(
            intArrayOf(NUMPIEZA, BLANCO, NUMPIEZA_AUX),
            intArrayOf(NUMPIEZA, CENTRO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA),
            intArrayOf(NUMPIEZA, CENTRO, BLANCO),
            intArrayOf(NUMPIEZA, BLANCO, NUMPIEZA_AUX)
        ),
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, CENTRO, NUMPIEZA),
            intArrayOf(NUMPIEZA_AUX, BLANCO, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(NUMPIEZA_AUX, BLANCO, NUMPIEZA),
            intArrayOf(BLANCO, CENTRO, NUMPIEZA),
            intArrayOf(NUMPIEZA, NUMPIEZA, BLANCO)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, CENTRO, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA_AUX, BLANCO, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_PICKAXE = 53
        const val CENTRO_PICKAXE = 538
        val COLOR_PICKAXE = Color.web("#7bf3f5")
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
            if(matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro + 1][columnaCentro + 1] == BLANCO){
                true
            }else{
                if(matrizNumerica[filaCentro + 1][columnaCentro + 1] != BLANCO){
                    condicionRotarEspecial(this,intArrayOf(-2,-2),intArrayOf(-1,1), false, - 1)
                }else condicionRotarEspecial(this,intArrayOf(),intArrayOf(), true, 1)
            }
        } else if (nuevaOrientacion == 1) {
            if(matrizNumerica[filaCentro + 1][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO){
                true
            }else{
                condicionRotarEspecial(this,intArrayOf(-2,-2),intArrayOf(0,1), false, - 1)
            }
        } else if (nuevaOrientacion == 2) {
            if(matrizNumerica[filaCentro - 1][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO){
                true
            }else{
                if(matrizNumerica[filaCentro - 1][columnaCentro - 1] != BLANCO){
                    condicionRotarEspecial(this,intArrayOf(),intArrayOf(), true,  1)
                }else condicionRotarEspecial(this,intArrayOf(),intArrayOf(), true,  -1)
            }
        } else {
            if(matrizNumerica[filaCentro - 1][columnaCentro + 1] == BLANCO
                && matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO){
                true
            }else{
                if(matrizNumerica[filaCentro + 1][columnaCentro] != BLANCO){
                    condicionRotarEspecial(this,intArrayOf(),intArrayOf(), false,  -1)
                }else condicionRotarEspecial(this,intArrayOf(),intArrayOf(), true,  -1)
            }
        }

    }


    override fun bajar(): Boolean {
        return bajar3x3(this, intArrayOf(1,1,2,2,2,0, 0,2,1,1,2,2, 2,2,1,1,2,0, 0,2,2,2,1,1))
    }

    override fun derecha(): Boolean {
        return moverDerechaIzquierda_3x3(this, intArrayOf(0,2,1,1,2,2,  1,1,2,2,0,2, 2,2,1,1,0,2, 0,2,2,2,1,1), 1)
    }

    override fun izquierda(): Boolean {
        return moverDerechaIzquierda_3x3(this, intArrayOf(0,-2,-2,-2,-1,-1, -2,-2,-1,-1,0,-2, -1,-1,-2,-2,0,-2, 0,-2,-1,-1,-2,-2), -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_PICKAXE
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
        return Pieza_Pickaxe(this.fila, this.columna)
    }
}