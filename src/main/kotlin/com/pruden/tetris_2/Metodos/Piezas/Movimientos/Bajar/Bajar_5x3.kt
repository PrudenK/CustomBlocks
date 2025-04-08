package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Metodos.BorrarPiezas.borrarLinea
import com.pruden.tetris_2.Metodos.Perder.comprbarPerder
import com.pruden.tetris_2.Piezas.Pieza

// esto funcionará así pq no voy a hacer piezas de 5x3 de este estilo
/*
    01110
    10001
    01110
 */

fun bajar5x3(pieza: Pieza, desplazamientos: IntArray): Boolean {
    with(pieza) {
        var puedeBajar = true
        if (orientacion == 0) {
            puedeBajar =
                ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[0]][getColumnaCentro() - 2] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[1]][getColumnaCentro() - 1] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[2]][getColumnaCentro()] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[3]][getColumnaCentro() + 1] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[4]][getColumnaCentro() + 2] == Globales.BLANCO
        } else if (orientacion == 2) {
            puedeBajar =
                ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[5]][getColumnaCentro() - 2] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[6]][getColumnaCentro() - 1] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[7]][getColumnaCentro()] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[8]][getColumnaCentro() + 1] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[9]][getColumnaCentro() + 2] == Globales.BLANCO
        } else if (orientacion == 1) {
            puedeBajar =
                ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[10]][getColumnaCentro()-1] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[11]][getColumnaCentro() - 1] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[12]][getColumnaCentro() - 1] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[13]][getColumnaCentro()] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[14]][getColumnaCentro()] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[15]][getColumnaCentro()] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[16]][getColumnaCentro()+1] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[17]][getColumnaCentro() + 1] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[18]][getColumnaCentro() + 1] == Globales.BLANCO
        } else if (orientacion == 3) {
            puedeBajar =
                ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[19]][getColumnaCentro()-1] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[20]][getColumnaCentro() - 1] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[21]][getColumnaCentro() - 1] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[22]][getColumnaCentro()] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[23]][getColumnaCentro()] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[24]][getColumnaCentro()] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[25]][getColumnaCentro()+1] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[26]][getColumnaCentro()+1] == Globales.BLANCO
                        && ControladorPrincipal.matrizNumerica[getFilaCentro() + desplazamientos[27]][getColumnaCentro()+1] == Globales.BLANCO

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