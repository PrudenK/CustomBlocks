package com.pruden.tetris_2.Metodos.IniciarPartida

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.stackPaneX
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.stackPaneY
import javafx.scene.image.ImageView
import javafx.scene.layout.StackPane

fun setStackpane18x10() {
    cPrin.stackPane.layoutX = (stackPaneX + 40)
    cPrin.stackPane.layoutY = (stackPaneY - 10)
    cPrin.cuentaRegresivaIMG.translateX = -50.0
}

fun setStackpane12x8() {
    cPrin.stackPane.layoutX = (stackPaneX + 22)
    cPrin.stackPane.layoutY = (stackPaneY - 25)
    cPrin.cuentaRegresivaIMG.layoutX = (stackPaneX + 22)
    cPrin.cuentaRegresivaIMG.translateX = -35.0
}

fun setStackpane30x20() {
    cPrin.stackPane.layoutX = (stackPaneX - 5)
    cPrin.stackPane.layoutY = (stackPaneY + 10)
    cPrin.cuentaRegresivaIMG.layoutX = (stackPaneX - 5)
}