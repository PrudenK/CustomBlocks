package com.pruden.tetris_2.Metodos.PartidaVistaDatos

import com.pruden.tetris_2.Controladores.Partidas.ControladorPartidas.Companion.cPartidas

fun ordenar(){
    with(cPartidas){
        val listaOrdenada = when (comboOrdenar.value) {
            "Fecha" -> datosPartida.sortedByDescending  { it.fechaJuego }
            "Nivel" -> datosPartida.sortedByDescending  { it.nivel }
            "Lineas" -> datosPartida.sortedByDescending  { it.lineas }
            "Puntuación" -> datosPartida.sortedByDescending  { it.puntuacion }
            "Tiempo" -> datosPartida.sortedByDescending  { it.tiempoPartidaEnSegundos() }
            else -> datosPartida
        }
        datosPartida.setAll(listaOrdenada)
    }
}