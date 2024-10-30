package com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.ALTURA_CANVAS_SECUN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.ANCHO_CANVAS_SECUN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.CENTRO_BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMANO_CELDA
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMA_CELDA_SECUN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMA_TABLERO_SECUN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcPrincipal
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarCasillaSecun
import com.pruden.tetris_2.Piezas.Piezas
import javafx.scene.canvas.GraphicsContext
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


fun dibujarTableroSecundarioTIPO0(gc: GraphicsContext) {
    gc.clearRect(0.0, 0.0, ANCHO_CANVAS_SECUN, ALTURA_CANVAS_SECUN)
    val tamanoTablero: Int = TAMA_TABLERO_SECUN.toInt() * TAMA_CELDA_SECUN.toInt()
    // Línea superior
    gc.strokeLine(0.0, 0.0, tamanoTablero.toDouble(), 0.0)
    // Línea inferior
    gc.strokeLine(0.0, tamanoTablero.toDouble(), tamanoTablero.toDouble(), tamanoTablero.toDouble())
    // Línea izquierda
    gc.strokeLine(0.0, 0.0, 0.0, tamanoTablero.toDouble())
    // Línea derecha
    gc.strokeLine(tamanoTablero.toDouble(), 0.0, tamanoTablero.toDouble(), tamanoTablero.toDouble())
}


fun pintarPiezaTableroTIPO0(gc: GraphicsContext, pieza: Piezas) {
    val forma = pieza.getForma()[pieza.orientacion]

    // Calcular el tamaño del tablero en píxeles
    val tamanoTableroEnPixeles: Int = TAMA_TABLERO_SECUN.toInt() * TAMA_CELDA_SECUN.toInt()

    // Calcular el centro del tablero en píxeles
    val centroTableroX = tamanoTableroEnPixeles / 2.0
    val centroTableroY = tamanoTableroEnPixeles / 2.0

    // Calcular el tamaño de la figura en píxeles
    val anchoFigura: Int = forma[0].size * TAMA_CELDA_SECUN.toInt()
    val altoFigura: Int = forma.size * TAMA_CELDA_SECUN.toInt()

    // Calcular la posición de inicio de la figura para centrarla en el tablero
    val inicioX = centroTableroX - anchoFigura / 2.0
    val inicioY = centroTableroY - altoFigura / 2.0

    // Dibujar la figura en el centro del tablero
    for (i in forma.indices) {
        for (j in forma[i].indices) {
            if (forma[i][j] != BLANCO && forma[i][j] != CENTRO_BLANCO) {
                val x: Double = inicioX + j * TAMA_CELDA_SECUN
                val y: Double = inicioY + i * TAMA_CELDA_SECUN
                pintarCasillaSecun(gc,pieza.getColor(),  x, y, TAMA_CELDA_SECUN)
            }
        }
    }
}

fun borrarSiguienteTIPO0(gc: GraphicsContext) {
    gc.clearRect(0.0, 0.0, TAMA_TABLERO_SECUN * TAMA_CELDA_SECUN - 1, TAMA_TABLERO_SECUN * TAMA_CELDA_SECUN - 1)
    val tamanoTablero: Int = TAMA_TABLERO_SECUN.toInt() * TAMA_CELDA_SECUN.toInt()
    // Dibujar el contorno del tablero (cuadrado)
    // Línea superior
    gc.strokeLine(0.0, 0.0, tamanoTablero.toDouble(), 0.0)
    // Línea inferior
    gc.strokeLine(0.0, tamanoTablero.toDouble(), tamanoTablero.toDouble(), tamanoTablero.toDouble())
    // Línea izquierda
    gc.strokeLine(0.0, 0.0, 0.0, tamanoTablero.toDouble())
    // Línea derecha
    gc.strokeLine(tamanoTablero.toDouble(), 0.0, tamanoTablero.toDouble(), tamanoTablero.toDouble())
}