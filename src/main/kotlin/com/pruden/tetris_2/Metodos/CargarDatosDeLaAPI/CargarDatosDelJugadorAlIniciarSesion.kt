package com.pruden.tetris_2.Metodos.CargarDatosDeLaAPI

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idClanDelJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugadorSiEsLiderDeUnClan
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorActualObj
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaLogrosJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaMundos
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaMundosJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaNiveles
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaNivelesJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaSuscripciones
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaTusModosDeJuego
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.numeroLineasAcumuladas
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.numeroPartidasClasicas
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.puntuacionAcumulada
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.suscripcionDelJugador

suspend fun cargarDatosDelJugadorAlIniciarSesion(){
    listaLogrosJugador = ApiCustom.logroService.getLogrosDelJugador(idJugador).toMutableList()
    numeroPartidasClasicas = ApiCustom.partidaService.getNumPartidasClasicas(idJugador).body()!!
    numeroLineasAcumuladas = ApiCustom.partidaService.getNumLineas(idJugador)
    puntuacionAcumulada = ApiCustom.partidaService.getNumPuntos(idJugador)
    idClanDelJugador = ApiCustom.jugadorService.clanDelJugador(idJugador)
    idJugadorSiEsLiderDeUnClan = ApiCustom.jugadorService.jugadorEsLiderDeUnClan(idJugador)
    suscripcionDelJugador = ApiCustom.suscripcionJugadorService.comprobarSuscripcionDelJugador(idJugador)
    jugadorActualObj = ApiCustom.jugadorService.getJugadorPorId(idJugador)
    listaTusModosDeJuego = ApiCustom.modoDeJuegoService.getModosDeJuegoDeUnJugador(idJugador).toMutableList()


    listaMundos = ApiCustom.mundoService.getAllMundos().toMutableList()
    listaNiveles = ApiCustom.nivelService.getAllNiveles().toMutableList()
    listaMundosJugador = ApiCustom.mundoJugadorService.getMundosDelJugador(idJugador)
    listaNivelesJugador = ApiCustom.nivelJugadorService.getNivelesJugador(idJugador)

    val response = ApiCustom.suscripcionService.getAllSuscripciones()
    if(response.isSuccessful){
        listaSuscripciones = response.body()!!.toMutableList()
    }else{
        println(response.code())
        println(response.message())
        println(response)
    }
}