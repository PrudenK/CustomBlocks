package com.pruden.tetris_2.Metodos.Stages

import com.pruden.tetris_2.Constantes.ModosDeJuego
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cerrarStageAltF4
import com.pruden.tetris_2.Controladores.ModosDeJuego.ControladorMenuModos
import com.pruden.tetris_2.Controladores.ModosDeJuego.ModoCampa.ControladorModoCampa
import com.pruden.tetris_2.Controladores.ModosDeJuego.ModoCampa.ControladorMundos.Companion.cMundo1
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones.Companion.cambioOtrasConfi
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones.Companion.cambioPiezas
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones.Companion.cambioTablero
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones.Companion.cerrarYGuardarCambio
import com.pruden.tetris_2.Controladores.ModosDeJuego.Modos.ControladorModosJuego
import com.pruden.tetris_2.Controladores.ModosDeJuego.TusModos.ControladorTusModos
import com.pruden.tetris_2.Controladores.Opciones.ControladorOpciones
import com.pruden.tetris_2.Controladores.Otros.ControladorPerder
import com.pruden.tetris_2.Controladores.Partidas.ControladorPartidas
import com.pruden.tetris_2.Controladores.Perfil.ControladorPerfil
import com.pruden.tetris_2.Controladores.Rankings.ControladorRankings
import com.pruden.tetris_2.Controladores.Suscripciones.ControladorSuscripciones
import com.pruden.tetris_2.Tetris
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.WindowEvent

fun crearStage(objetoStage: ClaseStage, stageParaEsconder: Stage? = null) {
    val fxmlLoader = FXMLLoader(Tetris::class.java.getResource(objetoStage.vista))
    val scene = Scene(fxmlLoader.load(), objetoStage.ancho, objetoStage.alto)
    val stage = Stage()

    if(objetoStage.mundo != -1){
        cMundo1.setMundo(objetoStage.mundo)
    }

    stage.initStyle(StageStyle.UNDECORATED) // Eliminar barra de título
    stage.initModality(Modality.APPLICATION_MODAL)

    stage.isResizable = false // Evitar que se pueda expandir

    stage.setScene(scene)

    stage.sizeToScene() // Asegura que se calcule el tamaño correcto

    val c: ControladorGEN = fxmlLoader.getController()

    c.setStage(stage)
    c.setBoton(objetoStage.elemento)

    val stageOwner = objetoStage.elemento.scene.window as Stage
    stage.initOwner(stageOwner)


    if(stageOwner != cPrin.nuevaPartidaB.scene.window as Stage){
        stageOwner.isIconified = true
        stage.setOnHidden {
            stageOwner.isIconified = false // Restaura la ventana anterior
        }
    }

    stage.onShown = EventHandler {_: WindowEvent? ->
        val centroX = stageOwner.x + (stageOwner.width - stage.width) / 2
        val centroY = stageOwner.y + (stageOwner.height - stage.height) / 2
        stage.x = centroX + objetoStage.movX
        stage.y = centroY + objetoStage.movY
    }

    if (c is ControladorCustomOpciones || c is ControladorOpciones || c is ControladorPerfil || c is ControladorRankings
        || c is ControladorModoCampa || c is ControladorModosJuego || c is ControladorPartidas //|| c is ControladorCargarNivel
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


    stageParaEsconder?.hide()

    if (c is ControladorPerder || c is ControladorMenuModos || c is ControladorTusModos || c is ControladorSuscripciones


        ) {


        // TODO mejorar cambios con ALT F4
        /*
        if(c is ControladorMenuModos){
            stage.setOnCloseRequest {
                stageParaEsconder?.show()
            }
        }

         */



        stage.show()
    } else {
        stage.showAndWait()
    }
}