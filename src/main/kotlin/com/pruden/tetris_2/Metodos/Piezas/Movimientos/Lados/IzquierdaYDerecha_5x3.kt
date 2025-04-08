package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Piezas.Pieza

// esto funcionará así pq no voy a hacer piezas de 5x3 de este estilo
/*
    01110
    10001 (esta misma rotada 90º)
    01110
 */


fun moverDerechaIzquierda5x3(pieza: Pieza, desplazamientos: IntArray, direccion: Int) : Boolean { //1 o -1
    var puedeMoverse = true
    with(pieza){
        if (orientacion == 0) {
            puedeMoverse = ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[0]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[1]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[2]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[3]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[4]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[5]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()+1][getColumnaCentro() + desplazamientos[6]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()+1][getColumnaCentro() + desplazamientos[7]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()+1][getColumnaCentro() + desplazamientos[8]] == Globales.BLANCO
        } else if (orientacion == 2) {
            puedeMoverse = ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[9]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[10]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[11]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[12]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[13]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[14]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[15]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[16]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[17]] == Globales.BLANCO

        } else if (orientacion == 1) {
            puedeMoverse = ControladorPrincipal.matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + desplazamientos[18]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[19]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[20]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[21]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + desplazamientos[22]] == Globales.BLANCO
        } else if (orientacion == 3) {
            puedeMoverse = ControladorPrincipal.matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + desplazamientos[23]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[24]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[25]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[26]] == Globales.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + desplazamientos[27]] == Globales.BLANCO
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna + direccion)
            pintar()
        }
    }
    return puedeMoverse
}