package com.pruden.tetris_2.Metodos.Eventos

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import javafx.scene.Node
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.stage.Stage


private var xOffset = 0.0
private var yOffset = 0.0

fun arrastrarFun() {
    cPrin.idPrincipal.addEventFilter(MouseEvent.MOUSE_PRESSED) { event ->
        if (event.button == MouseButton.PRIMARY) {
            xOffset = event.sceneX
            yOffset = event.sceneY
        }
    }

    cPrin.idPrincipal.addEventFilter(MouseEvent.MOUSE_DRAGGED) { event ->
        if (event.button == MouseButton.PRIMARY) {
            val stage = cPrin.idPrincipal.scene.window as Stage
            stage.x = event.screenX - xOffset
            stage.y = event.screenY - yOffset
        }
    }
}
