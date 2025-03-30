package com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.PantallaDeCarga

import com.pruden.tetris_2.Controladores.ModosDeJuego.ModoCampa.ControladorCargarNivel.Companion.cCargarNivel
import javafx.application.Platform
import javafx.concurrent.Task
import kotlin.random.Random

fun cargaProgressBarCargarNivel() {
    with(cCargarNivel){
        val task = object : Task<Void>() {
            override fun call(): Void? {
                while (progressBar.progress < 1.0) {
                    val incremento = Random.nextDouble(2.0, 12.0) / 100.0

                    val espera = Random.nextLong(100, 501)

                    progressBar.progress = (progressBar.progress + incremento).coerceAtMost(1.0)

                    Platform.runLater {
                        porcentajeCargaLabel.text = String.format("%.2f", progressBar.progress * 100) + "%"
                    }

                    Thread.sleep(espera)
                }

                Platform.runLater {
                    cargaCompleta = true
                    escLabel.text = "Pulsa esc para ir al nivel"
                    porcentajeCargaLabel.text = "100%"
                }
                return null
            }
        }
        Thread(task).start()
    }
}