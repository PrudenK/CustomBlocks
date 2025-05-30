package com.pruden.tetris_2.Metodos.Stages

import com.pruden.tetris_2.Controladores.Login.ControladorLogin.Companion.stageLogin
import com.pruden.tetris_2.Controladores.Login.ControladorRegistrarse
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.Tetris
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle



fun cargarStageRegistrarse(){
    val stage = Stage()

    val fxmlLoader = FXMLLoader(Tetris::class.java.getResource("Vistas/Login/vista_Registrarse.fxml"))
    val scene = Scene(fxmlLoader.load(), 367.0, 481.0)

    val controladorRegistrarse = fxmlLoader.getController<ControladorRegistrarse>()
    stage.title = "¡Registrarse!"
    stage.scene = scene
    stage.initStyle(StageStyle.UNDECORATED)

    stage.icons.add(deRutaAImagen("/Imagenes/Logos/logoCustomIcon.png"))

    stage.initModality(Modality.WINDOW_MODAL)
    stage.isResizable = false

    controladorRegistrarse.stageRegistrarse = stage

    stage.x = stageLogin.x
    stage.y = stageLogin.y

    stage.show()
}
