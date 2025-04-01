package com.pruden.tetris_2.API.ObjsAux

data class JugadorInicioSesion(
    val id: Int,
    val pais: String,
    val nombre: String,
    var nivel: Int,
    val fechaini: String,
    var experiencia: Int,
    var clan: Clan? = null,
    var imagen: String? = null,
    var online: Boolean = false,

    val listaLogros: List<LogroJugador>,
    var numeroPartidasClasicas: Int,
    var numeroLineasAcumuladas: Int,
    var puntuacionAcumulada: Int,

    var suscripcionDelJugador: SuscripcionJugador?,
    var listaTusModosDeJuego: List<ModoDeJuegoAPI>,

    val listaMundos: List<Mundo>,
    val listaNiveles: List<Nivel>,
    val listaMundosJugador: List<MundoJugador>,
    val listaNivelesJugador: List<NivelJugador>,

    val listaSuscripciones: List<Suscripcion>,

    var listaPartidasGuardadas: MutableList<PartidaGuardada>
)