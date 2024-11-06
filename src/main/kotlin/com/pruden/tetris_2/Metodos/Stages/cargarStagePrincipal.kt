package com.pruden.tetris_2.Metodos.Stages

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Tetris
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.StageStyle


private val ANCHO = 843.0
private val ALTO = 865.0
private val stage = Stage()


fun cargarStagePrincipal(){
    val fxmlLoader = FXMLLoader(Tetris::class.java.getResource("Vistas/Principal/vistaTetris.fxml"))
    val scene = Scene(fxmlLoader.load(), ANCHO, ALTO)

    stage.title = "¡CustomGame!"
    stage.scene = scene
    stage.initStyle(StageStyle.UNDECORATED)
    stage.isResizable = false
    stage.show()

    ControladorPrincipal.cPrin.pasarEscena(scene)

    ControladorLogin.stageLogin.close()
}