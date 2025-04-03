package com.pruden.tetris_2.Controladores.PVP

import javafx.animation.FadeTransition
import javafx.application.Platform
import javafx.scene.control.Label
import javafx.util.Duration

fun mostrarMensajeConAnimacion(texto: String, label: Label) {
    Platform.runLater {
        label.text = texto
        label.opacity = 1.0
        label.isVisible = true

        if(!texto.endsWith("ha perdido!")){
            val fade = FadeTransition(Duration.seconds(2.0), label)
            fade.fromValue = 1.0
            fade.toValue = 0.0
            fade.delay = Duration.seconds(0.75)
            fade.setOnFinished {
                label.isVisible = false
            }
            fade.play()
        }
    }
}
