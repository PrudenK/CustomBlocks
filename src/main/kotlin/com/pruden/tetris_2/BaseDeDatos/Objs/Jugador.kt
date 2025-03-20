package com.pruden.tetris_2.BaseDeDatos.Objs

import java.text.SimpleDateFormat
import java.util.*

data class Jugador(
    val id: Int = -1,
    val nombre: String,
    val contrasena: String,
    val nivel: Int = 1,
    val fechaini: Date = Date(),
    val pais: String,
    val experiencia: Int = 0,
    var clan: Clan? = null
){
    fun getFechaFormateada(): String {
        val formato = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        return formato.format(fechaini)
    }
}
