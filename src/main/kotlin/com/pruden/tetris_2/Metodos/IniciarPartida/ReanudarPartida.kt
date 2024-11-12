package com.pruden.tetris_2.Metodos.IniciarPartida

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Metodos.Timelines.reanudarTimeline

fun reanudarPartida(){
    if (!ControladorPrincipal.hasPerdido && !ControladorPrincipal.nivelTerminado) {
        ControladorPrincipal.cronometro.reanudar()
        reanudarTimeline()
    }
}
