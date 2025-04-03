package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.Constantes.ModosDeJuego
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Metodos.ModosDeJuego.Modos.cargarCambiosModo
import com.pruden.tetris_2.WebSocket.BuscarPartida.DatosPartidaPVP

fun reiniciarPartidaParaPVP(datosPartidaPVP: DatosPartidaPVP){
    cPrin.panePVP.isVisible = true
    cPrin.paneSinglePlayer.isVisible = false
    ControladorPrincipal.partidaPVPenCurso = true


    cPrin.puntuacionHostNombre.text = datosPartidaPVP.creador.nombre+":"
    cPrin.lineasHostNombre.text = datosPartidaPVP.creador.nombre+":"
    cPrin.nivelHostNombre.text = datosPartidaPVP.creador.nombre+":"

    cPrin.puntuacionVisiNombre.text= datosPartidaPVP.buscador.nombre+":"
    cPrin.lineasVisiNombre.text= datosPartidaPVP.buscador.nombre+":"
    cPrin.nivelVisiNombre.text= datosPartidaPVP.buscador.nombre+":"

    cPrin.labelModo.text = datosPartidaPVP.modo

    val modoDeJuego = when(datosPartidaPVP.modo){
        "Clásico" -> ModosDeJuego.CLASICO
        "Clśico v2" -> ModosDeJuego.CLASICO_V2
        "All in" -> ModosDeJuego.ALL_IN
        "Algebra" -> ModosDeJuego.ALGEBRA
        "Rapid O" -> ModosDeJuego.RAPID_O
        "Memory" -> ModosDeJuego.MEMORY
        "MemoryX" -> ModosDeJuego.MEMORY_X
        "MemoryY" -> ModosDeJuego.MEMORY_Y
        else -> ModosDeJuego.CLASICO
    }

    println(datosPartidaPVP.bolsa)

    cargarCambiosModo(modoDeJuego)
    cPrin.partdiaNueva()
}