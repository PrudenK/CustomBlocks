package com.pruden.tetris_2.Metodos.CargarDatosDeLaAPI.logros

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idClanDelJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugadorSiEsLiderDeUnClan
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorActualObj
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaLogrosJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.numeroLineasAcumuladas
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.numeroPartidasClasicas
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.puntuacionAcumulada
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.suscripcionDelJugador
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun cargarDatosDelJugador(){
    CoroutineScope(Dispatchers.IO).launch{
        listaLogrosJugador = ApiCustom.logroService.getLogrosDelJugador(idJugador).toMutableList()
        numeroPartidasClasicas = ApiCustom.partidaService.getNumPartidasClasicas(idJugador).body()!!
        numeroLineasAcumuladas = ApiCustom.partidaService.getNumLineas(idJugador)
        puntuacionAcumulada = ApiCustom.partidaService.getNumPuntos(idJugador)
        idClanDelJugador = ApiCustom.jugadorService.clanDelJugador(idJugador)
        idJugadorSiEsLiderDeUnClan = ApiCustom.jugadorService.jugadorEsLiderDeUnClan(idJugador)
        suscripcionDelJugador = ApiCustom.suscripcionJugadorService.comprobarSuscripcionDelJugador(idJugador)
        jugadorActualObj = ApiCustom.jugadorService.getJugadorPorId(idJugador)
    }
}