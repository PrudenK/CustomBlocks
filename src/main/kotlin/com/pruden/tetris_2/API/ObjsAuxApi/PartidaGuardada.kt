package com.pruden.tetris_2.API.ObjsAuxApi

import com.pruden.tetris_2.Metodos.Cronometro.formatoASegundos

data class PartidaGuardada(
    val idJugador: Int,
    val numPartidaGuardada: Int, //Indice de la partida (1, 2 o 3)
    val modo: String, // Modo de juego

    val tiempo: String, // 00:23:45
    val puntuacion: Int,
    val lineas: Int,
    val nivel: Int,

    val tableroPartida: List<List<Int>>, //La matriz interna
    val tamaTablero: Int, // 0(12x8), 1(20x10) o 2(30x20)
    val diseTablero: Int, // 0, 1, 2, 3 o 4

    val diseTableroSecun: Int, // 0 o 1

    val siguientesPiezasActivo: Int, // 0 o 1 (Booleano)

    val siguientesPiezas: String, // O,I,X_v2
    val arrayPiezas: String, // Lista piezas disponibles
    val disePiezas: Int, // 0, 3, 4, 5, 6, 8 (lados de polígono)

    val holdActivo: Int, // 0 o 1 (Booleano)
    val dashActivo: Int, // 0 o 1 (Booleano)
    val piezaEnHold: String, // O, I... o nada si no hay
    val puedeHoldear: Int, // 0 o 1 (Booleano)

    val velocidadCaidaActual: Int,
    val lineasParaSaltoDeNivel: Int,
    val saltoDeTiempoPorNivel: Int,
    val limiteRotaciones: Int,

    val piezaActual: String,
    val posicionPiezaActual: String, //(fCentro_cCentro_orientacion) 12_6_3
    val numRotacionesDeLaPiezaActual: Int, // las veces que puede rotar la pieza actual
                                            // si hay límite de rotaciones
    val estadoMascara: Int // 0 o 1 (Dos posiciones posibles de la máscara en tablero MemoryX / Y
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
