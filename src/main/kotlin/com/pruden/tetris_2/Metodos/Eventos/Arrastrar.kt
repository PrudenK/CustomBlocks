package com.pruden.tetris_2.Metodos.Eventos

import javafx.scene.Node
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.stage.Stage


private var xOffset = 0.0
private var yOffset = 0.0

fun arrastrarFun(node: Node, ownerStage: Stage? = null) {
    node.addEventFilter(MouseEvent.MOUSE_PRESSED) { event ->
        if (event.button == MouseButton.PRIMARY) {
            xOffset = event.sceneX
            yOffset = event.sceneY
        }
    }

    node.addEventFilter(MouseEvent.MOUSE_DRAGGED) { event ->
        if (event.button == MouseButton.PRIMARY) {
            val stage = node.scene.window as Stage
            val deltaX = event.screenX - xOffset
            val deltaY = event.screenY - yOffset

            // Mueve la ventana arrastrada
            stage.x = event.screenX - xOffset
            stage.y = event.screenY - yOffset

            // Si hay una ventana 'owner', muévela también
            ownerStage?.let {
                it.x += deltaX
                it.y += deltaY
            }
        }
    }
}
