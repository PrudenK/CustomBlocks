package com.pruden.tetris_2.Metodos.Stages

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.Metodos.Teclado.moverPiezas
import com.pruden.tetris_2.Metodos.Teclado.onKeyReleased
import com.pruden.tetris_2.Tetris
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.input.KeyEvent
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle


private val ANCHO = 843.0
private val ALTO = 865.0


fun cargarStagePrincipal(){
    val stage = Stage()
    val fxmlLoader = FXMLLoader(Tetris::class.java.getResource("Vistas/Principal/vistaTetris.fxml"))
    val scene = Scene(fxmlLoader.load(), ANCHO, ALTO)

    stage.icons.add(deRutaAImagen("/Imagenes/Logos/logoCustomIcon.png"))

    stage.title = "¡CustomGame!"
    stage.scene = scene
    stage.initStyle(StageStyle.UNDECORATED)
    stage.initModality(Modality.APPLICATION_MODAL)
    stage.isResizable = false
    stage.show()

    scene.addEventFilter(KeyEvent.KEY_PRESSED) { event -> moverPiezas(event) }
    scene.setOnKeyReleased { onKeyReleased(it) }

    ControladorPrincipal.stagePrincipal = stage

    ControladorLogin.stageLogin.close()
}