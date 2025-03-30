package com.pruden.tetris_2.Metodos.Perder

import com.pruden.tetris_2.Metodos.SubirDatos.subirDatosPartida
import com.pruden.tetris_2.Metodos.SubirDatos.subirTodoEstaPiezas
import com.pruden.tetris_2.Metodos.SubirDatos.sumarTipoPieza
import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Constantes.Logros
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.hasPerdido
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.nivelEnJuego
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Metodos.Logros.completarLogro
import com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.FinDelNivel.perderNivelModoCampa
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import com.pruden.tetris_2.Metodos.SubirDatos.subirDatosNivelPerdido

fun comprbarPerder(){
    if (verificarPerdida()) {
        hasPerdido = true
        timelinePartida.stop()
        cronometro.parar()

        if(nivelEnJuego){
            perderNivelModoCampa()
            subirDatosNivelPerdido()
        }else{
            cargarLogrosNumPartidasClasicas()

            jugadorConTodo.puntuacionAcumulada += cPrin.labelPuntuacion.text.toString().split("/")[0].toInt()
            jugadorConTodo.numeroLineasAcumuladas += cPrin.labelLineas.text.toString().split("/")[0].toInt()

            cargarLogrosPuntuacion()
            cargarLogrosLineas()

            crearStage(ClaseStage("Vistas/Otras/vista_Perder.fxml", cPrin.nuevaPartidaB, 315.0, 232.0, null, 0, -120))
        }


        subirDatosFinDePartida()
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
        jugadorConTodo.numeroPartidasClasicas++
        if(jugadorConTodo.numeroPartidasClasicas == 10){
            completarLogro(Logros.NOVATO)
        }

        if(jugadorConTodo.numeroPartidasClasicas == 100){
            completarLogro(Logros.AFICIONADO)
        }

        if(jugadorConTodo.numeroPartidasClasicas == 500){
            completarLogro(Logros.MAQUINON)
        }
    }
}

private fun cargarLogrosPuntuacion(){
    if(jugadorConTodo.puntuacionAcumulada >= 100000 && !jugadorConTodo.listaLogros.find { it.idLogro == Logros.PAR_DE_PUNTOS }!!.completado){
        completarLogro(Logros.PAR_DE_PUNTOS)
    }

    if(jugadorConTodo.puntuacionAcumulada >= 1000000 && !jugadorConTodo.listaLogros.find { it.idLogro == Logros.APUNTANDO_MANERAS }!!.completado){
        completarLogro(Logros.APUNTANDO_MANERAS)
    }

    if(jugadorConTodo.puntuacionAcumulada >= 10000000 && !jugadorConTodo.listaLogros.find { it.idLogro == Logros.POR_LAS_NUBES }!!.completado){
        completarLogro(Logros.POR_LAS_NUBES)
    }
}

private fun cargarLogrosLineas(){
    if(jugadorConTodo.numeroLineasAcumuladas >= 1000 && !jugadorConTodo.listaLogros.find { it.idLogro == Logros.PAR_DE_LINEAS }!!.completado){
        completarLogro(Logros.PAR_DE_LINEAS)
    }

    if(jugadorConTodo.numeroLineasAcumuladas >= 5000 && !jugadorConTodo.listaLogros.find { it.idLogro == Logros.BASTANTES_RAYAS }!!.completado){
        completarLogro(Logros.BASTANTES_RAYAS)
    }

    if(jugadorConTodo.numeroLineasAcumuladas >= 10000 && !jugadorConTodo.listaLogros.find { it.idLogro == Logros.MARADONA }!!.completado){
        completarLogro(Logros.MARADONA)
    }
}