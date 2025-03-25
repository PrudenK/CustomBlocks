package com.pruden.tetris_2.API.ObjsAux

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
    var clan: Clan? = null,
    var imagen: String? = null,
    var online: Boolean = false
){
    fun getFechaFormateada(): String {
        val formato = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        return formato.format(fechaini)
    }
}
