package com.pruden.tetris_2.Metodos.Stages

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ModoCampa.ControladorCargarNivel.Companion.cCargarNivel
import com.pruden.tetris_2.Tetris
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle

fun cargarStageCargarNivel(stage: Stage){
    val fxmlLoader = FXMLLoader(Tetris::class.java.getResource("Vistas/ModoCampa/vista_CargaNivel.fxml"))
    val scene = Scene(fxmlLoader.load(), 504.0, 371.0)

    cCargarNivel.stageCargarNivel = stage

    stage.initOwner(cPrin.nuevaPartidaB.scene.window as Stage)
    stage.initModality(Modality.WINDOW_MODAL)


    stage.scene = scene
    stage.initStyle(StageStyle.UNDECORATED)
    stage.isResizable = false
    stage.show()
}