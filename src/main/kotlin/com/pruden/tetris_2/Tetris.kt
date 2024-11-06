package com.pruden.tetris_2

import com.pruden.tetris_2.Controladores.Login.ControladorLogin.Companion.stageLogin
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.StageStyle

class Tetris : Application() {
    private val ANCHO = 314.0
    private val ALTO = 449.0

    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(Tetris::class.java.getResource("Vistas/Login/vista_Login.fxml"))
        val scene = Scene(fxmlLoader.load(), ANCHO, ALTO)

        stageLogin = stage

        stage.title = "¡Login!"
        stage.scene = scene
        stage.initStyle(StageStyle.UNDECORATED)
        stage.isResizable = false
        stage.show()

    }
}

fun main() {
    Application.launch(Tetris::class.java)
}