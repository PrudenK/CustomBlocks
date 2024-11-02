package com.pruden.tetris_2.Metodos.DibujarTablero.General

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroSecun
import com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal.*
import com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Secundarios.*
import com.pruden.tetris_2.Piezas.Piezas
import javafx.scene.canvas.GraphicsContext


var paresImparesTableroTipo3y4 = 0

fun dibujarTableroPrincipal(){
    if (tipoTableroPrin == 0){
        dibujarTableroNormalTIPO0()
    }else if (tipoTableroPrin == 1){
        dibujarTableroNormalTIPO1()
    }else if (tipoTableroPrin == 2){
        dibujarTableroNormalTIPO2()
    }else if (tipoTableroPrin == 3){
        dibujarTableroNormalTIPO3()
    }else if (tipoTableroPrin == 4){
        dibujarTableroNormalTIPO4()
    }
}
fun cambiarParesImparesTablero3y4(){
    paresImparesTableroTipo3y4 = (paresImparesTableroTipo3y4+1)%2
    dibujarTableroPrincipal()
}

fun dibujarTableroSecundario(gc: GraphicsContext){
    if (tipoTableroSecun == 0){
        dibujarTableroSecundarioTIPO0(gc)
    }else{
        dibujarTableroSecundarioTIPO1(gc)
    }
}


fun borrarTableroSecundario(gc: GraphicsContext) {
    borrarTableroSecundarioTIPO0(gc)
    dibujarTableroSecundario(gc)
}

fun pintarPiezaTableroSecun(gc: GraphicsContext, pieza : Piezas) {
    if (tipoTableroSecun == 0) {
        pintarPiezaTableroSecundarioTIPO0(gc, pieza)
    } else {
        pintarPiezaTableroSecundarioTIPO1(gc,pieza)
    }
}

