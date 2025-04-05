package com.pruden.tetris_2.Metodos.SubirDatos

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idNivelActual
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Metodos.Logros.completarLogro
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun subirDatosNivelCompeltado(){
    CoroutineScope(Dispatchers.IO).launch {
        val response = ApiCustom.nivelJugadorService.completarNivel(
            tiempo = "/${cPrin.cronometroLabel.text.split("/")[0]}",
            puntuacion = cPrin.labelPuntuacion.text.split("/")[0].toInt(),
            idNivel = idNivelActual,
            id = idJugador
        )

        println(response.body())

        jugadorConTodo!!.listaNivelesJugador[idNivelActual-1].mejorTiempo = response.body()!!.mejorTiempo
        jugadorConTodo!!.listaNivelesJugador[idNivelActual-1].numIntentos = response.body()!!.numIntentos
        jugadorConTodo!!.listaNivelesJugador[idNivelActual-1].mejorPuntuacion = response.body()!!.mejorPuntuacion

        jugadorConTodo!!.listaNivelesJugador[idNivelActual].desbloqueado = true
        jugadorConTodo!!.listaNivelesJugador[idNivelActual-1].completado = true

        if(idNivelActual % 9 == 0){
            jugadorConTodo!!.listaMundosJugador[idNivelActual / 9].desbloqueado = true
            jugadorConTodo!!.listaMundosJugador[(idNivelActual / 9)-1].completado = true

            completarLogro(idNivelActual / 9)
        }
    }
}

fun subirDatosNivelPerdido(){
    CoroutineScope(Dispatchers.IO).launch {
        ApiCustom.nivelJugadorService.perderNivel(idJugador, idNivelActual)
    }
}