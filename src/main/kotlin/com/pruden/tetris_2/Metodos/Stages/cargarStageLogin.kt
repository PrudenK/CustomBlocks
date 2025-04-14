package com.pruden.tetris_2.Metodos.Stages

import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.Tetris
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.StageStyle


private val ANCHO = 314.0
private val ALTO = 449.0
fun cargarLogin(stage: Stage){
    val fxmlLoader = FXMLLoader(Tetris::class.java.getResource("Vistas/Login/vista_Login.fxml"))
    val scene = Scene(fxmlLoader.load(), ANCHO, ALTO)

    stage.icons.add(deRutaAImagen("/Imagenes/Logos/logoCustomIcon.png"))

    ControladorLogin.stageLogin = stage

    stage.title = "¡Login!"
    stage.scene = scene
    stage.initStyle(StageStyle.DECORATED)
    stage.isResizable = false

    stage.minWidth = ANCHO
    stage.maxWidth = ANCHO
    stage.minHeight = ALTO
    stage.maxHeight = ALTO
    stage.show()
}