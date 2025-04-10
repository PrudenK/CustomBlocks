package com.pruden.tetris_2.WebSocket.BuscarPartida

import com.pruden.tetris_2.API.ObjsAuxApi.Jugador

data class DatosPartidaPVP(
    val creador: Jugador,
    val buscador: Jugador,
    val modo: String,
    val bolsa: String
)

