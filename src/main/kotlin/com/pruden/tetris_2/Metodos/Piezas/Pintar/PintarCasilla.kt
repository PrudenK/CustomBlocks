package com.pruden.tetris_2.Metodos.Piezas.Pintar

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoPieza
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color



fun pintarCasilla(color : Color, fila : Double, columna : Double){
    pintarComun(gcPrincipal,color,fila,columna, Globales.TAMANO_CELDA.toDouble())
}

fun pintarCasillaSecun(gc : GraphicsContext, color : Color, fila : Double, columna : Double, tama : Double){
    pintarComun(gc,color,fila,columna, tama)
}


private fun pintarComun(gc : GraphicsContext, color : Color, fila : Double, columna : Double, tama : Double){
    var x = fila
    var y = columna

    if (fila < Globales.FILAS && columna < Globales.COLUMNAS) {
        x = columna * tama
        y = fila * tama // Aquí hago esta comprobación, ya que sí no entra en ese rango estamos hablando del tablero secundario de tipo 0 (sin rayas)
                                // por lo tanto, si entra tengo que hacer un ajuste.
    }

    gc.fill = color

    // Pintar la casilla
    if (color == FONDO) {
        gc.fillRect(x + 1, y + 1, (tama - 2), (tama - 2))
    } else {
        when (tipoPieza) {
            4 -> gc.fillRect(x + 1, y + 1, (tama - 2), (tama - 2))
            0 -> gc.fillOval(x + 1, y + 1, (tama - 2), (tama - 2))
            else -> poligono(y, x, tipoPieza, gc, tama.toInt())
        }
    }
}

