package com.pruden.tetris_2.API.ObjsAuxApi


data class Clan(
    var idclan: Int,
    val nombre: String,
    val fechaInit: String,
    var idlider: Int,
    var imagen: String,
    var descripcion: String,
    var ubicacion: String
)
