package com.pruden.tetris_2.Metodos.Stages

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ModosDeJuego.ModoCampa.ControladorCargarNivel.Companion.cCargarNivel
import com.pruden.tetris_2.Tetris
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle

fun cargarStageCargarNivel(stage: Stage){
    val fxmlLoader = FXMLLoader(Tetris::class.java.getResource("Vistas/ModosDeJuego/ModoCampa/vista_CargaNivel.fxml"))
    val scene = Scene(fxmlLoader.load(), 628.0, 351.0)

    cCargarNivel.stageCargarNivel = stage

    stage.initOwner(cPrin.nuevaPartidaB.scene.window as Stage)
    stage.initModality(Modality.WINDOW_MODAL)

    val parentStage = cPrin.nuevaPartidaB.scene.window

    stage.initOwner(parentStage)

    stage.setOnShown {
        val x = parentStage.x + (parentStage.width - stage.width) / 2
        val y = parentStage.y + (parentStage.height - stage.height) / 2
        stage.x = x
        stage.y = y
    }


    stage.scene = scene
    stage.initStyle(StageStyle.UNDECORATED)
    stage.isResizable = false
    stage.show()
}