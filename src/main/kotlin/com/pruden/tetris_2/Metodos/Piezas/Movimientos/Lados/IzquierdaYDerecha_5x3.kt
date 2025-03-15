package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Piezas.Piezas

// esto funcionará así pq no voy a hacer piezas de 5x3 de este estilo
/*
    01110
    10001 (esta misma rotada 90º)
    01110
 */


fun moverDerechaIzquierda5x3(pieza: Piezas, desplazamientos: IntArray, direccion: Int) : Boolean { //1 o -1
    var puedeMoverse = true
    with(pieza){
        if (orientacion == 0) {
            puedeMoverse = ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[0]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[1]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[2]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[3]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[4]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[5]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()+1][getColumnaCentro() + desplazamientos[6]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()+1][getColumnaCentro() + desplazamientos[7]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()+1][getColumnaCentro() + desplazamientos[8]] == ControladorPrincipal.BLANCO
        } else if (orientacion == 2) {
            puedeMoverse = ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[9]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[10]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[11]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[12]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[13]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[14]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[15]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[16]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[17]] == ControladorPrincipal.BLANCO

        } else if (orientacion == 1) {
            puedeMoverse = ControladorPrincipal.matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + desplazamientos[18]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[19]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[20]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[21]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + desplazamientos[22]] == ControladorPrincipal.BLANCO
        } else if (orientacion == 3) {
            puedeMoverse = ControladorPrincipal.matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + desplazamientos[23]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[24]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[25]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[26]] == ControladorPrincipal.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + desplazamientos[27]] == ControladorPrincipal.BLANCO
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna + direccion)
            pintar()
        }
    }
    return puedeMoverse
}