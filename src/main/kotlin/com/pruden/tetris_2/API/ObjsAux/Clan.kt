package com.pruden.tetris_2.API.ObjsAux

import java.util.Date

data class Clan(
    val idclan: Int,
    val nombre: String,
    val fechaInit: Date = Date(),
    val idlider: Int,
    var imagen: String,
    var descripcion: String,
    var ubicacion: String
)
