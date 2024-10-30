package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar.bajar3x3
import com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados.moverDerechaIzquierda_3x3
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_T_v2 (override var fila: Int, override var columna: Int) : Piezas(fila, columna) {
    private var orientacion = 0
    private var columnaCentro = columna+1
    private var filaCentro = fila

    private val CENTRO = 148
    private val NUMPIEZA = 14
    private val COLOR = Color.KHAKI

    val FORMAS_T_v2 = arrayOf(
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA),
            intArrayOf(BLANCO, CENTRO, BLANCO),
            intArrayOf(BLANCO, NUMPIEZA, BLANCO)
        ),
        arrayOf(
            intArrayOf(BLANCO, BLANCO, NUMPIEZA),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(BLANCO, BLANCO, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(BLANCO, NUMPIEZA, BLANCO),
            intArrayOf(BLANCO, CENTRO, BLANCO),
            intArrayOf(NUMPIEZA, NUMPIEZA, NUMPIEZA)
        ),
        arrayOf(
            intArrayOf(NUMPIEZA, BLANCO, BLANCO),
            intArrayOf(NUMPIEZA, CENTRO, NUMPIEZA),
            intArrayOf(NUMPIEZA, BLANCO, BLANCO)
        )
    )

    companion object {
        const val NUMPIEZA_T_v2 = 14
        const val CENTRO_T_v2 = 148
        val COLOR_T_v2 = Color.KHAKI!!
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
        // repito condiciones en algunas ya que esta pieza es irregular en sus rotaciones y tiene 2 tipos de rotaciones especiales por rotación
        condicionEspecial_b = false
        return if (nuevaOrientacion == 0) {
            if (matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO 
                && matrizNumerica[filaCentro - 1][columnaCentro + 1] == BLANCO
                && matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO) {
                true
            } else condicionRotar_especial( -2, -1, -2, 0, -2, 1, -1, 0, false, -1) ||
                    condicionRotar_especial( 1, 0, 2, 0, 2, 0, 2, 0, false, 1)
        } else if (nuevaOrientacion == 1) {
            if (matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO
                && matrizNumerica[filaCentro + 1][columnaCentro + 1] == BLANCO) {
                true
            } else condicionRotar_especial( 0, -1, 0, -2, 0, -2, 0, -2, true, -1) ||
                    condicionRotar_especial( 0, 1, -1, 2, 0, 2, 1, 2, true, 1)
        } else if (nuevaOrientacion == 2) {
            if (matrizNumerica[filaCentro - 1][columnaCentro] == BLANCO
                && matrizNumerica[filaCentro + 1][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro + 1][columnaCentro] == BLANCO) {
                true
            } else (condicionRotar_especial( -1, 0, -2, 0, -2, 0, -2, 0, false, -1)
                    || condicionRotar_especial( 1, 0, 2, -1, 2, 0, 2, 1, false, +1))
        } else {
            if (matrizNumerica[filaCentro - 1][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro - 1] == BLANCO
                && matrizNumerica[filaCentro][columnaCentro + 1] == BLANCO) {
                true
            } else condicionRotar_especial( -1, -2, 0, -2, 1, -2, 0, -1, true, -1) ||
                    condicionRotar_especial( 0, 1, 0, 2, 0, 2, 0, 2, true, 1)
        }
    }

    override fun rotar(): Boolean {
        val nuevaOrientacion = (orientacion + 1) % 4
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
        return bajar3x3(this, intArrayOf(0,0, 2,2, 0,0, 2,2, 2,2, 2,2, 1,1, 1,1, 2,2, 2,2, 1,1, 1,1))
    }

    override fun derecha() {
        moverDerechaIzquierda_3x3(this, intArrayOf(2,2, 1,1, 1,1, 1,1, 1,1, 2,2, 2,2, 2,2, 2,2, 0,0, 2,2, 0,0), 1)
    }

    override fun izquierda() {
        moverDerechaIzquierda_3x3(this, intArrayOf(-2,-2, -1,-1, -1,-1, -1,-1, -1,-1, -2,-2, 0,0, -2,-2, 0,0, -2,-2, -2,-2, -2,-2), -1)
    }

    override fun getForma(): Array<Array<IntArray>>  {
        return FORMAS_T_v2
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