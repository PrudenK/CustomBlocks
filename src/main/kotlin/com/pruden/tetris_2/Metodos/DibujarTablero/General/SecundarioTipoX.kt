package com.pruden.tetris_2.Metodos.DibujarTablero.General

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroSecun
import com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Secundarios.*
import com.pruden.tetris_2.Piezas.Pieza
import javafx.scene.canvas.GraphicsContext


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

fun pintarPiezaTableroSecun(gc: GraphicsContext, pieza : Pieza) {
    if (tipoTableroSecun == 0) {
        pintarPiezaTableroSecundarioTIPO0(gc, pieza)
    } else {
        pintarPiezaTableroSecundarioTIPO1(gc,pieza)
    }
}