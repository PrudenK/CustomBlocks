package com.pruden.tetris_2.API.ObjsAux

import com.pruden.tetris_2.Metodos.Cronometro.formatoASegundos

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
    val puedeHoldear: Int,

    val velocidadCaidaActual: Int,
    val lineasParaSaltoDeNivel: Int,
    val saltoDeTiempoPorNivel: Int,
    val limiteRotaciones: Int,

    val piezaActual: String,
    val posicionPiezaActual: String, //(fCentro_cCentro_orientacion)
    val numRotacionesDeLaPiezaActual: Int,

    val estadoMascara: Int
){
    fun tiempoEnSegundos() = formatoASegundos(tiempo)
    fun siguientesPiezasActivo() = siguientesPiezasActivo == 1
    fun holdActivo() = holdActivo == 1
    fun dashActivo() = dashActivo == 1
    fun hayPiezaEnHold() = piezaEnHold != ""
    fun arraPiezas() = arrayPiezas.split("_").map { it.toInt() }.toIntArray()
    fun filaCentroPiezaActual() = posicionPiezaActual.split("_")[0].toInt()
    fun columnaCentroPiezaActual() = posicionPiezaActual.split("_")[1].toInt()
    fun rotacionPiezaActual() = posicionPiezaActual.split("_")[2].toInt()
    fun hayLimiteDeRotacion() = limiteRotaciones != -1
    fun puedeHoldear() = puedeHoldear == 1
}
