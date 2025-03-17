package com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcMascara
import com.pruden.tetris_2.Metodos.DibujarTablero.General.paresImparesTableroTipo3y4

fun dibujarTableroNormalTIPO4(){
    dibujarTableroNormalTIPO1()
    ponerMascaraTableroTIPO4()
}

fun ponerMascaraTableroTIPO4(){
    with(cPrin){
        gcMascara.clearRect(0.0,0.0, canvasMascara.width,canvasMascara.height)
        val altura = ((Globales.FILAS-2) * Globales.TAMANO_CELDA)-1.0


        for (columna in paresImparesTableroTipo3y4 until Globales.COLUMNAS step 2) {
            val xPosition = columna * Globales.TAMANO_CELDA
            gcMascara.fill = FONDO

            gcMascara.fillRect(xPosition.toDouble()+1.0, Globales.TAMANO_CELDA*2.0+1, Globales.TAMANO_CELDA - 1.0, altura)

        }

    }

}
