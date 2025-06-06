package com.pruden.tetris_2.Metodos.ModosDeJuego.PVP

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Constantes.ModosDeJuego
import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.elRivarHaPerdido
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idRivalPVP
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaActual
import com.pruden.tetris_2.Controladores.ModosDeJuego.PVP.ControladorTerminarPartidaPVP
import com.pruden.tetris_2.Metodos.BolsaPiezas.copiaEnPVP
import com.pruden.tetris_2.Metodos.BolsaPiezas.piezasBolsa
import com.pruden.tetris_2.Metodos.BolsaPiezas.siguientePieza
import com.pruden.tetris_2.Metodos.DialogoAccion.dialogoAccionesActual
import com.pruden.tetris_2.Metodos.IniciarPartida.reiniciarPartida
import com.pruden.tetris_2.Metodos.ModosDeJuego.Modos.cargarCambiosModo
import com.pruden.tetris_2.Metodos.Stages.crearStage
import com.pruden.tetris_2.Piezas.*
import com.pruden.tetris_2.WebSocket.BuscarPartida.DatosPartidaPVP
import com.pruden.tetris_2.WebSocket.PartidaEnCurso.PartidaEnCursoEmisor
import javafx.application.Platform
import kotlinx.coroutines.*

fun reiniciarPartidaParaPVP(datosPartidaPVP: DatosPartidaPVP){
    if(jugadorConTodo!!.id == datosPartidaPVP.creador.id){
        ControladorPrincipal.eresHostPVP = true
        ControladorPrincipal.eresVisitantePVP = false
    }else{
        ControladorPrincipal.eresHostPVP = false
        ControladorPrincipal.eresVisitantePVP = true
    }

    cambairUIaPVP(true)

    ControladorPrincipal.esperarResolucionPVP = false
    elRivarHaPerdido = false


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
                println("11111111111")

                CoroutineScope(Dispatchers.IO).launch {
                    delay(150)

                    Platform.runLater{
                        actualizarEstadoPVP()
                        elRivarHaPerdido = true
                        mostrarMensajeConAnimacion("¡${rival.nombre} ha perdido!", cPrin.mensajeRivalNivel)

                        if (ControladorPrincipal.esperarResolucionPVP) {
                            val resultado = compararJugadoresDesdeUI()
                            ControladorPrincipal.esperarResolucionPVP = false

                            Platform.runLater {
                                dialogoAccionesActual?.let {
                                    if (it.isShowing) {
                                        it.close()
                                    }
                                    dialogoAccionesActual = null
                                }
                            }



                            when (resultado) {
                                Resultado.GANA_EL_JUGADOR -> {
                                    ControladorTerminarPartidaPVP.resultado = "Ganas"
                                    println(222222222222222222)
                                }
                                Resultado.GANA_EL_OTRO -> {
                                    ControladorTerminarPartidaPVP.resultado = "Pierdes"
                                }
                                Resultado.EMPATE -> {
                                    ControladorTerminarPartidaPVP.resultado = "Empate"
                                }
                                else -> {}
                            }

                            println(44444444)
                            println(resultado)
                            reiniciarValoresPVPaUI()
                            crearStage(Stages.TERMIANR_PARTIDA_PVP)
                        }
                    }
                }

            }
            "hasGanado"->{
                if(!ControladorPrincipal.esperarResolucionPVP){
                    ControladorTerminarPartidaPVP.resultado = "Ganas"
                    reiniciarValoresPVPaUI()
                    crearStage(Stages.TERMIANR_PARTIDA_PVP)
                    println(333333333333)

                }
            }
            "empate"->{
                ControladorTerminarPartidaPVP.resultado = "Empate"
                reiniciarValoresPVPaUI()
                crearStage(Stages.TERMIANR_PARTIDA_PVP)
            }
            "rivalAbandona"->{
                ControladorTerminarPartidaPVP.resultado = "Abandono"
                reiniciarValoresPVPaUI()
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
        "Álgebra" -> ModosDeJuego.ALGEBRA
        "RapidO" -> ModosDeJuego.RAPID_O
        "Memory" -> ModosDeJuego.MEMORY
        "MemoryX" -> ModosDeJuego.MEMORY_X
        "MemoryY" -> ModosDeJuego.MEMORY_Y
        else -> ModosDeJuego.CLASICO
    }
    val indices = datosPartidaPVP.bolsa.replace("[", "")
        .replace("]", "").split(",").map { it.toInt() }

    cargarCambiosModo(modoDeJuego)





    piezasBolsa.clear()
    siguientePieza.clear()

    val listaDePiezas = mapearLetrasAPiezasPVP(indices)

    piezaActual = listaDePiezas.removeAt(0)

    copiaEnPVP.clear()
    for (pieza in listaDePiezas) {
        copiaEnPVP.add(pieza.clonar())
    }
    siguientePieza.addAll(listaDePiezas)

    reiniciarPartida()
}




private fun mapearLetrasAPiezasPVP(indices: List<Int>): ArrayList<Pieza> {
    val columna = Globales.COLUMNAS / 2
    val piezas = ArrayList<Pieza>()

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