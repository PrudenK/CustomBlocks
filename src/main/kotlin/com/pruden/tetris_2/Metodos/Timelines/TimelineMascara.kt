package com.pruden.tetris_2.Metodos.Timelines

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcMascara
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal.ponerMascaraTableroTIPO2
import com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal.ponerMascaraTableroTIPO3
import com.pruden.tetris_2.Metodos.DibujarTablero.TiposTablero.Principal.ponerMascaraTableroTIPO4
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
            if(tipoTableroPrin == 2) ponerMascaraTableroTIPO2()
            if(tipoTableroPrin == 3) ponerMascaraTableroTIPO3()
            if(tipoTableroPrin == 4) ponerMascaraTableroTIPO4()
        })
    )
    timelineMascara.cycleCount = 1
    timelineMascara.play()
}



fun borrarMascara(){
    gcMascara.clearRect(0.0,0.0, cPrin.canvasMascara.width,cPrin.canvasMascara.height)
}