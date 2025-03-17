package com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Secundarios

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.ALTURA_CANVAS_SECUN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.ANCHO_CANVAS_SECUN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMA_CELDA_SECUN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMA_TABLERO_SECUN
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarCasillaSecun
import com.pruden.tetris_2.Piezas.Piezas
import javafx.scene.canvas.GraphicsContext


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


fun pintarPiezaTableroSecundarioTIPO0(gc: GraphicsContext, pieza: Piezas) {
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
            if (forma[i][j] != Globales.BLANCO && forma[i][j] != Globales.CENTRO_BLANCO) {
                val x: Double = inicioX + j * TAMA_CELDA_SECUN
                val y: Double = inicioY + i * TAMA_CELDA_SECUN
                if(forma[i][j] == Globales.CENTRO_PIEZA_PICO || forma[i][j] == Globales.NUMPIEZA_PICO){
                    pintarCasillaSecun(gc,Globales.COLOR_MANGO_PICO,  x, y, TAMA_CELDA_SECUN)
                }else{
                    pintarCasillaSecun(gc,pieza.getColor(),  x, y, TAMA_CELDA_SECUN)
                }
            }
        }
    }
}

fun borrarTableroSecundarioTIPO0(gc: GraphicsContext) {
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