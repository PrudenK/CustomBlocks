package com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import javafx.scene.paint.Color

fun dibujarTableroNormalTIPO1() {
    val desplazamiento = 0.5
    ControladorPrincipal.gcPrincipal.stroke = Color.BLACK

    for (i in 0..Globales.FILAS) {
        val y: Double = i * Globales.TAMANO_CELDA + desplazamiento
        ControladorPrincipal.gcPrincipal.strokeLine(0.0, y, (Globales.COLUMNAS * Globales.TAMANO_CELDA).toDouble(), y)
    }

    for (i in 0..Globales.COLUMNAS) {
        val x: Double = i * Globales.TAMANO_CELDA + desplazamiento
        ControladorPrincipal.gcPrincipal.strokeLine(x, 0.0, x, (Globales.FILAS * Globales.TAMANO_CELDA).toDouble())
    }
}