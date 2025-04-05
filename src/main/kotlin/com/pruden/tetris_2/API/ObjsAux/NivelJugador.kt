package com.pruden.tetris_2.API.ObjsAux

data class NivelJugador(
    val idNivel: Int,
    val idMundo: Int,
    var completado: Boolean,
    var desbloqueado: Boolean,
    var mejorTiempo: String?,
    var mejorPuntuacion: Int?,
    var numIntentos: Int
){
    fun getStats():String{
        return "Mejor tiempo: ${mejorTiempo!!.replace("/", "")}\nMejor puntuación: $mejorPuntuacion\nNúmero de intentos: $numIntentos"
    }

    fun sumarIntento(){
        numIntentos += 1
    }
}
