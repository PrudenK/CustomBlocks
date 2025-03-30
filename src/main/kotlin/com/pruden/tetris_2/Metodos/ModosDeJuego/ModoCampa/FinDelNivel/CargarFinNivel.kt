package com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.FinDelNivel

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin

fun cargarLabelsFinNivel(nivelTilt :String){
    with(cPrin){
        nivelMarcoNivelTit.text = nivelTilt
        tiempoMarcoNivel.text = "Tiempo:"
        puntuacionMarcoNivel.text = "Puntuación:"
        lineasMarcoNivel.text = "Lineas"

        tiempoMarcoNivelRes.style = "-fx-text-fill: green"
        puntuacionMarcoNivelRes.style = "-fx-text-fill: green"
        lineasMarcoNivelRes.style = "-fx-text-fill: green"

        tiempoMarcoNivelRes.text = cronometroLabel.text.split("/")[0]
        puntuacionMarcoNivelRes.text = labelPuntuacion.text.split("/")[0]
        lineasMarcoNivelRes.text = labelLineas.text.split("/")[0]
    }
}