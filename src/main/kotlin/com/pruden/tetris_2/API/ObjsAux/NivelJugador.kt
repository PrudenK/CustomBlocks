package com.pruden.tetris_2.API.ObjsAux

data class NivelJugador(
    val idNivel: Int,
    val idMundo: Int,
    var completado: Boolean,
    var desbloqueado: Boolean,
    val mejorTiempo: String?,
    val mejorPuntuacion: Int?,
    val numIntentos: Int?
){
    fun getStats():String{
        return "Mejor tiempo: ${mejorTiempo!!.replace("/", "")}\nMejor puntuación: $mejorPuntuacion\nNúmero de intentos: $numIntentos"
    }
}
