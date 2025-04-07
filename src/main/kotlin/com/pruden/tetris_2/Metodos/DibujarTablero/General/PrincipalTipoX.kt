package com.pruden.tetris_2.Metodos.DibujarTablero.General

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal.*
import javafx.scene.shape.Rectangle


var paresImparesTableroTipo3y4 = 0

fun dibujarTableroPrincipal(){
    when (ControladorPrincipal.tipoTableroPrin) {
        0 -> dibujarTableroNormalTIPO0()
        1 -> dibujarTableroNormalTIPO1()
        2 -> dibujarTableroNormalTIPO2()
        3 -> dibujarTableroNormalTIPO3()
        4 -> dibujarTableroNormalTIPO4()
    }
}

fun cargarTablero(){
    with(ControladorPrincipal.cPrin){
        ControladorPrincipal.gcPrincipal.clearRect(0.0,0.0, canvasPrincipal.width, canvasPrincipal.height)
        canvasPrincipal.clip = Rectangle(0.0, (Globales.TAMA_MASCARA * Globales.TAMANO_CELDA).toDouble(), canvasPrincipal.width, canvasPrincipal.height - Globales.TAMA_MASCARA * Globales.TAMANO_CELDA)
    }
}

fun cambiarParesImparesTablero3y4(){
    paresImparesTableroTipo3y4 = (paresImparesTableroTipo3y4+1)%2
    dibujarTableroPrincipal()
}