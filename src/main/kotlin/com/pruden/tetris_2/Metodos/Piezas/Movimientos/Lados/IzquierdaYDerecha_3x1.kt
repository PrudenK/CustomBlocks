package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Piezas
import javafx.scene.canvas.GraphicsContext

fun moverDerechaIzquierda_3x1(pieza: Piezas, dech_o_izq: Int) { //1 o -1
    var puedeMoverse = true
    puedeMoverse = if (pieza.orientacion == 0) {
        matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + 2 * dech_o_izq] == BLANCO
    } else {
        matrizNumerica[pieza.getFilaCentro() - 1][pieza.getColumnaCentro() + dech_o_izq] == BLANCO
                && matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + dech_o_izq] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + dech_o_izq] == BLANCO
    }
    if (puedeMoverse) {
        pieza.limpiar()
        pieza.columna = (pieza.columna + dech_o_izq)
        pieza.pintar()
    }
}