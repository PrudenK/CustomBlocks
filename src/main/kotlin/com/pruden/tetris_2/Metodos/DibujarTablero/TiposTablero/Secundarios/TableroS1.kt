package com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Secundarios

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMA_CELDA_SECUN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMA_TABLERO_SECUN
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarCasillaSecun
import com.pruden.tetris_2.Piezas.Pieza
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

fun pintarPiezaTableroSecundarioTIPO1(gc: GraphicsContext, pieza : Pieza) {
    val forma = pieza.getForma()[pieza.getForma().size-1]
    for (i in forma.indices) {
        for (j in forma[i].indices) {
            if (forma[i][j] != Globales.BLANCO && forma[i][j] != Globales.CENTRO_BLANCO) {
                if (forma[i][j] == pieza.getCentro()) {
                    if (pieza.getCentro() == Globales.CENTRO_PIEZA_PICO){
                        pintarCasillaSecun(gc, Globales.COLOR_MANGO_PICO, ( i).toDouble(), ( j).toDouble(), TAMA_CELDA_SECUN)
                    }else{
                        pintarCasillaSecun(gc, pieza.getColor(), ( i).toDouble(), ( j).toDouble(), TAMA_CELDA_SECUN)
                    }
                } else {
                    if(forma[i][j] == Globales.NUMPIEZA_PICO){
                        pintarCasillaSecun(gc, Globales.COLOR_MANGO_PICO, ( i).toDouble(), (j).toDouble(), TAMA_CELDA_SECUN)
                    }else{
                        pintarCasillaSecun(gc, pieza.getColor(), ( i).toDouble(), (j).toDouble(), TAMA_CELDA_SECUN)
                    }
                }
            }
        }
    }
}