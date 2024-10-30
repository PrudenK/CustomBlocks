package com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import javafx.scene.paint.Color

fun dibujarTableroNormalTIPO1() {
    val desplazamiento = 0.5
    ControladorPrincipal.gcPrincipal.stroke = Color.BLACK

    for (i in 0..ControladorPrincipal.FILAS) {
        val y: Double = i * ControladorPrincipal.TAMANO_CELDA + desplazamiento
        ControladorPrincipal.gcPrincipal.strokeLine(0.0, y, (ControladorPrincipal.COLUMNAS * ControladorPrincipal.TAMANO_CELDA).toDouble(), y)
    }

    for (i in 0..ControladorPrincipal.COLUMNAS) {
        val x: Double = i * ControladorPrincipal.TAMANO_CELDA + desplazamiento
        ControladorPrincipal.gcPrincipal.strokeLine(x, 0.0, x, (ControladorPrincipal.FILAS * ControladorPrincipal.TAMANO_CELDA).toDouble())
    }
}