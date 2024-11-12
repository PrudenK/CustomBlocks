package com.pruden.tetris_2.Metodos.Stages

import com.pruden.tetris_2.Controladores.Advertencias.ControladorAdvertenciaPiezas
import com.pruden.tetris_2.Controladores.Advertencias.ControladorAdvertenciaTablero
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cerrarStageAltF4
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.Custom.*
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones.Companion.cambioOtrasConfi
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones.Companion.cambioPiezas
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones.Companion.cambioTablero
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones.Companion.cerrarYGuardarCambio
import com.pruden.tetris_2.Controladores.Otros.ControladorPerder
import com.pruden.tetris_2.Controladores.Otros.ControladorSonido
import com.pruden.tetris_2.Tetris
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.WindowEvent

fun crearStage(objetoStage: ClaseStage) {
    val fxmlLoader = FXMLLoader(Tetris::class.java.getResource(objetoStage.vista))
    val scene = Scene(fxmlLoader.load(), objetoStage.ancho, objetoStage.alto)
    val stage = Stage()

    stage.initStyle(StageStyle.UNDECORATED) // Eliminar barra de título

    stage.isResizable = false // Evitar que se pueda expandir

    stage.setScene(scene)

    stage.sizeToScene() // Asegura que se calcule el tamaño correcto


    stage.initModality(Modality.WINDOW_MODAL)

    val c: ControladorGEN = fxmlLoader.getController()

    c.setStage(stage)
    c.setBoton(objetoStage.elemento)

    val stageOwner = objetoStage.elemento.scene.window as Stage
    stage.initOwner(stageOwner)


    stage.onShown = EventHandler {_: WindowEvent? ->
        val centroX = stageOwner.x + (stageOwner.width - stage.width) / 2
        val centroY = stageOwner.y + (stageOwner.height - stage.height) / 2
        stage.x = centroX + objetoStage.movX
        stage.y = centroY + objetoStage.movY
    }

    if (!(c is ControladorAdvertenciaPiezas || c is ControladorCustomPiezas || c is ControladorAdvertenciaTablero
                || c is ControladorCustomTablero || c is ControladorSonido || c is ControladorPerder
                || c is ControladorCustomTipoTablero || c is ControladorCustomOtrasConfiguraciones)
    ) {
        if (c is ControladorCustomOpciones) {
            stage.onCloseRequest = EventHandler { _: WindowEvent? ->
                    if (cambioPiezas || cambioTablero || cambioOtrasConfi) {
                        cerrarYGuardarCambio.set(true)
                    } else {
                        cerrarStageAltF4.set(true)
                    }
                }

        } else {
            stage.onCloseRequest = EventHandler { _: WindowEvent? ->
                cerrarStageAltF4.set(true)
            }
        }
    }

    if (objetoStage.timeline != null) {
        objetoStage.timeline!!.stop()
    }

    if (c is ControladorPerder) {
        stage.show()
    } else {
        stage.showAndWait()
    }
}