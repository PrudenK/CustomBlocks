package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.BorrarPiezas.borrarLinea
import com.pruden.tetris_2.Metodos.Perder.comprbarPerder
import com.pruden.tetris_2.Piezas.Piezas


fun bajar_3x2(pieza: Piezas, desplazamientos: IntArray): Boolean {
    var puedeBajar = true
    if (pieza.getOrientacion() == 0) {
        puedeBajar = matrizNumerica[pieza.getFilaCentro() + desplazamientos[0]][pieza.getColumnaCentro() - 1] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[1]][pieza.getColumnaCentro()] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[2]][pieza.getColumnaCentro() + 1] == BLANCO
    } else if (pieza.getOrientacion() == 2) {
        puedeBajar = matrizNumerica[pieza.getFilaCentro() + desplazamientos[3]][pieza.getColumnaCentro() - 1] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[4]][pieza.getColumnaCentro()] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[5]][pieza.getColumnaCentro() + 1] == BLANCO
    } else if (pieza.getOrientacion() == 1) {
        puedeBajar = matrizNumerica[pieza.getFilaCentro() + desplazamientos[6]][pieza.getColumnaCentro()] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[7]][pieza.getColumnaCentro() + 1] == BLANCO
    } else if (pieza.getOrientacion() == 3) {
        puedeBajar = matrizNumerica[pieza.getFilaCentro() + desplazamientos[8]][pieza.getColumnaCentro()] == BLANCO
                && matrizNumerica[pieza.getFilaCentro() + desplazamientos[9]][pieza.getColumnaCentro() - 1] == BLANCO
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