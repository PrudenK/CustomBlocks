package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Constantes.ModosDeJuego
import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.elRivarHaPerdido
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idRivalPVP
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaActual
import com.pruden.tetris_2.Metodos.BolsaPiezas.copiaEnPVP
import com.pruden.tetris_2.Metodos.BolsaPiezas.piezasBolsa
import com.pruden.tetris_2.Metodos.BolsaPiezas.siguientePieza
import com.pruden.tetris_2.Metodos.ModosDeJuego.Modos.cargarCambiosModo
import com.pruden.tetris_2.Metodos.Observables.cargarObervableNivel
import com.pruden.tetris_2.Metodos.Stages.crearStage
import com.pruden.tetris_2.Piezas.*
import com.pruden.tetris_2.WebSocket.BuscarPartida.DatosPartidaPVP
import com.pruden.tetris_2.WebSocket.PartidaEnCurso.PartidaEnCursoEmisor
import javafx.application.Platform

fun reiniciarPartidaParaPVP(datosPartidaPVP: DatosPartidaPVP){
    cPrin.panePVP.isVisible = true
    cPrin.paneSinglePlayer.isVisible = false
    ControladorPrincipal.partidaPVPenCurso = true






    val idJugadorPropio = jugadorConTodo!!.id
    idRivalPVP = if (idJugadorPropio == datosPartidaPVP.creador.id) datosPartidaPVP.buscador.id else datosPartidaPVP.creador.id
    val rival = if (idJugadorPropio == datosPartidaPVP.creador.id) datosPartidaPVP.buscador else datosPartidaPVP.creador
    PartidaEnCursoEmisor.iniciar(idJugadorPropio) { mensaje ->
        when(mensaje.getString("mensaje")){
            "actualizarEstado" ->{
                val nuevoNivel = mensaje.getInt("nivel")
                val nuevasLineas = mensaje.getInt("lineas")
                val nuevaPuntuacion = mensaje.getInt("puntuacion")

                if (ControladorPrincipal.eresHostPVP) {
                    cPrin.nivelVisiLabel.text = "$nuevoNivel"
                    cPrin.lineasVisiLabel.text = "$nuevasLineas"
                    cPrin.puntuacionVisiLabel.text = "$nuevaPuntuacion"
                } else {
                    cPrin.nivelHostLabel.text = "$nuevoNivel"
                    cPrin.lineasHostLabel.text = "$nuevasLineas"
                    cPrin.puntuacionHostLabel.text = "$nuevaPuntuacion"
                }
            }
            "subirDeNivel"->{
                mostrarMensajeConAnimacion("¡${rival.nombre} sube de nivel!", cPrin.mensajeRivalNivel)
            }
            "perder"->{
                actualizarEstadoPVP()
                elRivarHaPerdido = true
                mostrarMensajeConAnimacion("¡${rival.nombre} ha perdido!", cPrin.mensajeRivalNivel)
            }
            "hasGanado"->{
                actualizarEstadoPVP()
                ControladorTerminarPartidaPVP.resultado = "Ganas"
                crearStage(Stages.TERMIANR_PARTIDA_PVP)
            }
            "empate"->{
                ControladorTerminarPartidaPVP.resultado = "Empate"
                crearStage(Stages.TERMIANR_PARTIDA_PVP)
            }
        }
    }





    cPrin.puntuacionHostNombre.text = datosPartidaPVP.creador.nombre+":"
    cPrin.lineasHostNombre.text = datosPartidaPVP.creador.nombre+":"
    cPrin.nivelHostNombre.text = datosPartidaPVP.creador.nombre+":"

    cPrin.puntuacionVisiNombre.text= datosPartidaPVP.buscador.nombre+":"
    cPrin.lineasVisiNombre.text= datosPartidaPVP.buscador.nombre+":"
    cPrin.nivelVisiNombre.text= datosPartidaPVP.buscador.nombre+":"

    cPrin.labelModo.text = datosPartidaPVP.modo

    val modoDeJuego = when(datosPartidaPVP.modo){
        "Clásico" -> ModosDeJuego.CLASICO
        "Clásico v2" -> ModosDeJuego.CLASICO_V2
        "All in" -> ModosDeJuego.ALL_IN
        "Algebra" -> ModosDeJuego.ALGEBRA
        "Rapid O" -> ModosDeJuego.RAPID_O
        "Memory" -> ModosDeJuego.MEMORY
        "MemoryX" -> ModosDeJuego.MEMORY_X
        "MemoryY" -> ModosDeJuego.MEMORY_Y
        else -> ModosDeJuego.CLASICO
    }
    val indices = datosPartidaPVP.bolsa.replace("[", "")
        .replace("]", "").split(",").map { it.toInt() }

    cargarCambiosModo(modoDeJuego)



    if(jugadorConTodo!!.id == datosPartidaPVP.creador.id){
        ControladorPrincipal.eresHostPVP = true
        ControladorPrincipal.eresVisitantePVP = false
    }else{
        ControladorPrincipal.eresHostPVP = false
        ControladorPrincipal.eresVisitantePVP = true
    }


    if(ControladorPrincipal.eresHostPVP){
        println(jugadorConTodo!!.nombre +" es el host")
    }else{
        println(jugadorConTodo!!.nombre +" es el visitante")
    }


    Platform.runLater {
        cargarObervableNivel()
    }


    piezasBolsa.clear()
    siguientePieza.clear()

    val listaDePiezas = mapearLetrasAPiezasPVP(indices)

    piezaActual = listaDePiezas.removeAt(0)

    copiaEnPVP.clear()
    for (pieza in listaDePiezas) {
        copiaEnPVP.add(pieza.clonar())
    }
    siguientePieza.addAll(listaDePiezas)

    cPrin.partdiaNueva()
}




private fun mapearLetrasAPiezasPVP(indices: List<Int>): ArrayList<Piezas> {
    val columna = Globales.COLUMNAS / 2
    val piezas = ArrayList<Piezas>()

    indices.forEach { i ->
        val pieza = when (i) {
            0 -> Pieza_O(0, columna)
            1 -> Pieza_I(0, columna)
            2 -> Pieza_L(0, columna)
            3 -> Pieza_Z(0, columna)
            4 -> Pieza_J(0, columna)
            5 -> Pieza_S(0, columna)
            6 -> Pieza_T(0, columna)
            7 -> Pieza_P(0, columna)
            8 -> Pieza_X(0, columna)
            9 -> Pieza_U(0, columna)
            10 -> Pieza_L_v2(0, columna)
            11 -> Pieza_W(0, columna)
            12 -> Pieza_T_v2(0, columna)
            13 -> Pieza_Z_v2(0, columna)
            14 -> Pieza_X_v2(0, columna)
            15 -> Pieza_L_v3(0, columna)
            16 -> Pieza_F(0, columna)
            17 -> Pieza_O_v2(0, columna)
            18 -> Pieza_S_v2(0, columna)
            19 -> Pieza_B(0, columna)
            20 -> Pieza_Y(0, columna)
            21 -> Pieza_K(0, columna)
            22 -> Pieza_I_v2(0, columna)
            23 -> Pieza_C(0, columna)
            24 -> Pieza_O_v3(0, columna)
            25 -> Pieza_V(0, columna)
            26 -> Pieza_H(0, columna)
            27 -> Pieza_I_v3(-1, columna - 1)
            28 -> Pieza_Y_v2(0, columna)
            29 -> Pieza_O_v4(0, columna)
            30 -> Pieza_J_v2(0, columna)
            31 -> Pieza_A(0, columna)
            32 -> Pieza_Mini_I(0, columna)
            33 -> Pieza_Mini_I_v2(0, columna)
            34 -> Pieza_Mini_L(0, columna)
            35 -> Pieza_Mini_O(0, columna)
            36 -> Pieza_O_v5(0, columna)
            37 -> Pieza_O_v6(0, columna)
            38 -> Pieza_X_v3(0, columna)
            39 -> Pieza_E(-1, columna - 1)
            40 -> Pieza_Twin_O(0, columna)
            41 -> Pieza_Twin_Y(0, columna)
            42 -> Pieza_Pickaxe(0, columna)
            43 -> Pieza_S_v3(-1, columna - 1)
            44 -> Pieza_Twin_O_v2(0, columna)
            45 -> Pieza_Z_v3(-1, columna - 1)
            46 -> Pieza_Ladder(0, columna)
            47 -> Pieza_H_v2(-1, columna-1)
            else -> null
        }

        if (pieza != null) {
            piezas.add(pieza)
        }
    }

    return piezas
}