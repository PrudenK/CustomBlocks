package com.pruden.tetris_2.API.ObjsAux

data class NivelJugador(
    val idNivel: Int,
    val idMundo: Int,
    val completado: Boolean,
    val desbloqueado: Boolean,
    val mejorTiempo: String?,
    val mejorPuntuacion: Int?,
    val mejorLineas: Int?,
    val numIntentos: Int?
)
