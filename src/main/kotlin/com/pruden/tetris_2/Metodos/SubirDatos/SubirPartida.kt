package com.pruden.tetris_2.Metodos.SubirDatos

import com.pruden.tetris_2.API.ObjsAux.Partida
import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun subirDatosPartida(){
    CoroutineScope(Dispatchers.IO).launch {
        var modo = ControladorPrincipal.cPrin.labelModo.text
        if(!Listas.LISTA_MODOS_DE_JUEGOS.contains(modo)){
            modo = "Custom"
        }

        val partida = Partida(
            idJugador = ControladorPrincipal.idJugador,
            modo = modo,
            nivel = ControladorPrincipal.cPrin.labelNivel.text.split("/")[0].toInt(),
            puntuacion = ControladorPrincipal.cPrin.labelPuntuacion.text.split("/")[0].toInt(),
            tiempo = ControladorPrincipal.cPrin.cronometroLabel.text.split("/")[0],
            lineas = ControladorPrincipal.cPrin.labelLineas.text.split("/")[0].toInt()
        )

        ApiCustom.partidaService.subirPartida(partida)
    }
}