package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar4x4
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_4x4
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_Twin_O(override var fila: Int, override var columna: Int,
                   override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = 448
    private val NUMPIEZA = 44
    private val COLOR = Color.web("#ECA8E8")

    private val FORMAS_TWIN_O = arrayOf(
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, CENTRO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, CENTRO, NUMPIEZA),
            intArrayOf(NUMPIEZA, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, NUMPIEZA, BLANCO, BLANCO)
        ),
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, CENTRO, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, NUMPIEZA),
            intArrayOf(NUMPIEZA, CENTRO, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, NUMPIEZA, BLANCO, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_TWIN_O = 44
        const val CENTRO_TWIN_O = 448
        val COLOR_TWIN_O = Color.web("#ECA8E8")!!
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
        condicionEspecial_b = false // todo: faltan esquinas superiores
        return if (nuevaOrientacion == 0) {
            if (matrizNumerica[filaCentro - 2][columnaCentro-1] == BLANCO
                && matrizNumerica[filaCentro - 2][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro - 1][columnaCentro-1] == BLANCO
                && matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro+1] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro+2] == BLANCO
                && matrizNumerica[filaCentro+1][columnaCentro+1] == BLANCO
                && matrizNumerica[filaCentro+1][columnaCentro+2] == BLANCO
                ) {
                true
            } else {
                if(matrizNumerica[filaCentro][columnaCentro+1] != BLANCO ||
                    matrizNumerica[filaCentro][columnaCentro+2] != BLANCO){
                    condicionRotarEspecial(this, intArrayOf(-4,-4,-3,-3), intArrayOf(-1,0,-1,0), false, -2)
                }else if(matrizNumerica[filaCentro+1][columnaCentro+1] != BLANCO){
                    condicionRotarEspecial(this, intArrayOf(-3,-3,-2,-2), intArrayOf(-1,0,-1,0), false, -1) ||
                            condicionRotarEspecial(this, intArrayOf(-2,-2,-1,-1), intArrayOf(-2,-3,-2,-3), true, -2)
                }else{
                    condicionRotarEspecial(this, intArrayOf(-3,-3,-2,-2), intArrayOf(-1,0,-1,0), false, -1)
                }
            }
        } else if (nuevaOrientacion == 1) {
            if (matrizNumerica[filaCentro-1][columnaCentro + 1] == BLANCO
                && matrizNumerica[filaCentro-1][columnaCentro + 2] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro + 2] == BLANCO
                && matrizNumerica[filaCentro+1][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro+1][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro+2][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro+2][columnaCentro] == BLANCO
                ) {
                true
            } else {
                if(matrizNumerica[filaCentro+1][columnaCentro-1] != BLANCO ||
                    matrizNumerica[filaCentro+1][columnaCentro] != BLANCO){
                    condicionRotarEspecial(this,intArrayOf(-3,-3,-2,-2), intArrayOf(1,2,1,2), false, -2)
                }else if(matrizNumerica[filaCentro+2][columnaCentro] != BLANCO){
                    condicionRotarEspecial(this,intArrayOf(-2,-2,-1,-1), intArrayOf(1,2,1,2), false, -1) ||
                            condicionRotarEspecial(this,intArrayOf(-1,0,-1,0), intArrayOf(3,3,4,4), true, 2)
                }else{
                    condicionRotarEspecial(this,intArrayOf(-2,-2,-1,-1), intArrayOf(1,2,1,2), false, -1)
                }
            }
        } else if (nuevaOrientacion == 2) {
            if (matrizNumerica[filaCentro - 1][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro - 1][columnaCentro - 2] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro - 2] == BLANCO
                && matrizNumerica[filaCentro+1][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro+1][columnaCentro +1] == BLANCO
                && matrizNumerica[filaCentro+2][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro+2][columnaCentro +1] == BLANCO
                ) {
                true
            } else {
                if(matrizNumerica[filaCentro+1][columnaCentro] != BLANCO ||
                    matrizNumerica[filaCentro+1][columnaCentro+1] != BLANCO){
                    condicionRotarEspecial(this,intArrayOf(-3,-3,-2,-2), intArrayOf(-1,-2,-1,-2), false, -2)
                }else if(matrizNumerica[filaCentro+2][columnaCentro] != BLANCO){
                    condicionRotarEspecial(this,intArrayOf(-2,-2,-1,-1), intArrayOf(-1,-2,-1,-2), false, -1) ||
                            condicionRotarEspecial(this,intArrayOf(-1,0,-1,0), intArrayOf(-3,-3,-4,-4), true, -2)
                }else{
                    condicionRotarEspecial(this,intArrayOf(-2,-2,-1,-1), intArrayOf(-1,-2,-1,-2), false, -1)
                }
            }
        } else {
            if (matrizNumerica[filaCentro - 2][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro-2][columnaCentro + 1] == BLANCO
                && matrizNumerica[filaCentro-1][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro-1][columnaCentro + 1] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro - 2] == BLANCO
                && matrizNumerica[filaCentro+1][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro+1][columnaCentro - 2] == BLANCO
                ) {
                true
            } else {
                if(matrizNumerica[filaCentro][columnaCentro-1] != BLANCO ||
                    matrizNumerica[filaCentro][columnaCentro-2] != BLANCO){
                    condicionRotarEspecial(this, intArrayOf(-4,-4,-3,-3), intArrayOf(1,0,1,0), false, -2)
                }else if(matrizNumerica[filaCentro+1][columnaCentro+1] != BLANCO){
                    condicionRotarEspecial(this, intArrayOf(-3,-3,-2,-2), intArrayOf(1,0,1,0), false, -1) ||
                            condicionRotarEspecial(this, intArrayOf(-2,-2,-1,-1), intArrayOf(2,3,2,3), true, 2)
                }else{
                    condicionRotarEspecial(this, intArrayOf(-3,-3,-2,-2), intArrayOf(1,0,1,0), false, -1)
                }
            }
        }
    }

    override fun bajar(): Boolean {
        return bajar4x4(this, intArrayOf(1,1, 1,1, 3,3, 3,3, 0,0, 0,0, 2,2, 2,2, 3,3, 3,3, 1,1, 1,1, 2,2, 2,2, 0,0, 0,0))
    }

    override fun derecha(): Boolean {
        return moverDerechaIzquierda_4x4(this, intArrayOf(1,1, 1,1, 3,3, 3,3, 0,0, 0,0, 2,2, 2,2, 2,2, 2,2, 0,0, 0,0, 3,3, 3,3, 1,1, 1,1), 1)
    }

    override fun izquierda(): Boolean {
        return moverDerechaIzquierda_4x4(this, intArrayOf(-2,-2, -2,-2, 0,0, 0,0, -3,-3, -3,-3, -1,-1, -1,-1,
            -1,-1, -1,-1, -3,-3, -3,-3, 0,0, 0,0, -2,-2, -2,-2), -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_TWIN_O
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