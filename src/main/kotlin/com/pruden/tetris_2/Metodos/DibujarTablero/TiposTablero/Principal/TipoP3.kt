package com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMANO_CELDA
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.controladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcMascara
import com.pruden.tetris_2.Metodos.DibujarTablero.General.paresImparesTableroTipo3y4

fun dibujarTableroNormalTIPO3(){
    dibujarTableroNormalTIPO1()
    ponerMascaraTableroTIPO3()
}

fun ponerMascaraTableroTIPO3(){
    with(controladorPrincipal){
        gcMascara.clearRect(0.0,0.0, canvasMascara.width,canvasMascara.height)

        val clipWidth = (COLUMNAS * TAMANO_CELDA).toDouble()

        gcMascara.fill = FONDO

        for (fila in paresImparesTableroTipo3y4 until FILAS step 2) {
            val yPosition = fila * TAMANO_CELDA
            gcMascara.fillRect(1.0, yPosition + 1.0, clipWidth - 1, TAMANO_CELDA - 1.0)
        }
    }
}


