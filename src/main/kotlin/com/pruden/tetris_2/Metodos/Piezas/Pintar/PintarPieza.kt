package com.pruden.tetris_2.Metodos.Piezas.Pintar

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Piezas.Piezas
import javafx.scene.paint.Color

fun pintarPieza(pieza: Piezas) : IntArray{
    val forma = pieza.getForma()[pieza.orientacion]
    val filaColumna = IntArray(2)

    for (i in forma.indices) {
        for (j in forma[i].indices) {
            if (forma[i][j] != BLANCO) {
                if (forma[i][j] == pieza.getCentro()) {
                    if (pieza.getCentro() != 80) {
                        pintarCasilla(pieza.getColor(), (pieza.fila + i).toDouble(), (pieza.columna + j).toDouble())
                        matrizNumerica[pieza.fila + i][pieza.columna + j] = pieza.getCentro()
                    }
                    if (pieza.getCentro() == 777){
                        pintarCasilla(Color.CRIMSON, (pieza.fila + i).toDouble(), (pieza.columna + j).toDouble())
                    }
                    filaColumna[0] = pieza.fila + i
                    filaColumna[1] = pieza.columna + j

                } else {

                    pintarCasilla(pieza.getColor(), (pieza.fila + i).toDouble(), (pieza.columna + j).toDouble())
                    matrizNumerica[pieza.fila + i][pieza.columna + j] = pieza.getNumpieza()
                }
            }
        }
    }

    return filaColumna
}

