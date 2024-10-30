package com.pruden.tetris_2.Metodos.Observables

import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOpciones
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