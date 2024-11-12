package com.pruden.tetris_2.Metodos.IniciarPartida

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.animacionEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.nivelEnJuego
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.objFasesNivel
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.objPuntuacionBajar
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaActual
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaHold
import com.pruden.tetris_2.Metodos.BolsaPiezas.devolverPiezaAleatoria
import com.pruden.tetris_2.Metodos.BolsaPiezas.piezasBolsa
import com.pruden.tetris_2.Metodos.BolsaPiezas.siguientePieza
import com.pruden.tetris_2.Metodos.BorrarPiezas.objLineasNivel
import com.pruden.tetris_2.Metodos.Matriz.rellenarMatriz
import javafx.application.Platform
fun configuracionesIniciarPartida(){
    cPrin.canvasPrincipal.opacity = 1.0
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
    cPrin.canvasPrincipal.opacity = 0.1
    partidaEnCurso = false
    animacionEnCurso = true
}

fun reiniciarLabels(){
    with(cPrin){
        nivelMarcoNivelTit.text = ""
        tiempoMarcoNivel.text = ""
        puntuacionMarcoNivel.text = ""
        lineasMarcoNivel.text = ""

        tiempoMarcoNivelRes.text = ""
        puntuacionMarcoNivelRes.text = ""
        lineasMarcoNivelRes.text = ""
    }



    Platform.runLater {
        cPrin.labelPuntuacion.text = "0" + objPuntuacionBajar
        cPrin.labelLineas.text = "0" + objLineasNivel

        if (nivelEnJuego) cPrin.labelNivel.text = "0"+ objFasesNivel
            else cPrin.labelNivel.text = "1"
    }
}

