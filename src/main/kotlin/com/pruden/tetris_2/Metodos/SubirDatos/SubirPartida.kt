package com.pruden.tetris_2.Metodos.SubirDatos

import com.pruden.tetris_2.API.ObjsAux.Partida
import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun subirDatosPartida(){
    CoroutineScope(Dispatchers.IO).launch {
        val partida = Partida(
            idJugador = ControladorPrincipal.idJugador,
            modo = ControladorPrincipal.cPrin.labelModo.text,
            nivel = ControladorPrincipal.cPrin.labelNivel.text.toInt(),
            puntuacion = ControladorPrincipal.cPrin.labelPuntuacion.text.toInt(),
            tiempo = ControladorPrincipal.cPrin.cronometroLabel.text,
            lineas = ControladorPrincipal.cPrin.labelLineas.text.toInt()
        )

        ApiCustom.partidaService.subirPartida(partida)
    }
}