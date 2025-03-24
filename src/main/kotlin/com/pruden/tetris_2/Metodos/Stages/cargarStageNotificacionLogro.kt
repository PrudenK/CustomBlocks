package com.pruden.tetris_2.Metodos.Stages

import com.pruden.tetris_2.API.ObjsAux.LogroJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.Notificaciones.NotificacionController
import com.pruden.tetris_2.Tetris
import javafx.animation.PauseTransition
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.util.Duration


fun cargarStageNotificacionLogro(stage: Stage, logro: LogroJugador){
    val fxmlLoader = FXMLLoader(Tetris::class.java.getResource("Vistas/Notificaciones/vistaNotificacionLogro.fxml"))
    val scene = Scene(fxmlLoader.load(), 257.0, 80.0)

    val controller = fxmlLoader.getController<NotificacionController>()
    controller.setDatos(logro)

    stage.scene = scene
    stage.initStyle(StageStyle.UNDECORATED)
    stage.isAlwaysOnTop = true
    stage.isResizable = false

    val mainStage = cPrin.nuevaPartidaB.scene.window as Stage

    val baseX = mainStage.x
    val baseY = mainStage.y

    stage.x = baseX + 20
    stage.y = baseY + 40

    scene.root.isMouseTransparent = true

    stage.show()

    val delay = PauseTransition(Duration.seconds(2.0))
    delay.setOnFinished { stage.close() }
    delay.play()
}