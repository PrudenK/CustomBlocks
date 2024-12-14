package com.pruden.tetris_2.Metodos.Modos

data class ModoDeJuego(
    val nombre: String,
    val piezasDisponiblesPosiciones : IntArray,
    val tiempoCaidaInicial : Int,
    val lineasPorNivel : Int,
    val saltoDeTiempoPorNivel: Int,
    val limiteRotacionesB : Boolean,
    val limiteRotacionesNum: Int,
    val holdActivoModo: Boolean,
    val tablero: Int,
    val siguientesDisponibles: Boolean,
    val tipoTablero: Int,
    val dash: Boolean
)
