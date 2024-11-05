package com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal


import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMANO_CELDA
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
        val altura = ((FILAS-2) * TAMANO_CELDA)-1.0


        for (columna in paresImparesTableroTipo3y4 until COLUMNAS step 2) {
            val xPosition = columna * TAMANO_CELDA
            gcMascara.fill = FONDO

            gcMascara.fillRect(xPosition.toDouble()+1.0, TAMANO_CELDA*2.0+1, TAMANO_CELDA - 1.0, altura)

        }

    }

}
