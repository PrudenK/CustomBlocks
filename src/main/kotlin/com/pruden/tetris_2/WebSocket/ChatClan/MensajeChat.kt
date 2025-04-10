package com.pruden.tetris_2.WebSocket.ChatClan

data class MensajeChat(
    val remitente: String,
    val texto: String,
    val esPropio: Boolean
)

