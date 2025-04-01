package com.pruden.tetris_2.Metodos.IniciarPartida

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.stackPaneX
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.stackPaneY

fun setStackpane18x10() {
    cPrin.stackPane.layoutX = (stackPaneX + 40)
    cPrin.stackPane.layoutY = (stackPaneY - 10)

    centrarCuentaRegresivaRespectoAlTablero()

}

fun setStackpane12x8() {
    cPrin.stackPane.layoutX = (stackPaneX + 22)
    cPrin.stackPane.layoutY = (stackPaneY - 25)

    centrarCuentaRegresivaRespectoAlTablero()

}

fun setStackpane30x20() {
    cPrin.stackPane.layoutX = (stackPaneX - 5)
    cPrin.stackPane.layoutY = (stackPaneY + 10)

    centrarCuentaRegresivaRespectoAlTablero()
}

private fun centrarCuentaRegresivaRespectoAlTablero() {
    val columnas = Globales.COLUMNAS
    val tamCelda = Globales.TAMANO_CELDA
    val anchoTablero = columnas * tamCelda

    val anchoCuenta = cPrin.paneCuentaRegresiva.prefWidth

    cPrin.paneCuentaRegresiva.layoutX = 0.0
    cPrin.paneCuentaRegresiva.translateX = (anchoTablero - anchoCuenta) / 2
}
