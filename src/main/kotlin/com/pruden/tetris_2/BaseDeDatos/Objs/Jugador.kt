package com.pruden.tetris_2.BaseDeDatos.Objs

import java.util.Date

data class Jugador(
    val id: Int = -1,
    val nombre: String,
    val contrasena: String,
    val nivel: Int = 1,
    val fechaini: Date = Date(),
    val pais: String,
    val experiencia: Int = 0,
    var clan: Clan? = null
)
