package com.pruden.tetris_2.Metodos.DialogoAccion


import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.Dialogos.ControladorDialogoAccion
import javafx.fxml.FXMLLoader
import javafx.scene.layout.Pane
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.Window
import javafx.scene.Scene

var dialogoAccionesActual: Stage? = null

fun mostrarDialogoConAccion(
    mensaje: String,
    cancelBtnNombre: String = "Cancelar",
    aceptarBtnNombre: String = "Aceptar",
    onConfirmar: (() -> Unit)? = null,
    onCancelar: (() -> Unit)? = null
) {
    val parentStage = cPrin.nuevaPartidaB.scene.window

    dialogoAccionesActual?.let {
        if (it.isShowing) {
            it.close()
        }
    }

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
    dialogStage.initOwner(parentStage)

    dialogStage.setOnShown {
        val x = parentStage.x + (parentStage.width - dialogStage.width) / 2
        val y = parentStage.y + (parentStage.height - dialogStage.height) / 2
        dialogStage.x = x
        dialogStage.y = y
    }

    controller.btnCancelar.text = cancelBtnNombre
    controller.btnAceptar.text = aceptarBtnNombre

    dialogStage.scene = Scene(root)
    dialogStage.isResizable = false
    dialogStage.show()

    dialogoAccionesActual = dialogStage

}
