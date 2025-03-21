package com.pruden.tetris_2.API.ObjsAux

data class Suscripcion(
    val tipo: Int,
    val nombre: String,
    val precio: String,
    val nummodos: Int,
    val numPartidasGuardadas: Int,
    val imagen: String
)