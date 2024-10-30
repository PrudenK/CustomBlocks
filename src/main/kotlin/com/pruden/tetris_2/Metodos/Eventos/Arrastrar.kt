package com.pruden.tetris_2.Metodos.Eventos

import javafx.scene.Node
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.stage.Stage


private var xOffset = 0.0
private var yOffset = 0.0

fun arrastrarFun(node: Node) {
    node.addEventFilter(MouseEvent.MOUSE_PRESSED) { event ->
        if (event.button == MouseButton.PRIMARY) {
            xOffset = event.sceneX
            yOffset = event.sceneY
        }
    }

    node.addEventFilter(MouseEvent.MOUSE_DRAGGED) { event ->
        if (event.button == MouseButton.PRIMARY) {
            val stage = node.scene.window as Stage
            stage.x = event.screenX - xOffset
            stage.y = event.screenY - yOffset
        }
    }
}
