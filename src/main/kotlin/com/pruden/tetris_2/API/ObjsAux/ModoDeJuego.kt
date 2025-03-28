package com.pruden.tetris_2.API.ObjsAux

data class ModoDeJuego(
    val idJugador: Int,
    val idNumModo: Int,
    val nombre: String,
    val imagen: String,
    val arrayPiezas: String,
    val tablero: Int,
    val tipoTableroPrincipal: Int,
    val tipoPieza: Int,
    val tipoTableroSecun: Int,
    val tiempoCaidaInicial: Int,
    val lineasParaSaltoNivel: Int,
    val saltoDeTiempoPorNivel: Int,
    val limiteRotaciones: Int,
    val hold: Int,
    val piezas: Int,
    val dashes: Int
){
    fun siguientesPiezas() = piezas == 1
    fun dashDisponible() = dashes == 1
    fun hayLimiteRotaciones() = limiteRotaciones != -1
}