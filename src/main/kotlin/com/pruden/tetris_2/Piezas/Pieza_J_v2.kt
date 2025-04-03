package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar3x3
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_3x3
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.condicionRotarEspecial
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Rotaciones.rotarNormal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_J_v2 (override var fila: Int, override var columna: Int,
                  override var orientacion : Int = 0, override var condicionEspecial_b : Boolean = false)
    : Piezas(fila, columna, orientacion, condicionEspecial_b) {

    private var columnaCentro = columna+1
    private var filaCentro = fila
    private val CENTRO = 328
    private val NUMPIEZA = 32
    private val COLOR = Color.web("ecffa9")

    private val FORMAS_J_v2 = arrayOf(
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA),
            intArrayOf(BLANCO, CENTRO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA)
        ), // 2 -> // 0
        arrayOf(
            intArrayOf(BLANCO, BLANCO, NUMPIEZA),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(NUMPIEZA, BLANCO, NUMPIEZA)
        ),// 3 -> // 1
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, CENTRO, BLANCO),
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA)
        ), // 0 // - > 2
        arrayOf(
            intArrayOf(NUMPIEZA, BLANCO, NUMPIEZA),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(NUMPIEZA, BLANCO, BLANCO)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, NUMPIEZA, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, BLANCO, CENTRO, BLANCO, BLANCO),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, BLANCO, BLANCO, BLANCO, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_J_v2 = 32
        const val CENTRO_J_v2 = 328
        val COLOR_J_v2 = Color.web("ecffa9")!!
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
            if (matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro + 1][columnaCentro + 1] == BLANCO) {
                return true
            } else {
                if (matrizNumerica[filaCentro + 1][columnaCentro] != BLANCO
                    || matrizNumerica[filaCentro + 1][columnaCentro + 1] != BLANCO) {
                    return condicionRotarEspecial(this, intArrayOf(-1,-2,-2,-2), intArrayOf(0,-1,0,1), false, -1)
                }
            }
        } else if (nuevaOrientacion == 1) {
            if (matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO
                && matrizNumerica[filaCentro + 1][columnaCentro - 1] == BLANCO) {
                return true
            } else {
                if (matrizNumerica[filaCentro][columnaCentro - 1] != BLANCO
                    || matrizNumerica[filaCentro + 1][columnaCentro - 1] != BLANCO) {
                    return condicionRotarEspecial(this, intArrayOf(-1,0,0,1), intArrayOf(2,2,1,2), true, 1)
                }
            }
        } else if (nuevaOrientacion == 2) {
            if (matrizNumerica[filaCentro - 1][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO) {
                return true
            } else {
                if (matrizNumerica[filaCentro - 1][columnaCentro - 1] != BLANCO
                    || matrizNumerica[filaCentro - 1][columnaCentro] != BLANCO) {
                    return condicionRotarEspecial(this, intArrayOf(1,2,2,2), intArrayOf(0,-1,0,1), false, 1)
                }
            }
        } else {
            if (matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro - 1][columnaCentro + 1] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO) {
                return true
            } else {
                if (matrizNumerica[filaCentro - 1][columnaCentro + 1] != BLANCO
                    || matrizNumerica[filaCentro][columnaCentro + 1] != BLANCO
                ) {
                    return condicionRotarEspecial(this, intArrayOf(-1, 0, 0, 1), intArrayOf(-2, -2, -1, -2), true, -1)
                }
            }
        }
        return false
    }

    override fun bajar(): Boolean {
        return bajar3x3(this, intArrayOf(0,0,2,2,0,2, 0,2,2,2,2,2, 2,2,1,1,2,2, 2,2,1,1,1,1))
    }

    override fun derecha(): Boolean {
       return moverDerechaIzquierda_3x3(this, intArrayOf(2,2,1,1,2,2, 1,1,1,1,2,2, 2,2,2,2,0,2, 0,2,2,2,0,0), 1)
    }

    override fun izquierda(): Boolean {
      return moverDerechaIzquierda_3x3(this, intArrayOf(-2,-2,-1,-1,-1,-1,  -2,-2,-1,-1,-2,-2,  0,0,-2,-2,-2,0,  -2,0,-2,-2,-2,-2), -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_J_v2
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
        return Pieza_J_v2(this.fila, this.columna)
    }
}