package com.pruden.tetris_2

import com.pruden.tetris_2.Metodos.Publicidad.obtenerAnuncios
import com.pruden.tetris_2.Metodos.Stages.cargarLogin
import javafx.application.Application
import javafx.stage.Stage

class Tetris : Application() {
    override fun start(stage: Stage) {
        obtenerAnuncios()
        cargarLogin(stage)
    }
}

fun main() {
    Application.launch(Tetris::class.java)
}