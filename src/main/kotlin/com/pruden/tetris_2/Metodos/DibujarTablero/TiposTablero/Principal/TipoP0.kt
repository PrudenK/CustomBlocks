package com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMANO_CELDA
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcPrincipal
import javafx.scene.paint.Color

fun dibujarTableroNormalTIPO0() {
    gcPrincipal.stroke = Color.BLACK
    val offset = 0.5
    gcPrincipal.stroke = FONDO
    for (i in 0..FILAS) {
        val y: Double = i * TAMANO_CELDA + offset
        gcPrincipal.strokeLine(0.0, y, (COLUMNAS * TAMANO_CELDA).toDouble(), y)
    }

    // Dibujar las líneas verticales
    for (i in 0..COLUMNAS) {
        val x: Double = i * TAMANO_CELDA + offset
        gcPrincipal.strokeLine(x, 0.0, x, (FILAS * TAMANO_CELDA).toDouble())
    }
    gcPrincipal.stroke = Color.BLACK
    // Calcular el ancho y alto del tablero en píxeles
    val anchoTablero: Int = COLUMNAS * TAMANO_CELDA
    val altoTablero: Int = FILAS * TAMANO_CELDA

    // Calcular el desplazamiento en píxeles (2 celdas más abajo)
    val desplazamientoY: Int = 2 * TAMANO_CELDA

    // Línea superior desplazada 2 casillas hacia abajo
    gcPrincipal.strokeLine(0.0, desplazamientoY.toDouble(), anchoTablero.toDouble(), desplazamientoY.toDouble())
    // Línea inferior
    gcPrincipal.strokeLine(0.0, altoTablero.toDouble(), anchoTablero.toDouble(), altoTablero.toDouble())
    // Línea izquierda (sin desplazamiento)
    gcPrincipal.strokeLine(0.0, desplazamientoY.toDouble(), 0.0, altoTablero.toDouble())
    // Línea derecha (sin desplazamiento)
    gcPrincipal.strokeLine(anchoTablero.toDouble(), desplazamientoY.toDouble(), anchoTablero.toDouble(), altoTablero.toDouble())
}
