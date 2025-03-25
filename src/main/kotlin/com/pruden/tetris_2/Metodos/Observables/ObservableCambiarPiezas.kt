package com.pruden.tetris_2.Metodos.Observables

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.logroZZZ
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas
import javafx.beans.property.SimpleBooleanProperty

fun cargarObersvablePiezas(){
    ControladorCustomPiezas.guardarPiezas = SimpleBooleanProperty(false)

    ControladorCustomPiezas.guardarPiezas.addListener { _, _, newValue ->
        if (newValue) {
            ControladorCustomPiezas.listaPiezasSeleccionadas.clear()
            for (checkBox in ControladorCustomPiezas.checkBoxes) {
                ControladorCustomPiezas.listaPiezasSeleccionadas.add(
                    checkBox.isSelected
                )
            }

            val configZZZ = List(48) { false }.toMutableList().apply {
                this[3] = true
                this[13] = true
                this[46] = true
            }

            logroZZZ = ControladorCustomPiezas.listaPiezasSeleccionadas == configZZZ

            cargarPiezasEstandarSiChecksVacios()
            ControladorCustomOpciones.cambioPiezas = true
            ControladorCustomPiezas.stageCustomPiezas.close()
        }
    }
}

private fun cargarPiezasEstandarSiChecksVacios(){
    if (ControladorCustomPiezas.listaPiezasSeleccionadas.stream().allMatch { b: Boolean? -> !b!! }) {
        for (i in 0..6) {
            ControladorCustomPiezas.listaPiezasSeleccionadas[i] = true
        }
    }
}