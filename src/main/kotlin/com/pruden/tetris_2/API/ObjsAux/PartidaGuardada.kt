package com.pruden.tetris_2.API.ObjsAux

data class PartidaGuardada(
    val idJugador: Int,
    val numPartidaGuardada: Int,
    val modo: String,

    val tiempo: String,
    val puntuacion: Int,
    val lineas: Int,
    val nivel: Int,

    val tableroPartida: List<List<Int>>,
    val tamaTablero: Int,
    val diseTablero: Int,

    val diseTableroSecun: Int,

    val siguientesPiezasActivo: Int,

    val siguientesPiezas: String, // O,I,X_v2
    val arrayPiezas: String,
    val disePiezas: Int,

    val holdActivo: Int,
    val dashActivo: Int,
    val piezaEnHold: String,

    val velocidadCaidaActual: Int,
    val lineasParaSaltoDeNivel: Int,
    val saltoDeTiempoPorNivel: Int,
    val limiteRotaciones: Int,

    val piezaActual: String,
    val posicionPiezaActual: String, //(fCentro_cCentro_orientacion)
    val numRotacionesDeLaPiezaActual: Int
)
