package com.pruden.tetris_2.Metodos.Observables

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarTimeline

fun cargarObervableCerrarStageAltF4(){
    ControladorPrincipal.cerrarStageAltF4.addListener { _, _, newValue ->
        if (newValue) {
            reanudarTimeline()
            ControladorPrincipal.cronometro.reanudar()
            ControladorPrincipal.cerrarStageAltF4.set(false)
        }
    }
}