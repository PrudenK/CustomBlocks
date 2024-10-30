package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.BorrarPiezas.borrarLinea
import com.pruden.tetris_2.Metodos.Perder.comprbarPerder
import com.pruden.tetris_2.Piezas.Pieza_U
import com.pruden.tetris_2.Piezas.Pieza_V
import com.pruden.tetris_2.Piezas.Piezas

fun bajar3x3(pieza: Piezas, desplazamientos: IntArray): Boolean {
    var puedeBajar = true
    if (pieza.getOrientacion() == 0) {
        puedeBajar = matrizNumerica[pieza.getFilaCentro() + desplazamientos[0]][pieza.getColumnaCentro() - 1] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[1]][pieza.getColumnaCentro() - 1] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[2]][pieza.getColumnaCentro()] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[3]][pieza.getColumnaCentro()] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[4]][pieza.getColumnaCentro() + 1] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[5]][pieza.getColumnaCentro() + 1] == BLANCO
    } else if (pieza.getOrientacion() == 2) {
        puedeBajar = matrizNumerica[pieza.getFilaCentro() + desplazamientos[6]][pieza.getColumnaCentro() - 1] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[7]][pieza.getColumnaCentro() - 1] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[8]][pieza.getColumnaCentro()] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[9]][pieza.getColumnaCentro()] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[10]][pieza.getColumnaCentro() + 1] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[11]][pieza.getColumnaCentro() + 1] == BLANCO
    } else if (pieza.getOrientacion() == 1) {
        puedeBajar = if (pieza is Pieza_U || pieza is Pieza_V) {
            matrizNumerica[pieza.getFilaCentro() + desplazamientos[14]][pieza.getColumnaCentro()] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[15]][pieza.getColumnaCentro()] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[16]][pieza.getColumnaCentro() + 1] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[17]][pieza.getColumnaCentro() + 1] == BLANCO
        } else {
            matrizNumerica[pieza.getFilaCentro() + desplazamientos[12]][pieza.getColumnaCentro() - 1] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[13]][pieza.getColumnaCentro() - 1] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[14]][pieza.getColumnaCentro()] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[15]][pieza.getColumnaCentro()] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[16]][pieza.getColumnaCentro() + 1] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[17]][pieza.getColumnaCentro() + 1] == BLANCO
        }
    } else if (pieza.getOrientacion() == 3) {
        puedeBajar = if (pieza is Pieza_U || pieza is Pieza_V) {
            matrizNumerica[pieza.getFilaCentro() + desplazamientos[18]][pieza.getColumnaCentro() - 1] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[19]][pieza.getColumnaCentro() - 1] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[20]][pieza.getColumnaCentro()] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[21]][pieza.getColumnaCentro()] == BLANCO
        } else {
            matrizNumerica[pieza.getFilaCentro() + desplazamientos[18]][pieza.getColumnaCentro() - 1] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[19]][pieza.getColumnaCentro() - 1] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[20]][pieza.getColumnaCentro()] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[21]][pieza.getColumnaCentro()] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[22]][pieza.getColumnaCentro() + 1] == BLANCO
                    && matrizNumerica[pieza.getFilaCentro() + desplazamientos[23]][pieza.getColumnaCentro() + 1] == BLANCO
        }
    }
    if (puedeBajar) {
        pieza.limpiar()
        pieza.fila = (pieza.fila + 1)
        pieza.pintar()
    } else {
        borrarLinea()
        comprbarPerder()
        return true
    }
    return false
}