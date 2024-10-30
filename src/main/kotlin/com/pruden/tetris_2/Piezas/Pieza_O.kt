package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Metodos.BorrarPiezas.borrarLinea
import com.pruden.tetris_2.Metodos.Perder.comprbarPerder
import com.pruden.tetris_2.Metodos.Piezas.Limpiar.limpiarPieza
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarPieza
import javafx.scene.paint.Color

class Pieza_O(override var fila: Int, override var columna: Int) : Piezas(fila, columna) {
    private val CENTRO = 18
    private val NUMPIEZA = 1
    private val COLOR = Color.YELLOW


    private val FORMAS_O = arrayOf(
        arrayOf(
            intArrayOf(NUMPIEZA, NUMPIEZA),
            intArrayOf(NUMPIEZA, NUMPIEZA)
        )
    )

    companion object {
        const val NUMPIEZA_O = 1
        val COLOR_O = Color.YELLOW!!
    }


    override fun rotar(): Boolean {
        return true
    }

    override fun limpiar() {
        limpiarPieza(this)
    }

    override fun pintar() {
        pintarPieza(this)
    }


    override fun bajar(): Boolean {
        if (!(matrizNumerica[fila + 2][columna] != 0 || matrizNumerica[fila + 2][columna + 1] != 0)) {
            limpiar()
            fila += 1
            pintar()
            return false
        } else {
            pintar()
            borrarLinea()
            comprbarPerder()
            return true
        }
    }

    override fun derecha() {
        if (columna != COLUMNAS - 2) {
            if (!(matrizNumerica[fila][columna + 2] != 0 || matrizNumerica[fila + 1][columna + 2] != 0)) {
                limpiar()
                columna +=1
                pintar()
            }
        }
    }

    override fun izquierda() {
        if (columna > 0) {
            if (!(matrizNumerica[fila][columna - 1] != 0 || matrizNumerica[fila + 1][columna - 1] != 0)) {
                limpiar()
                columna -=1
                pintar()
            }
        }
    }


    override fun getForma(): Array<Array<IntArray>> {
        return FORMAS_O
    }

    override fun set_Orientacion(ori: Int) {
    }

    override fun getColumnaCentro(): Int {
        return columna
    }

    override fun getFilaCentro(): Int {
        return fila
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

    override fun getOrientacion(): Int {
        return 0
    }


}