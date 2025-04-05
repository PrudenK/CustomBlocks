package com.pruden.tetris_2.Metodos.Perder

import com.pruden.tetris_2.Metodos.SubirDatos.subirDatosPartida
import com.pruden.tetris_2.Metodos.SubirDatos.subirTodoEstaPiezas
import com.pruden.tetris_2.Metodos.SubirDatos.sumarTipoPieza
import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Constantes.Logros
import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.esperarResolucionPVP
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.hasPerdido
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idNivelActual
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugarOnline
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.nivelEnJuego
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaPVPenCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Controladores.ModosDeJuego.PVP.*
import com.pruden.tetris_2.Metodos.DialogoAccion.mostrarDialogoConAccion
import com.pruden.tetris_2.Metodos.Logros.completarLogro
import com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.FinDelNivel.perderNivelModoCampa
import com.pruden.tetris_2.Metodos.ModosDeJuego.PVP.Resultado
import com.pruden.tetris_2.Metodos.ModosDeJuego.PVP.actualizarEstadoPVP
import com.pruden.tetris_2.Metodos.ModosDeJuego.PVP.compararJugadoresDesdeUI
import com.pruden.tetris_2.Metodos.ModosDeJuego.PVP.reiniciarValoresPVPaUI
import com.pruden.tetris_2.Metodos.Stages.crearStage
import com.pruden.tetris_2.Metodos.SubirDatos.subirDatosNivelPerdido
import com.pruden.tetris_2.WebSocket.PartidaEnCurso.PartidaEnCursoEmisor

fun comprbarPerder(){
    if (verificarPerdida()) {
        hasPerdido = true
        timelinePartida.stop()
        cronometro.parar()

        var mostarDialogo = true

        if(jugarOnline){
            if(nivelEnJuego){
                perderNivelModoCampa()
                subirDatosNivelPerdido()
                jugadorConTodo!!.listaNivelesJugador[idNivelActual -1].sumarIntento()
            }else{
                cargarLogrosNumPartidasClasicas()

                jugadorConTodo!!.puntuacionAcumulada += cPrin.labelPuntuacion.text.toString().split("/")[0].toInt()
                jugadorConTodo!!.numeroLineasAcumuladas += cPrin.labelLineas.text.toString().split("/")[0].toInt()

                cargarLogrosPuntuacion()
                cargarLogrosLineas()

                if(partidaPVPenCurso){
                    PartidaEnCursoEmisor.mensajeEstandar("perder")
                    actualizarEstadoPVP()


                    println("rESULTADO -> ${compararJugadoresDesdeUI().toString()}" )
                    when (compararJugadoresDesdeUI()) {
                        Resultado.GANA_EL_OTRO -> {
                            reiniciarValoresPVPaUI()
                            mostarDialogo = false
                            PartidaEnCursoEmisor.mensajeEstandar("hasGanado")
                            ControladorTerminarPartidaPVP.resultado = "Pierdes"
                            crearStage(Stages.TERMIANR_PARTIDA_PVP)
                        }
                        Resultado.GANA_EL_JUGADOR -> {
                            if(!esperarResolucionPVP){
                                mostarDialogo = false
                                esperarResolucionPVP = true
                                if(ControladorPrincipal.elRivarHaPerdido){
                                    ControladorTerminarPartidaPVP.resultado = "Ganas"
                                    crearStage(Stages.TERMIANR_PARTIDA_PVP)
                                }else{
                                    mostrarDialogoConAccion("Vas ganando... \nEsperando resultado final",
                                        aceptarBtnNombre = "Esperar",
                                        cancelBtnNombre = "Salir",
                                        onConfirmar = {
                                            // Todo añadir botón salir
                                        },
                                        onCancelar = {
                                            reiniciarValoresPVPaUI()
                                        }
                                    )
                                }
                            }else{
                                reiniciarValoresPVPaUI()
                                ControladorTerminarPartidaPVP.resultado = "Ganas"
                                crearStage(Stages.TERMIANR_PARTIDA_PVP)
                            }
                        }
                        Resultado.EMPATE -> {
                            reiniciarValoresPVPaUI()
                            mostarDialogo = false
                            PartidaEnCursoEmisor.mensajeEstandar("empate")
                            ControladorTerminarPartidaPVP.resultado = "Empate"
                            crearStage(Stages.TERMIANR_PARTIDA_PVP)
                        }
                        Resultado.INDEFINIDO -> {}
                    }













                }else{
                    crearStage(Stages.PERDER)
                }

                if(mostarDialogo){
                    crearStage(Stages.PERDER)
                }

            }

            subirDatosFinDePartida()
        }else{
            crearStage(Stages.PERDER)
        }
    }
}

fun subirDatosFinDePartida(){
    subirDatosPartida()
    sumarTipoPieza(ControladorPrincipal.piezaActual)
    subirTodoEstaPiezas()
}

private fun verificarPerdida(): Boolean {
    for (columna in 0 until Globales.COLUMNAS) {
        if (matrizNumerica[2][columna] != Globales.BLANCO) {  // Si alguna celda no está vacía
            return true // Has perdido
        }
    }
    return false // No has perdido
}

private fun cargarLogrosNumPartidasClasicas(){
    if(cPrin.labelModo.text == "Clásico"){
        jugadorConTodo!!.numeroPartidasClasicas++
        if(jugadorConTodo!!.numeroPartidasClasicas == 10){
            completarLogro(Logros.NOVATO)
        }

        if(jugadorConTodo!!.numeroPartidasClasicas == 100){
            completarLogro(Logros.AFICIONADO)
        }

        if(jugadorConTodo!!.numeroPartidasClasicas == 500){
            completarLogro(Logros.MAQUINON)
        }
    }
}

private fun cargarLogrosPuntuacion(){
    if(jugadorConTodo!!.puntuacionAcumulada >= 100000 && !jugadorConTodo!!.listaLogros.find { it.idLogro == Logros.PAR_DE_PUNTOS }!!.completado){
        completarLogro(Logros.PAR_DE_PUNTOS)
    }

    if(jugadorConTodo!!.puntuacionAcumulada >= 1000000 && !jugadorConTodo!!.listaLogros.find { it.idLogro == Logros.APUNTANDO_MANERAS }!!.completado){
        completarLogro(Logros.APUNTANDO_MANERAS)
    }

    if(jugadorConTodo!!.puntuacionAcumulada >= 10000000 && !jugadorConTodo!!.listaLogros.find { it.idLogro == Logros.POR_LAS_NUBES }!!.completado){
        completarLogro(Logros.POR_LAS_NUBES)
    }
}

private fun cargarLogrosLineas(){
    if(jugadorConTodo!!.numeroLineasAcumuladas >= 1000 && !jugadorConTodo!!.listaLogros.find { it.idLogro == Logros.PAR_DE_LINEAS }!!.completado){
        completarLogro(Logros.PAR_DE_LINEAS)
    }

    if(jugadorConTodo!!.numeroLineasAcumuladas >= 5000 && !jugadorConTodo!!.listaLogros.find { it.idLogro == Logros.BASTANTES_RAYAS }!!.completado){
        completarLogro(Logros.BASTANTES_RAYAS)
    }

    if(jugadorConTodo!!.numeroLineasAcumuladas >= 10000 && !jugadorConTodo!!.listaLogros.find { it.idLogro == Logros.MARADONA }!!.completado){
        completarLogro(Logros.MARADONA)
    }
}