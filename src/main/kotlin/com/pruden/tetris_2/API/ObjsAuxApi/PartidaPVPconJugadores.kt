package com.pruden.tetris_2.API.ObjsAuxApi

data class PartidaPVPconJugadores (
    val id: Int,
    val host: String,
    val visitante: String,
    val modo: String,
    val resultado: String,
    val fecha: String
)