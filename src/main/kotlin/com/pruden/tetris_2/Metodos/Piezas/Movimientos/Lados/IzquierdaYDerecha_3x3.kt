package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Pieza_U
import com.pruden.tetris_2.Piezas.Pieza_V
import com.pruden.tetris_2.Piezas.Piezas
import javafx.scene.canvas.GraphicsContext

fun moverDerechaIzquierda_3x3(pieza: Piezas, desplazamientos: IntArray, direccion: Int) { //1 o -1
    var puedeMoverse = true
    if (pieza.getOrientacion() == 0) {
        puedeMoverse = if (pieza is Pieza_U || pieza is Pieza_V) {
            matrizNumerica[pieza.getFilaCentro() - 1][pieza.getColumnaCentro() + desplazamientos[0]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() - 1][pieza.getColumnaCentro() + desplazamientos[1]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[2]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[3]] == BLANCO
        } else {
            matrizNumerica[pieza.getFilaCentro() - 1][pieza.getColumnaCentro() + desplazamientos[0]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() - 1][pieza.getColumnaCentro() + desplazamientos[1]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[2]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[3]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + desplazamientos[4]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + desplazamientos[5]] == BLANCO
        }
    } else if (pieza.getOrientacion() == 2) {
        puedeMoverse = if (pieza is Pieza_U || pieza is Pieza_V) {
            matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[8]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[9]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + desplazamientos[10]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + desplazamientos[11]] == BLANCO
        } else {
            matrizNumerica[pieza.getFilaCentro() - 1][pieza.getColumnaCentro() + desplazamientos[6]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() - 1][pieza.getColumnaCentro() + desplazamientos[7]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[8]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[9]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + desplazamientos[10]] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + desplazamientos[11]] == BLANCO
        }
    } else if (pieza.getOrientacion() == 1) {
        puedeMoverse = matrizNumerica[pieza.getFilaCentro() - 1][pieza.getColumnaCentro() + desplazamientos[12]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() - 1][pieza.getColumnaCentro() + desplazamientos[13]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[14]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[15]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + desplazamientos[16]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + desplazamientos[17]] == BLANCO
    } else if (pieza.getOrientacion() == 3) {
        puedeMoverse = matrizNumerica[pieza.getFilaCentro() - 1][pieza.getColumnaCentro() + desplazamientos[18]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() - 1][pieza.getColumnaCentro() + desplazamientos[19]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[20]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro()][pieza.getColumnaCentro() + desplazamientos[21]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + desplazamientos[22]] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + 1][pieza.getColumnaCentro() + desplazamientos[23]] == BLANCO
    }
    if (puedeMoverse) {
        pieza.limpiar()
        pieza.columna = (pieza.columna + direccion)
        pieza.pintar()
    }
}