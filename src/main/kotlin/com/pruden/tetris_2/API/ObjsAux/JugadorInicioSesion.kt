package com.pruden.tetris_2.API.ObjsAux

import com.pruden.tetris_2.Constantes.Logros
import retrofit2.Response
import java.util.*
import java.util.stream.IntStream.IntMapMultiConsumer

data class JugadorInicioSesion(
    val id: Int,
    val nombre: String,
    val nivel: Int,
    val fechaini: String,
    val experiencia: Int,
    val clan: Clan? = null,
    val imagen: String? = null,
    val online: Boolean = false,

    val listaLogros: List<LogroJugador>,
    val numeroPartidasClasicas: Int,
    val numeroLineasAcumuladas: Int,
    val puntuacionAcumulada: Int,

    val suscripcionDelJugador: SuscripcionJugador,
    val listaTusModosDeJuego: List<ModoDeJuegoAPI>,

    val listaMundos: List<Mundo>,
    val listaNiveles: List<Nivel>,
    val listaMundosJugador: List<MundoJugador>,
    val listaNivelesJugador: List<NivelJugador>,

    val listaSuscripciones: List<Suscripcion>
)