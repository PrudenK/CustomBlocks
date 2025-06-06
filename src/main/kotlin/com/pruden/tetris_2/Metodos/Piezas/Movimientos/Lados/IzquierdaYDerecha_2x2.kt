package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Pieza

fun moverDerecha_O_2x2(pieza: Pieza): Boolean{
    with(pieza){
        if (columna != Globales.COLUMNAS - 2) {
            if (!(matrizNumerica[fila][columna + 2] != 0 || matrizNumerica[fila + 1][columna + 2] != 0)) {
                limpiar()
                columna +=1
                pintar()
                return true
            }
        }
        return false
    }
}

fun moverIzquierda_O_2x2(pieza: Pieza): Boolean{
    with(pieza){
        if (columna > 0) {
            if (!(matrizNumerica[fila][columna - 1] != 0 || matrizNumerica[fila + 1][columna - 1] != 0)) {
                limpiar()
                columna -=1
                pintar()
                return true
            }
        }
        return false
    }
}

fun moverDerechaIzquierda_2x2(pieza: Pieza, desplazamientos: IntArray, direccion: Int) : Boolean { //1 o -1
    var puedeMoverse = true
    with(pieza){
        if (orientacion == 0) {
            puedeMoverse = matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[0]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[1]] == Globales.BLANCO
        } else if (orientacion == 2) {
            puedeMoverse = matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[2]] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[3]] == Globales.BLANCO

        } else if (orientacion == 1) {
            puedeMoverse = matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[4]] == Globales.BLANCO
                         && matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[5]] == Globales.BLANCO

        } else if (orientacion == 3) {
            puedeMoverse = matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[6]] == Globales.BLANCO
                         && matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[7]] == Globales.BLANCO
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna + direccion)
            pintar()
        }
    }
    return puedeMoverse
}