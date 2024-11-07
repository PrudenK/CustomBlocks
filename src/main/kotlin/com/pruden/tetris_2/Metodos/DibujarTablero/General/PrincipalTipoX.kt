package com.pruden.tetris_2.Metodos.DibujarTablero.General

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal.*
import javafx.scene.shape.Rectangle


var paresImparesTableroTipo3y4 = 0

fun dibujarTableroPrincipal(){
    if (ControladorPrincipal.tipoTableroPrin == 0){
        dibujarTableroNormalTIPO0()
    }else if (ControladorPrincipal.tipoTableroPrin == 1){
        dibujarTableroNormalTIPO1()
    }else if (ControladorPrincipal.tipoTableroPrin == 2){
        dibujarTableroNormalTIPO2()
    }else if (ControladorPrincipal.tipoTableroPrin == 3){
        dibujarTableroNormalTIPO3()
    }else if (ControladorPrincipal.tipoTableroPrin == 4){
        dibujarTableroNormalTIPO4()
    }
}

fun cargarTablero(){
    with(ControladorPrincipal.cPrin){
        ControladorPrincipal.gcPrincipal.clearRect(0.0,0.0, canvasPrincipal.width, canvasPrincipal.height)
        canvasPrincipal.clip = Rectangle(0.0, (2 * ControladorPrincipal.TAMANO_CELDA).toDouble(), canvasPrincipal.width, canvasPrincipal.height - 2 * ControladorPrincipal.TAMANO_CELDA)
    }
}

fun cambiarParesImparesTablero3y4(){
    paresImparesTableroTipo3y4 = (paresImparesTableroTipo3y4+1)%2
    dibujarTableroPrincipal()
}