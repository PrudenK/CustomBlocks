package com.pruden.tetris_2.API.ObjsAuxApi

data class EstadisticasModo(
    val maxNivel: Int,
    val maxLineas: Int,
    val maxPuntuacion: Int,
    val maxTiempo: String,
    val lineasSum: Int,
    val puntuacionesSum: Int,
    val tiempoTotal: String,
    val totalDePartidas: Int
)
