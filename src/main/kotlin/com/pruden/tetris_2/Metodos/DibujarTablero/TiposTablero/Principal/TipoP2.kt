package com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMANO_CELDA
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.controladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcMascara
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcPrincipal
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaNumFilas
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle


fun dibujarTableroNormalTIPO2(){
    dibujarTableroNormalTIPO1()
    ponerMascaraTableroTIPO2()
}

fun ponerMascaraTableroTIPO2(){
    with(controladorPrincipal){
        val clipHeight = alturaMascara() * TAMANO_CELDA
        val clipWidth = (COLUMNAS * TAMANO_CELDA).toDouble()

        val yPosition = (FILAS * TAMANO_CELDA) - clipHeight

        canvasMascara.clip = Rectangle(1.0, yPosition+1, clipWidth-1, clipHeight-1)

        gcMascara.fill = FONDO // Cambia esto al color que desees
        gcMascara.fillRect(1.0, yPosition+1, clipWidth-1, clipHeight-1)
    }
}

private fun alturaMascara() :Double{
    return 3.0 + listaNumFilas.indexOf(FILAS)
}