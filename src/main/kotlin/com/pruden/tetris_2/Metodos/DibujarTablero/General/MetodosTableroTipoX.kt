package com.pruden.tetris_2.Metodos.DibujarTablero.General

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroSecun
import com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal.dibujarTableroNormalTIPO0
import com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal.dibujarTableroNormalTIPO1
import com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Secundarios.*
import com.pruden.tetris_2.Piezas.Piezas
import javafx.scene.canvas.GraphicsContext


fun dibujarTableroPrincipal(){
    if (tipoTableroPrin == 0){
        dibujarTableroNormalTIPO0()
    }else{
        dibujarTableroNormalTIPO1()
    }
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

