package com.pruden.tetris_2.WebSocket

data class MensajeChat(
    val remitente: String,
    val texto: String,
    val esPropio: Boolean
)

