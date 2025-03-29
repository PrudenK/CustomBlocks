package com.pruden.tetris_2.API.ObjsAux


data class Clan(
    val idclan: Int,
    val nombre: String,
    val fechaInit: String,
    val idlider: Int,
    var imagen: String,
    var descripcion: String,
    var ubicacion: String
)
