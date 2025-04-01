package com.pruden.tetris_2.Metodos.DialogoAccion


import com.pruden.tetris_2.Controladores.Dialogos.ControladorDialogoAccion
import javafx.fxml.FXMLLoader
import javafx.scene.layout.Pane
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.Window
import javafx.scene.Scene

fun mostrarDialogoConAccion(
    owner: Window,
    mensaje: String,
    onConfirmar: () -> Unit,
    onCancelar: (() -> Unit)? = null
) {
    val loader = FXMLLoader(
        ControladorDialogoAccion::class.java.getResource("/com/pruden/tetris_2/Vistas/Dialogo/dialogoAcciones.fxml")
    )
    val root = loader.load<Pane>()
    val controller = loader.getController<ControladorDialogoAccion>()

    controller.nombre.text = mensaje
    controller.onConfirmar = onConfirmar
    controller.onCancelar = onCancelar

    val dialogStage = Stage()
    dialogStage.initStyle(StageStyle.UNDECORATED)
    dialogStage.initModality(Modality.APPLICATION_MODAL)
    dialogStage.initOwner(owner)
    dialogStage.scene = Scene(root)
    dialogStage.isResizable = false
    dialogStage.showAndWait()
}
