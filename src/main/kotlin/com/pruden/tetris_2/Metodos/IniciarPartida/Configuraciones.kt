package com.pruden.tetris_2.Metodos.IniciarPartida

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.animacionEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.controladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaActual
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaHold
import com.pruden.tetris_2.Metodos.BolsaPiezas.devolverPiezaAleatoria
import com.pruden.tetris_2.Metodos.BolsaPiezas.piezasBolsa
import com.pruden.tetris_2.Metodos.BolsaPiezas.siguientePieza
import com.pruden.tetris_2.Metodos.Matriz.rellenarMatriz
import javafx.application.Platform
import javafx.scene.control.Label

private lateinit var labelPuntuaciones : Label
private lateinit var labelLineas : Label
private lateinit var labelNivel : Label

fun configuracionesIniciarPartida(){
    controladorPrincipal.canvasPrincipal.opacity = 1.0
    partidaEnCurso = true
    animacionEnCurso = false

    siguientePieza.clear()
    piezasBolsa.clear()
    piezaHold.clear()

    rellenarMatriz()
    cronometro.reiniciar()
    piezaActual = devolverPiezaAleatoria()
}

fun configuracionInicioAnimacion(){
    controladorPrincipal.canvasPrincipal.opacity = 0.1
    partidaEnCurso = false
    animacionEnCurso = true
}

fun initLabelsConfiguraciones(lp : Label, ll : Label, ln : Label){
    labelPuntuaciones = lp
    labelLineas = ll
    labelNivel = ln
}

fun reiniciarLabels(){
    Platform.runLater {
        labelPuntuaciones.text = "0"
        labelLineas.text = "0"
        labelNivel.text = "1"
    }
}

