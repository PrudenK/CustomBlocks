package com.pruden.tetris_2.Metodos.IniciarPartida

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Metodos.Teclado.moverPiezaAbajo
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.event.ActionEvent
import javafx.util.Duration

fun actualizarTimeline(){
    pararTimeline()

    ControladorPrincipal.timelinePartida = Timeline( KeyFrame(Duration.millis(ControladorPrincipal.tiempoCaidaPieza.toDouble()), { e: ActionEvent? -> moverPiezaAbajo() }))
    ControladorPrincipal.timelinePartida.cycleCount = Timeline.INDEFINITE
    ControladorPrincipal.timelinePartida.play()
}

fun pararTimeline(){
    try {
        ControladorPrincipal.timelinePartida.stop()
    }catch(ignored : Exception){}
}

fun reanudarTimeline(){
    ControladorPrincipal.timelinePartida.play()
}