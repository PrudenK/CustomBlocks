package com.pruden.tetris_2.API.ObjsAuxApi

data class JugadorRanking(
    val nombre: String,
    val nivelJugador: Int,
    val nivelPartida: Int,
    val lineas: Int,
    val puntuacion: Int,
    val tiempo: String,
    val pais: String
)
