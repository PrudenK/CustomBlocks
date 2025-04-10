package com.pruden.tetris_2.Constantes

import com.pruden.tetris_2.API.ObjsAuxApi.LogroJugador
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import javafx.scene.effect.ColorAdjust
import javafx.scene.paint.Color

object Globales {
    const val NUMPIEZA_PICO = 53777
    const val CENTRO_PIEZA_PICO = 538777
    val COLOR_MANGO_PICO = Color.web("#8b5b4c")!!

    const val BLANCO = 0
    const val CENTRO_BLANCO = 80
    const val BORDE_TABLERO = 9

    var FILAS = 20
    var COLUMNAS = 10
    var TAMANO_CELDA =33
    var TAMA_MASCARA = 2

    val colaLogros: ArrayDeque<LogroJugador> = ArrayDeque()
    var mostrandoNotificacion = false

    val CADENA = deRutaAImagen("/Imagenes/Logos/cadena.png")

    val GRAYSCALE = ColorAdjust().apply {
        saturation = -1.0
    }

    const val LINK_GIF_KEY = "https://www.kickstarter.com/projects/qeeke/cr840-worlds-first-mechanical-keyboard-with-stream-deck?lang=es"
}