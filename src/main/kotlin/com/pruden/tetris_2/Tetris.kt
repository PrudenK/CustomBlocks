package com.pruden.tetris_2

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.StageStyle

class Tetris : Application() {
    private val ANCHO = 843.0
    private val ALTO = 865.0



    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(Tetris::class.java.getResource("Vistas/Principal/vistaTetris.fxml"))
        val scene = Scene(fxmlLoader.load(), ANCHO, ALTO)
        stage.title = "¡Tetris!"
        stage.scene = scene
        stage.initStyle(StageStyle.UNDECORATED)
        stage.isResizable = false
        stage.show()

        cPrin.pasarEscena(scene)


    }

    companion object{

    }
}

fun main() {
    Application.launch(Tetris::class.java)

}