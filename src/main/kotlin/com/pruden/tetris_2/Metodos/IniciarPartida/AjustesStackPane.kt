package com.pruden.tetris_2.Metodos.IniciarPartida

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.stackPaneX
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.stackPaneY
import javafx.scene.image.ImageView
import javafx.scene.layout.StackPane

private lateinit var stackPane : StackPane
private lateinit var cuentaRegresivaIMG : ImageView


fun cargarComponentesStackPane(st : StackPane, imv : ImageView){
    stackPane = st
    cuentaRegresivaIMG = imv
}

fun setStackpane18x10() {
    stackPane.layoutX = (stackPaneX + 40)
    stackPane.layoutY = (stackPaneY - 10)
    cuentaRegresivaIMG.translateX = -50.0
}

fun setStackpane12x8() {
    stackPane.layoutX = (stackPaneX + 22)
    stackPane.layoutY = (stackPaneY - 25)
    cuentaRegresivaIMG.layoutX = (stackPaneX + 22)
    cuentaRegresivaIMG.translateX = -35.0
}

fun setStackpane30x20() {
    stackPane.layoutX = (stackPaneX - 5)
    stackPane.layoutY = (stackPaneY + 10)
    cuentaRegresivaIMG.layoutX = (stackPaneX - 5) // todo: revisar
}