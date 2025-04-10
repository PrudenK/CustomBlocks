package com.pruden.tetris_2.API.ObjsAuxApi

data class ModoDeJuegoAPI(
    val idJugador: Int,
    val idnummodo: Int,
    val nombre: String,
    val imagen: String?,
    val arraypiezas: String,
    val tablero: Int,
    val tipotableroprincipal: Int,
    val tipopieza: Int,
    val tipotablerosecun: Int,
    val tiempocaidainicial: Int,
    val lineasparasaltonivel: Int,
    val saltodetiempopornivel: Int,
    val limiterotaciones: Int,
    val hold: Int,
    val piezas: Int,
    val dashes: Int
){
    fun siguientesPiezas() = piezas == 1
    fun dashDisponible() = dashes == 1
    fun hayLimiteRotaciones() = limiterotaciones != -1
    fun hayHoldActivado() = hold == 1
    fun arraPiezas() = arraypiezas.split("_").map { it.toInt() }.toIntArray()
}