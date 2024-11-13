package com.pruden.tetris_2.Metodos.IniciarPartida

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.lockCuentaRegresiva
import com.pruden.tetris_2.Metodos.Timelines.actualizarTimeline
import com.pruden.tetris_2.Metodos.Timelines.pararTimeline

fun iniciarPartida(){
    pararTimeline()
    sincronizacion()

    configuracionesIniciarPartida()
    actualizarTimeline()
}

private fun sincronizacion(){
    synchronized(lockCuentaRegresiva){
        while (!ControladorPrincipal.cuentaRegresivaHecha){
            try {
                (lockCuentaRegresiva as Object).wait()
            }catch (e : InterruptedException) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

