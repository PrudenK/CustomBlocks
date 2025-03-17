package com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcMascara
import com.pruden.tetris_2.Metodos.DibujarTablero.General.paresImparesTableroTipo3y4

fun dibujarTableroNormalTIPO3(){
    dibujarTableroNormalTIPO1()
    ponerMascaraTableroTIPO3()
}

fun ponerMascaraTableroTIPO3(){
    with(cPrin){
        gcMascara.clearRect(0.0,0.0, canvasMascara.width,canvasMascara.height)

        val clipWidth = (Globales.COLUMNAS * Globales.TAMANO_CELDA).toDouble()

        gcMascara.fill = FONDO

        for (fila in paresImparesTableroTipo3y4 until Globales.FILAS step 2) {
            val yPosition = fila * Globales.TAMANO_CELDA
            gcMascara.fillRect(1.0, yPosition + 1.0, clipWidth - 1, Globales.TAMANO_CELDA - 1.0)
        }
    }
}


