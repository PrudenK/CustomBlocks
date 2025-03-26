package com.pruden.tetris_2.Controladores.Clan

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label

class ControladorAccionesClan {

    @FXML lateinit var btnAceptar: Button
    @FXML lateinit var btnCancelar: Button
    @FXML lateinit var nombre: Label

    var onConfirmar: (() -> Unit)? = null

    fun initialize() {
        btnCancelar.setOnAction {
            btnCancelar.scene.window.hide()
        }

        btnAceptar.setOnAction {
            onConfirmar?.invoke()
            btnAceptar.scene.window.hide()
        }
    }
}