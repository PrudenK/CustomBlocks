package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.WebSocket.BuscarPartida.DatosPartidaPVP

fun reiniciarPartidaParaPVP(datosPartidaPVP: DatosPartidaPVP){
    cPrin.panePVP.isVisible = true
    cPrin.paneSinglePlayer.isVisible = false



    cPrin.puntuacionHostNombre.text = datosPartidaPVP.creador.nombre
    cPrin.lineasHostNombre.text= datosPartidaPVP.creador.nombre
    cPrin.nivelHostNombre.text= datosPartidaPVP.creador.nombre

    cPrin.puntuacionVisiNombre.text= datosPartidaPVP.buscador.nombre
    cPrin.lineasVisiNombre.text= datosPartidaPVP.buscador.nombre
    cPrin.nivelVisiNombre.text= datosPartidaPVP.buscador.nombre

    cPrin.labelModo.text = datosPartidaPVP.modo
}