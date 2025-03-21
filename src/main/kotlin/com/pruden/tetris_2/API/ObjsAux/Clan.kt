package com.pruden.tetris_2.API.ObjsAux

import java.util.Date

data class Clan(
    val idClan: Int,
    val nombre: String,
    val fechaInit: Date,
    val idLider: Int
)
