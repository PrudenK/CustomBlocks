package com.pruden.tetris_2.Metodos.ModosDeJuego.PVP

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.hasPerdido
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.nivelCompletado
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.nivelEnJuego
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.nivelTerminado
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.objFasesNivel
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.objPuntuacionBajar
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tiempoObj
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Metodos.Observables.cargarObervableNivel
import javafx.application.Platform

fun reiniciarValoresPVPaUI(){
    timelinePartida.stop()
    partidaEnCurso = false
    cambairUIaPVP(false)
    cronometro.parar()
}

fun cambairUIaPVP(pvp : Boolean){
    cPrin.pvp.isDisable = pvp
    cPrin.clan.isDisable = pvp
    cPrin.custom_B.isDisable = pvp
    cPrin.modos.isDisable = pvp

    if(pvp){
        cPrin.nuevaPartidaB.text = "Abandonar partida"

    }else{
        cPrin.nuevaPartidaB.text = "Nueva partida"
    }


    cPrin.panePVP.isVisible = pvp
    cPrin.paneSinglePlayer.isVisible = !pvp
    ControladorPrincipal.partidaPVPenCurso = pvp

    Platform.runLater {
        cargarObervableNivel()
        cPrin.mensajeRivalNivel.isVisible = false
    }

    nivelTerminado = false
    nivelCompletado = false
    nivelEnJuego = false
    objFasesNivel = ""
    objPuntuacionBajar = ""
    tiempoObj = ""
    hasPerdido = false
}