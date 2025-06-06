package com.pruden.tetris_2.API.ObjsAuxApi

import com.pruden.tetris_2.Metodos.Cronometro.formatoASegundos
import java.util.Date

data class Partida(
    val idPartida: Int = -1,
    val idJugador: Int,
    val modo: String,
    val nivel: Int,
    val puntuacion: Int,
    val tiempo: String,
    val lineas: Int,
    val fechaJuego: String = Date().toString()
){
    fun tiempoPartidaEnSegundos(): Int{
        return formatoASegundos(this.tiempo)
    }
}
