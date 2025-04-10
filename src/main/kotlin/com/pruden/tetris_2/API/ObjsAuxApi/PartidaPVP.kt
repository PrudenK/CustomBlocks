package com.pruden.tetris_2.API.ObjsAuxApi

import java.util.Date

data class PartidaPVP(
    val id: Int = 0,
    val host: Int,
    val visitante: Int,
    val modo: String,
    val resultado: String,
    val fecha: Date = Date()
)
