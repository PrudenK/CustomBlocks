package com.pruden.tetris_2.Metodos.PartidaVistaDatos

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.Partidas.ControladorPartidas.Companion.cPartidas
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun cargarDatosPartidas(){
    CoroutineScope(Dispatchers.IO).launch {
        val partidas = ApiCustom.partidaService.getPartidasDelJugador(idJugador, cPartidas.comboFiltrar.value)
        cPartidas.datosPartida.clear()

        cPartidas.datosPartida.addAll(partidas)

        ordenar()
    }
}