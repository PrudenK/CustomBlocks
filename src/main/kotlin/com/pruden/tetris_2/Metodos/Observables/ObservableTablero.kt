package com.pruden.tetris_2.Metodos.Observables

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOpciones
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaNumColumnas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaNumFilas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaTamaCelda
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.stageCustomTablero
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.tabPosicion
import javafx.beans.property.SimpleBooleanProperty

fun cargarObservableTablero(){
    ControladorCustomTablero.guardarTablero = SimpleBooleanProperty(false)

    ControladorCustomTablero.guardarTablero.addListener { _, _, newValue ->
        if (newValue) {
            cambiarConfiguracionesTablero()
            ControladorCustomOpciones.cambioTablero = true

            stageCustomTablero.close()
        }
    }
}

private fun cambiarConfiguracionesTablero(){
    ControladorPrincipal.FILAS = (listaNumFilas[tabPosicion])
    ControladorPrincipal.COLUMNAS = (listaNumColumnas[tabPosicion])
    ControladorPrincipal.TAMANO_CELDA = (listaTamaCelda[tabPosicion])
}