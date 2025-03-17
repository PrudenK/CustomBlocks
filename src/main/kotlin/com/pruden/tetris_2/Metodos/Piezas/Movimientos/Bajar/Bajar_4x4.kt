package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.BorrarPiezas.borrarLinea
import com.pruden.tetris_2.Metodos.Perder.comprbarPerder
import com.pruden.tetris_2.Piezas.Piezas

fun bajar4x4(pieza: Piezas, desplazamientos: IntArray): Boolean {
    with(pieza) {
        var puedeBajar = true
        if (orientacion == 0) {
            puedeBajar =
                matrizNumerica[getFilaCentro() + desplazamientos[0]][getColumnaCentro() - 1] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[1]][getColumnaCentro() - 1] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[2]][getColumnaCentro()] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[3]][getColumnaCentro()] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[4]][getColumnaCentro() + 1] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[5]][getColumnaCentro() + 1] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[6]][getColumnaCentro() + 2] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[7]][getColumnaCentro() + 2] == Globales.BLANCO
        } else if (orientacion == 2) {
            puedeBajar =
                matrizNumerica[getFilaCentro() + desplazamientos[8]][getColumnaCentro() - 2] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[9]][getColumnaCentro() - 2] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[10]][getColumnaCentro() - 1] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[11]][getColumnaCentro() - 1] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[12]][getColumnaCentro()] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[13]][getColumnaCentro()] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[14]][getColumnaCentro() + 1] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[15]][getColumnaCentro() + 1] == Globales.BLANCO
        } else if (orientacion == 1) {
            puedeBajar =
                matrizNumerica[getFilaCentro() + desplazamientos[16]][getColumnaCentro() - 2] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[17]][getColumnaCentro() - 2] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[18]][getColumnaCentro() - 1] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[19]][getColumnaCentro() - 1] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[20]][getColumnaCentro()] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[21]][getColumnaCentro()] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[22]][getColumnaCentro() + 1] == Globales.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[23]][getColumnaCentro() + 1] == Globales.BLANCO
        } else if (orientacion == 3) {
            puedeBajar = matrizNumerica[getFilaCentro() + desplazamientos[24]][getColumnaCentro() - 1] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + desplazamientos[25]][getColumnaCentro() - 1] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + desplazamientos[26]][getColumnaCentro()] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + desplazamientos[27]][getColumnaCentro()] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + desplazamientos[28]][getColumnaCentro() + 1] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + desplazamientos[29]][getColumnaCentro() + 1] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + desplazamientos[30]][getColumnaCentro() + 2] == Globales.BLANCO
                    && matrizNumerica[getFilaCentro() + desplazamientos[31]][getColumnaCentro() + 2] == Globales.BLANCO
        }
        if (puedeBajar) {
            limpiar()
            fila = (fila + 1)
            pintar()
        } else {
            borrarLinea()
            comprbarPerder()
            return true
        }
        return false
    }
}