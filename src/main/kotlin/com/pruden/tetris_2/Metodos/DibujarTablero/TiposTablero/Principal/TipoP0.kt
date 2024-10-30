package com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import javafx.scene.paint.Color

fun dibujarTableroNormalTIPO0() {
    ControladorPrincipal.gcPrincipal.stroke = Color.BLACK
    val offset = 0.5
    ControladorPrincipal.gcPrincipal.stroke = ControladorPrincipal.FONDO
    for (i in 0..ControladorPrincipal.FILAS) {
        val y: Double = i * ControladorPrincipal.TAMANO_CELDA + offset
        ControladorPrincipal.gcPrincipal.strokeLine(0.0, y, (ControladorPrincipal.COLUMNAS * ControladorPrincipal.TAMANO_CELDA).toDouble(), y)
    }

    // Dibujar las líneas verticales
    for (i in 0..ControladorPrincipal.COLUMNAS) {
        val x: Double = i * ControladorPrincipal.TAMANO_CELDA + offset
        ControladorPrincipal.gcPrincipal.strokeLine(x, 0.0, x, (ControladorPrincipal.FILAS * ControladorPrincipal.TAMANO_CELDA).toDouble())
    }
    ControladorPrincipal.gcPrincipal.stroke = Color.BLACK
    // Calcular el ancho y alto del tablero en píxeles
    val anchoTablero: Int = ControladorPrincipal.COLUMNAS * ControladorPrincipal.TAMANO_CELDA
    val altoTablero: Int = ControladorPrincipal.FILAS * ControladorPrincipal.TAMANO_CELDA

    // Calcular el desplazamiento en píxeles (2 celdas más abajo)
    val desplazamientoY: Int = 2 * ControladorPrincipal.TAMANO_CELDA

    // Línea superior desplazada 2 casillas hacia abajo
    ControladorPrincipal.gcPrincipal.strokeLine(0.0, desplazamientoY.toDouble(), anchoTablero.toDouble(), desplazamientoY.toDouble())
    // Línea inferior
    ControladorPrincipal.gcPrincipal.strokeLine(0.0, altoTablero.toDouble(), anchoTablero.toDouble(), altoTablero.toDouble())
    // Línea izquierda (sin desplazamiento)
    ControladorPrincipal.gcPrincipal.strokeLine(0.0, desplazamientoY.toDouble(), 0.0, altoTablero.toDouble())
    // Línea derecha (sin desplazamiento)
    ControladorPrincipal.gcPrincipal.strokeLine(anchoTablero.toDouble(), desplazamientoY.toDouble(), anchoTablero.toDouble(), altoTablero.toDouble())
}
