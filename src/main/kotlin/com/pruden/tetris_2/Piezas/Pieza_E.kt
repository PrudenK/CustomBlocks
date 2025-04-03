package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar5x2
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda5x2
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_E (override var fila: Int, override var columna: Int,
               override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = 418
    private val NUMPIEZA = 41
    private val COLOR =  Color.web("#64ff00")

    private val FORMAS_E = arrayOf(
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, BLANCO, NUMPIEZA, BLANCO, NUMPIEZA),
            intArrayOf(NUMPIEZA, NUMPIEZA, CENTRO, NUMPIEZA, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        ), arrayOf(
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, CENTRO, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, NUMPIEZA, BLANCO)
        ), arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, NUMPIEZA, CENTRO, NUMPIEZA, NUMPIEZA),
            intArrayOf(NUMPIEZA, BLANCO, NUMPIEZA, BLANCO, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        ), arrayOf(
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, CENTRO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA, BLANCO, BLANCO)
        ), arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, BLANCO, NUMPIEZA, BLANCO, NUMPIEZA),
            intArrayOf(NUMPIEZA, NUMPIEZA, CENTRO, NUMPIEZA, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_E = 41
        const val CENTRO_E = 418
        val COLOR_E =  Color.web("#64ff00")!!
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
            if (columnaCentro < Globales.COLUMNAS-2 && columnaCentro != 1){
                if (matrizNumerica[filaCentro - 1][columnaCentro-2] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro-2] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro+1] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro+2] == BLANCO
                    && matrizNumerica[filaCentro-1][columnaCentro+2] == BLANCO) {
                    true
                } else {
                    try {
                        if(matrizNumerica[filaCentro][columnaCentro+1] == BLANCO
                            && matrizNumerica[filaCentro-1][columnaCentro+1] == BLANCO){
                            if(condicionRotarEspecial(this,intArrayOf(-1,-1,-1,0,0),intArrayOf(1,-1,-3,-2,-3), true, -1)){
                                true
                            }else{
                                condicionRotarEspecial(this,intArrayOf(-1,-1,-1,0,0,0),intArrayOf(-1,1,3,1,2,3), true, 1)
                            }
                        }else{
                            condicionRotarEspecial(this,intArrayOf(-1,-1,0,0,0),intArrayOf(-2,-4,-2,-3,-4), true, -2)
                        }
                    }catch (e: Exception) {
                        condicionRotarEspecial(this,intArrayOf(-1,-1,-1,0,0,0),intArrayOf(-1,1,3,1,2,3), true, 1)
                    }
                }
            }else{
                if (columnaCentro == Globales.COLUMNAS-1){
                    condicionRotarEspecial(this,intArrayOf(0,-1,0,0,-1),intArrayOf(-2,-2,-3,-4,-4), true, -2)
                }else if(columnaCentro == 1){
                    condicionRotarEspecial(this,intArrayOf(-1,-1,-1,0,0,0),intArrayOf(-1,1,3,1,2,3), true, 1)
                }
                else{
                    if(matrizNumerica[filaCentro][columnaCentro+1] != BLANCO
                        || matrizNumerica[filaCentro-1][columnaCentro+1] != BLANCO){
                        condicionRotarEspecial(this,intArrayOf(0,-1,0,0,-1),intArrayOf(-2,-2,-3,-4,-4), true, -2)
                    }else condicionRotarEspecial(this,intArrayOf(-1,0,-1,0,0,-1),intArrayOf(1,1,-1,-2,-3,-3), true, -1)
                }
            }

        } else if (nuevaOrientacion == 1){
            if (filaCentro < Globales.FILAS-2){
                if(matrizNumerica[filaCentro - 2][columnaCentro] == BLANCO
                    && matrizNumerica[filaCentro - 2][columnaCentro+1] == BLANCO
                    && matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO
                    && matrizNumerica[filaCentro + 2][columnaCentro] == BLANCO
                    && matrizNumerica[filaCentro + 2][columnaCentro+1] == BLANCO
                    ){
                    true
                }else {
                    if(matrizNumerica[filaCentro+1][columnaCentro] == BLANCO
                        && matrizNumerica[filaCentro+1][columnaCentro+1] == BLANCO){
                        condicionRotarEspecial(this, intArrayOf(1,1,-1,-2,-3,-3), intArrayOf(0,1,1,0,0,1), false, -1)
                    }else{
                        condicionRotarEspecial(this, intArrayOf(-2,-2,-3,-4,-4), intArrayOf(0,1,0,0,1), false, -2)
                    }
                }
            }else{
                if(filaCentro == Globales.FILAS-1){
                    condicionRotarEspecial(this, intArrayOf(-2,-2,-3,-4,-4), intArrayOf(0,1,0,0,1), false, -2)
                }else{
                    if(condicionRotarEspecial(this, intArrayOf(1,1,-1,-2,-3,-3), intArrayOf(0,1,1,0,0,1), false, -1)){
                        true
                    }else condicionRotarEspecial(this, intArrayOf(-2,-2,-3,-4,-4), intArrayOf(0,1,0,0,1), false, -2)
                }
            }
        }else if (nuevaOrientacion == 2){
            if (columnaCentro > 1 && columnaCentro != Globales.COLUMNAS-2){
                if (matrizNumerica[filaCentro][columnaCentro-2] == BLANCO
                    && matrizNumerica[filaCentro +1][columnaCentro-2] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro-1] == BLANCO
                    && matrizNumerica[filaCentro][columnaCentro+2] == BLANCO
                    && matrizNumerica[filaCentro+1][columnaCentro+2] == BLANCO
                ){
                    true
                }else {
                    try {
                        if(matrizNumerica[filaCentro][columnaCentro-1] == BLANCO
                            && matrizNumerica[filaCentro+1][columnaCentro-1] == BLANCO){
                            if(condicionRotarEspecial(this, intArrayOf(0,0,0,1,1,1), intArrayOf(-1,2,3,-1,1,3), true, 1)){
                                true
                            }else {
                                condicionRotarEspecial(this, intArrayOf(0,0,0,1,1,1), intArrayOf(-1,-2,-3,1,-1,-3), true, -1)
                            }
                        }else{
                            condicionRotarEspecial(this, intArrayOf(0,0,0,1,1), intArrayOf(2,3,4,2,4), true, 2)
                        }
                    }catch (e : Exception){
                        condicionRotarEspecial(this, intArrayOf(0,0,0,1,1,1), intArrayOf(-1,-2,-3,1,-1,-3), true, -1)
                    }
                }
            }else {
                if (columnaCentro == 0){
                    condicionRotarEspecial(this, intArrayOf(0,0,0,1,1), intArrayOf(2,3,4,2,4), true, 2)
                }else if(columnaCentro == Globales.COLUMNAS-2){
                    condicionRotarEspecial(this, intArrayOf(0,0,0,1,1,1), intArrayOf(-1,-2,-3,1,-1,-3), true, -1)
                }else {
                    if(matrizNumerica[filaCentro][columnaCentro-1] != BLANCO
                        || matrizNumerica[filaCentro+1][columnaCentro-1] != BLANCO){
                        condicionRotarEspecial(this, intArrayOf(0,0,0,1,1), intArrayOf(2,3,4,2,4), true, 2)
                    }else condicionRotarEspecial(this, intArrayOf(0,0,0,1,1,1), intArrayOf(-1,2,3,-1,1,3), true, 1)
                }
            }
        }else{
            if(filaCentro > 2 && filaCentro != Globales.FILAS-2){
                if(matrizNumerica[filaCentro-2][columnaCentro-1] == BLANCO
                    && matrizNumerica[filaCentro-2][columnaCentro] == BLANCO
                    && matrizNumerica[filaCentro-1][columnaCentro] == BLANCO
                    && matrizNumerica[filaCentro+2][columnaCentro] == BLANCO
                    && matrizNumerica[filaCentro+2][columnaCentro-1] == BLANCO
                    ){
                    true
                }else {
                    if (matrizNumerica[filaCentro+1][columnaCentro-1] != BLANCO){
                        condicionRotarEspecial(this, intArrayOf(-1,-2,-2,-3,-4,-4), intArrayOf(0,0,-1,0,0,-1), false, -2)
                    }else{
                        condicionRotarEspecial(this, intArrayOf(1,-1,-1,-2,-3,-3), intArrayOf(-1,-1,0,0,-1,0), false, -1)
                    }
                }
            }else{
                if (matrizNumerica[filaCentro+1][columnaCentro-1] != BLANCO){
                    condicionRotarEspecial(this, intArrayOf(-1,-2,-2,-3,-4,-4), intArrayOf(0,0,-1,0,0,-1), false, -2)
                }else{
                    condicionRotarEspecial(this, intArrayOf(1,-1,-1,-2,-3,-3), intArrayOf(-1,-1,0,0,-1,0), false, -1)
                }
                /*
                if(filaCentro == FILAS-2){

                }else{
                    false
                }

                 */
            }
        }
    }

    override fun bajar(): Boolean {
        return bajar5x2(this, intArrayOf(1,1,1,1,1,  2,1,2,1,2,  3,3,3,-1,1,3,  -1,1,3,3,3,3))
    }

    override fun derecha(): Boolean {
        return moverDerechaIzquierda5x2(this, intArrayOf(-1,1,3,3,3,3,  3,3,3,-1,1,3,  2,1,2,1,2,  1,1,1,1,1), 1)
    }

    override fun izquierda(): Boolean {
        return moverDerechaIzquierda5x2(this, intArrayOf(1,-1,-3,-3,-3,-3,  -3,-3,-3,1,-1,-3,  -1,-1,-1,-1,-1,  -2,-1,-2,-1,-2), -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_E
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
        return Pieza_E(this.fila, this.columna)
    }
}