package com.pruden.tetris_2.Metodos.Stages

import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Controladores.Login.ControladorLogin.Companion.stageLogin
import com.pruden.tetris_2.Controladores.Login.ControladorRegistrarse
import com.pruden.tetris_2.Tetris
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle



fun cargarStageRegistrarse(elemento : Button){
    val stage = Stage()

    val fxmlLoader = FXMLLoader(Tetris::class.java.getResource("Vistas/Login/vista_Registrarse.fxml"))
    val scene = Scene(fxmlLoader.load(), 367.0, 555.0)

    val controladorRegistrarse = fxmlLoader.getController<ControladorRegistrarse>()



    stage.title = "¡Registrarse!"
    stage.scene = scene
    stage.initStyle(StageStyle.UNDECORATED)




    stage.initModality(Modality.WINDOW_MODAL)
    stage.isResizable = false



    val stageOwner = elemento.scene.window as Stage
    stage.initOwner(stageOwner)




    controladorRegistrarse.stageRegistrarse = stage

    stage.x = stageLogin.x
    stage.y = stageLogin.y

    stage.show()






}
