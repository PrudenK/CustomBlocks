package com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcMascara
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaNumFilas


fun dibujarTableroNormalTIPO2(){
    dibujarTableroNormalTIPO1()
    ponerMascaraTableroTIPO2()
}

fun ponerMascaraTableroTIPO2(){
    val clipHeight = alturaMascara() * Globales.TAMANO_CELDA
    val clipWidth = (Globales.COLUMNAS * Globales.TAMANO_CELDA).toDouble()

    val yPosition = (Globales.FILAS * Globales.TAMANO_CELDA) - clipHeight

    gcMascara.fill = FONDO // Cambia esto al color que desees
    gcMascara.fillRect(1.0, yPosition+1, clipWidth-1, clipHeight-1)
}

private fun alturaMascara() :Double{
    return 3.0 + listaNumFilas.indexOf(Globales.FILAS)
}