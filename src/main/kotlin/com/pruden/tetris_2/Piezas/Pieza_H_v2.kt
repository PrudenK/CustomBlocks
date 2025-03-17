package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar5x3
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda5x3
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_H_v2  (override var fila: Int, override var columna: Int,
                   override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = 528
    private val NUMPIEZA = 52
    private val COLOR =  Color.web("#f5b9b6")

    private val FORMAS_H_v2 = arrayOf(
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, BLANCO, BLANCO, BLANCO, NUMPIEZA),
            intArrayOf(NUMPIEZA, NUMPIEZA, CENTRO, NUMPIEZA, NUMPIEZA),
            intArrayOf(NUMPIEZA, BLANCO, BLANCO, BLANCO, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        ), arrayOf(
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, CENTRO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA, NUMPIEZA, BLANCO)
        ), arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, BLANCO, BLANCO, BLANCO, NUMPIEZA),
            intArrayOf(NUMPIEZA, NUMPIEZA, CENTRO, NUMPIEZA, NUMPIEZA),
            intArrayOf(NUMPIEZA, BLANCO, BLANCO, BLANCO, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_H_v2 = 52
        const val CENTRO_H_v2 = 528
        val COLOR_H_v2 =  Color.web("#f5b9b6")!!
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
            try {
                if (matrizNumerica[filaCentro - 1][columnaCentro - 2] == BLANCO
                    && matrizNumerica[filaCentro - 1][columnaCentro + 2] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro - 2] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro + 2] == BLANCO
                    && matrizNumerica[filaCentro + 1][columnaCentro - 2] == BLANCO
                    && matrizNumerica[filaCentro + 1][columnaCentro + 2] == BLANCO
                ) {
                    true
                } else {
                    if(matrizNumerica[filaCentro][columnaCentro + 1] != BLANCO){
                        condicionRotarEspecial(this,intArrayOf(-1,0,1,0,0,0),intArrayOf(-4,-4,-4,-3,-2,-1), true, -2)
                    }else{
                        if(matrizNumerica[filaCentro - 1][columnaCentro + 2] != BLANCO
                            || matrizNumerica[filaCentro][columnaCentro + 2] != BLANCO
                            || matrizNumerica[filaCentro + 1][columnaCentro + 2] != BLANCO
                            ){
                            if(matrizNumerica[filaCentro + 1][columnaCentro + 1] != BLANCO
                                || matrizNumerica[filaCentro - 1][columnaCentro + 1] != BLANCO
                                ){
                                condicionRotarEspecial(this,intArrayOf(-1,0,1,0,0,0),intArrayOf(-4,-4,-4,-3,-2,-1), true, -2)
                            }else{
                                condicionRotarEspecial(this,intArrayOf(-1,0,1,0,0),intArrayOf(-3,-3,-3,-2,-1), true, -1)
                            }
                        }else{
                            if(matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO){
                                if(matrizNumerica[filaCentro - 1][columnaCentro - 2] != BLANCO
                                    || matrizNumerica[filaCentro][columnaCentro - 2] != BLANCO
                                    || matrizNumerica[filaCentro + 1][columnaCentro - 2] != BLANCO
                                    ){
                                    if(matrizNumerica[filaCentro - 1][columnaCentro - 1] == BLANCO &&
                                        matrizNumerica[filaCentro + 1][columnaCentro - 1] == BLANCO
                                        ){
                                        condicionRotarEspecial(this,intArrayOf(-1,0,1,0,0),intArrayOf(3,3,3,2,1), true, 1)
                                    }else{
                                        condicionRotarEspecial(this,intArrayOf(-1,0,1,0,0,0),intArrayOf(4,4,4,3,2,1), true, 2)
                                    }
                                }else{
                                    false
                                }
                            }else{
                                condicionRotarEspecial(this,intArrayOf(-1,0,1,0,0,0),intArrayOf(4,4,4,3,2,1), true, 2)
                            }
                        }
                    }
                }
            }catch (e : Exception){
                if(columnaCentro == 1){
                    if(matrizNumerica[filaCentro - 1][columnaCentro - 1] == BLANCO &&
                        matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO &&
                        matrizNumerica[filaCentro + 1][columnaCentro - 1] == BLANCO
                        ){
                        condicionRotarEspecial(this,intArrayOf(-1,0,1,0,0),intArrayOf(3,3,3,2,1), true, 1)
                    }else{
                        condicionRotarEspecial(this,intArrayOf(-1,0,1,0,0,0),intArrayOf(4,4,4,3,2,1), true, 2)
                    }
                }else{
                    if(columnaCentro == Globales.COLUMNAS -2){
                        if(matrizNumerica[filaCentro - 1][columnaCentro + 1] == BLANCO &&
                            matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO &&
                            matrizNumerica[filaCentro + 1][columnaCentro + 1] == BLANCO
                        ){
                            condicionRotarEspecial(this,intArrayOf(-1,0,1,0,0),intArrayOf(-3,-3,-3,-2,-1), true, -1)
                        }else {
                            condicionRotarEspecial(this,intArrayOf(-1,0,1,0,0,0),intArrayOf(-4,-4,-4,-3,-2,-1), true, -2)
                        }
                    }else false
                }
            }

        } else {
            if (matrizNumerica[filaCentro - 2][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro - 2][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro - 2][columnaCentro + 1] == BLANCO
                && matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro + 2][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro + 2][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro + 2][columnaCentro + 1] == BLANCO
            ) {
                true
            } else{
                // sin rotaciones especiales arriba
                if(matrizNumerica[filaCentro + 1][columnaCentro - 1] == BLANCO &&
                    matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO &&
                    matrizNumerica[filaCentro + 1][columnaCentro + 1] == BLANCO
                    ){
                    condicionRotarEspecial(this,intArrayOf(-3,-3,-3,-2,-1),intArrayOf(-1,1,0,0,0), false, -1)
                }else{
                    condicionRotarEspecial(this,intArrayOf(-4,-4,-4,-3,-2,-1),intArrayOf(-1,0,1,0,0,0), false, -2)
                }
            }
        }

    }

    override fun bajar(): Boolean {
        return bajar5x3(this, intArrayOf(2,1,1,1,2,   -7,-7,-7,-7,-7,   3,3,-1,3,3,3,-1,3,3))
    }

    override fun derecha(): Boolean {
        return moverDerechaIzquierda5x3(this, intArrayOf(3,3,-1,3,3,3,-1,3,3,   -7,-7,-7,-7,-7,-7,-7,-7,-7, 2,1,1,1,2), 1)
    }

    override fun izquierda(): Boolean {
        return moverDerechaIzquierda5x3(this, intArrayOf(-3,-3,1,-3,-3,-3,1,-3,-3, -7,-7,-7,-7,-7,-7,-7,-7,-7, -2,-1,-1,-1,-2),-1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_H_v2
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