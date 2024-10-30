package com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Secundarios

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.CENTRO_BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMA_CELDA_SECUN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMA_TABLERO_SECUN
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarCasillaSecun
import com.pruden.tetris_2.Piezas.Piezas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color


fun dibujarTableroSecundarioTIPO1(gc: GraphicsContext) {
    // Dibujar las líneas horizontales
    gc.stroke = Color.BLACK
    for (i in 0..TAMA_TABLERO_SECUN.toInt()) {
        val y = i * TAMA_CELDA_SECUN
        gc.strokeLine(0.0, y, (TAMA_TABLERO_SECUN * TAMA_CELDA_SECUN), y)
    }
    // Dibujar las líneas verticales
    for (i in 0..TAMA_TABLERO_SECUN.toInt()) {
        val x = i * TAMA_CELDA_SECUN
        gc.strokeLine(x, 0.0, x, (TAMA_TABLERO_SECUN * TAMA_CELDA_SECUN))
    }
}

fun pintarPiezaTableroSecundarioTIPO1(gc: GraphicsContext, pieza : Piezas) {
    val forma = pieza.getForma()[pieza.orientacion]
    for (i in forma.indices) {
        for (j in forma[i].indices) {
            if (forma[i][j] != BLANCO && forma[i][j] != CENTRO_BLANCO) {
                if (forma[i][j] == pieza.getCentro()) {
                    pintarCasillaSecun(gc, pieza.getColor(), ( i).toDouble(), ( j).toDouble(), TAMA_CELDA_SECUN)
                } else {
                    pintarCasillaSecun(gc, pieza.getColor(), ( i).toDouble(), (j).toDouble(), TAMA_CELDA_SECUN)
                }
            }
        }
    }
}

/*
fun borrarSiguienteTIPO1(gc: GraphicsContext) {
    for (i in 0 until TAMA_TABLERO_SECUN.toInt()) {
        for (j in 0 until TAMA_TABLERO_SECUN.toInt()) {
            borrarCasillasSiguienteTIPO1(gc, i, j)
        }
    }
}

private fun borrarCasillasSiguienteTIPO1(gc: GraphicsContext, fila: Int, columna: Int) {
    if (fila < TAMA_TABLERO_SECUN && columna < TAMA_TABLERO_SECUN) {
        val x: Double = columna * TAMA_CELDA_SECUN
        val y: Double = fila * TAMA_CELDA_SECUN
        // Establecer el color de la casilla
        gc.fill = FONDO
        // Pintar la casilla
        gc.fillRect(x + 1, y + 1, TAMA_CELDA_SECUN - 2, TAMA_CELDA_SECUN - 2)
    }
}

 */



