package com.pruden.tetris_2.API.ObjsAuxApi

data class LogroJugador(
    val idLogro: Int,
    val imagen: String,
    var completado: Boolean,
    val descripcion: String,
    val titulo: String
)