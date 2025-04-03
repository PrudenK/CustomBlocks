package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.eresHostPVP
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idRivalPVP
import com.pruden.tetris_2.WebSocket.PartidaEnCurso.PartidaEnCursoEmisor

fun actualizarEstadoPVP(){
    val lbNivel = if(eresHostPVP) cPrin.nivelHostLabel else cPrin.nivelVisiLabel
    val lbLineas = if(eresHostPVP) cPrin.lineasHostLabel else cPrin.lineasVisiLabel
    val lbPuntuacion = if(eresHostPVP) cPrin.puntuacionHostLabel else cPrin.puntuacionVisiLabel

    val nivelActual = lbNivel.text.split("/")[0].toInt()
    val lineasActuales = lbLineas.text.split("/")[0].toInt()
    val puntuacionActual = lbPuntuacion.text.split("/")[0].toInt()

    PartidaEnCursoEmisor.enviarEstado(nivelActual, lineasActuales, puntuacionActual, idRivalPVP)
}