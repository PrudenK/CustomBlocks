package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Lados

import com.pruden.tetris_2.Constantes.ConstantesPiezas
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
            puedeMoverse = ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[0]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[1]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[2]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[3]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[4]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[5]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()+1][getColumnaCentro() + desplazamientos[6]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()+1][getColumnaCentro() + desplazamientos[7]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()+1][getColumnaCentro() + desplazamientos[8]] == ConstantesPiezas.BLANCO
        } else if (orientacion == 2) {
            puedeMoverse = ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[9]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[10]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[11]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[12]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[13]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[14]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[15]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[16]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[17]] == ConstantesPiezas.BLANCO

        } else if (orientacion == 1) {
            puedeMoverse = ControladorPrincipal.matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + desplazamientos[18]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[19]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[20]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[21]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + desplazamientos[22]] == ConstantesPiezas.BLANCO
        } else if (orientacion == 3) {
            puedeMoverse = ControladorPrincipal.matrizNumerica[getFilaCentro() - 2][getColumnaCentro() + desplazamientos[23]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() - 1][getColumnaCentro() + desplazamientos[24]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro()][getColumnaCentro() + desplazamientos[25]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 1][getColumnaCentro() + desplazamientos[26]] == ConstantesPiezas.BLANCO
                    && ControladorPrincipal.matrizNumerica[getFilaCentro() + 2][getColumnaCentro() + desplazamientos[27]] == ConstantesPiezas.BLANCO
        }
        if (puedeMoverse) {
            limpiar()
            columna = (columna + direccion)
            pintar()
        }
    }
    return puedeMoverse
}