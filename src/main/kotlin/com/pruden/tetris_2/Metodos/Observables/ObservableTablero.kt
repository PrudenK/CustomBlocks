package com.pruden.tetris_2.Metodos.Observables

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMANO_CELDA
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones.Companion.cambioTablero
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.guardarTablero
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaNumColumnas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaNumFilas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaTamaCelda
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.stageCustomTablero
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.tabPosicion
import javafx.beans.property.SimpleBooleanProperty

fun cargarObservableTablero(){
    guardarTablero = SimpleBooleanProperty(false)

    guardarTablero.addListener { _, _, newValue ->
        if (newValue) {
            cambiarConfiguracionesTablero()
            cambioTablero = true

            stageCustomTablero.close()
        }
    }
}

private fun cambiarConfiguracionesTablero(){
    FILAS = (listaNumFilas[tabPosicion])
    COLUMNAS = (listaNumColumnas[tabPosicion])
    TAMANO_CELDA = (listaTamaCelda[tabPosicion])
}