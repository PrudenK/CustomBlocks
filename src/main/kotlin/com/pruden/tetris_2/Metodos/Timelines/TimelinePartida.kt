package com.pruden.tetris_2.Metodos.Timelines

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tiempoCaidaPieza
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Metodos.Teclado.moverPiezaAbajo
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.event.ActionEvent
import javafx.util.Duration

fun actualizarTimeline(){
    pararTimeline()

    timelinePartida = Timeline( KeyFrame(Duration.millis(tiempoCaidaPieza.toDouble()), { e: ActionEvent? -> moverPiezaAbajo() }))
    timelinePartida.cycleCount = Timeline.INDEFINITE
    timelinePartida.play()
}

fun pararTimeline(){
    try {
        timelinePartida.stop()
    }catch(ignored : Exception){}
}

fun reanudarTimeline(){
    timelinePartida.play()
}