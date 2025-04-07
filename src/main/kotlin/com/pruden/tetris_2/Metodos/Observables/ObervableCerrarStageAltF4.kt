package com.pruden.tetris_2.Metodos.Observables

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ModosDeJuego.Modos.ControladorModosJuego
import com.pruden.tetris_2.Metodos.Timelines.reanudarTimeline

fun cargarObervableCerrarStageAltF4(){
    ControladorPrincipal.cerrarStageAltF4.addListener { _, _, newValue ->
        if (newValue) {
            if(!ControladorPrincipal.partidaPVPenCurso){
                reanudarTimeline()
                ControladorPrincipal.cronometro.reanudar()
                ControladorPrincipal.cerrarStageAltF4.set(false)
            }
        }
    }
}