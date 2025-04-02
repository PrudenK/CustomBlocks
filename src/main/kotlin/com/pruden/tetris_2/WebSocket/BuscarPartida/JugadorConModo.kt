package com.pruden.tetris_2.WebSocket.BuscarPartida

data class JugadorConModo(
    val id: Int,
    val nombre: String,
    val nivel: Int,
    val foto: String?,
    val modo: String
)
