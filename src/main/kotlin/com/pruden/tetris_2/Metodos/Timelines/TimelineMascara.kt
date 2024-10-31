package com.pruden.tetris_2.Metodos.Timelines

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.controladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcMascara
import com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal.ponerMascaraTableroTIPO2
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.event.ActionEvent
import javafx.util.Duration

fun timelineMascara(lineas : Int){
    val timelineMascara = Timeline(
        KeyFrame(Duration.seconds(0.0), { _: ActionEvent? ->
            borrarMascara()
        }),
        KeyFrame(Duration.seconds(0.5 * lineas), { _: ActionEvent? ->
            ponerMascaraTableroTIPO2()
        })
    )
    timelineMascara.cycleCount = 1
    timelineMascara.play()
}

fun borrarMascara(){
    gcMascara.clearRect(0.0,0.0, controladorPrincipal.canvasMascara.width,controladorPrincipal.canvasMascara.height)
}