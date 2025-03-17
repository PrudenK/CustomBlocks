package com.pruden.tetris_2.Metodos.Piezas.Movimientos.Bajar


import com.pruden.tetris_2.Constantes.ConstantesPiezas
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.BorrarPiezas.borrarLinea
import com.pruden.tetris_2.Metodos.Perder.comprbarPerder
import com.pruden.tetris_2.Piezas.Piezas

fun bajar2x2(pieza : Piezas, desplazamientos: IntArray ): Boolean{
    with(pieza) {
        var puedeBajar = true
        if (orientacion == 0) {
            puedeBajar =
                matrizNumerica[getFilaCentro() + desplazamientos[0]][getColumnaCentro()] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[1]][getColumnaCentro() +1] == ConstantesPiezas.BLANCO
        } else if (orientacion == 2) {
            puedeBajar =
                matrizNumerica[getFilaCentro() + desplazamientos[2]][getColumnaCentro() - 1] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[3]][getColumnaCentro()] == ConstantesPiezas.BLANCO
        } else if (orientacion == 1) {
            puedeBajar =
                matrizNumerica[getFilaCentro() + desplazamientos[4]][getColumnaCentro()] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[5]][getColumnaCentro() + 1] == ConstantesPiezas.BLANCO
        } else if (orientacion == 3) {
            puedeBajar =
                matrizNumerica[getFilaCentro() + desplazamientos[6]][getColumnaCentro() - 1] == ConstantesPiezas.BLANCO
                        && matrizNumerica[getFilaCentro() + desplazamientos[7]][getColumnaCentro()] == ConstantesPiezas.BLANCO
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