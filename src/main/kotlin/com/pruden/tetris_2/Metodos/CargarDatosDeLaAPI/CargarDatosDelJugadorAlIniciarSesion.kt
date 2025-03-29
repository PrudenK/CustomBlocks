package com.pruden.tetris_2.Metodos.CargarDatosDeLaAPI

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaTusModosDeJuego

suspend fun cargarDatosDelJugadorAlIniciarSesion(){
    jugadorConTodo = ApiCustom.jugadorService.getDatosIniciarSesion(idJugador)
    /*
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

     */
}