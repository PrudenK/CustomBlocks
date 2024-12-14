package com.pruden.tetris_2.Metodos.PartidaVistaDatos

import com.pruden.tetris_2.Metodos.Cronometro.formatoASegundos

data class Partida(
    val idPartida: Int,
    val modo:String,
    val nivel: Int,
    val puntuacion: Int,
    val tiempo: String,
    val lineas: Int,
    val fechaJuego: String
){
    fun tiempoPartidaEnSegundos(): Int{
        return formatoASegundos(this.tiempo)
    }
}
