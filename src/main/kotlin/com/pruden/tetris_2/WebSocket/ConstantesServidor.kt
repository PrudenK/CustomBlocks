package com.pruden.tetris_2.WebSocket

object ConstantesServidor {
    val PATH_SERVER: String = System.getProperty("serverIp")?.let {
        "ws://$it:8080"
    } ?: "ws://localhost:8080"


    const val CLAN_CHAT = "/clan-chat"
    const val CREAR_PARTIDA = "/crear-partida"
    const val BUSCAR_PARTIDA = "/buscar-partida"
    const val PARTIDA_EN_CURSO = "/partida-en-curso"
}