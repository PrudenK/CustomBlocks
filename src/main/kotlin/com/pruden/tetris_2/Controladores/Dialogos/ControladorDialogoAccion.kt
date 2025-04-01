package com.pruden.tetris_2.Controladores.Dialogos

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label

class ControladorDialogoAccion {

    @FXML lateinit var btnAceptar: Button
    @FXML lateinit var btnCancelar: Button
    @FXML lateinit var nombre: Label

    var onConfirmar: (() -> Unit)? = null
    var onCancelar: (() -> Unit)? = null

    fun initialize() {
        btnCancelar.setOnAction {
            onCancelar?.invoke()
            btnCancelar.scene.window.hide()
        }

        btnAceptar.setOnAction {
            onConfirmar?.invoke()
            btnAceptar.scene.window.hide()
        }
    }
}