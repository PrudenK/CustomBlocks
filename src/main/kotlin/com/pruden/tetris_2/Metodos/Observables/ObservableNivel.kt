package com.pruden.tetris_2.Metodos.Observables

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Metodos.Media.Audio.efectoSonido
import com.pruden.tetris_2.Metodos.Timelines.actualizarTimeline
import com.pruden.tetris_2.Metodos.Timelines.timelineMascara
import javafx.beans.binding.Bindings
import javafx.beans.binding.NumberBinding
import javafx.beans.value.ObservableValue
import javafx.scene.control.Label



fun cargarObervableNivel(){
    with(cPrin){
        val lineasBinding: NumberBinding = Bindings.createIntegerBinding({ labelLineas.text.toInt() }, labelLineas.textProperty())

        ControladorPrincipal.numLineas.bind(lineasBinding)

        ControladorPrincipal.numLineas.addListener{ _: ObservableValue<out Number>?, oldValue: Number, newValue: Number ->
            val lineasAntes = oldValue.toInt()
            val lineasDespues = newValue.toInt()
            var nivelActual: Int = labelNivel.text.toInt()
            val multiploAntes: Int = lineasAntes / ControladorPrincipal.LINEAS_POR_NIVEL
            val multiploDespues: Int = lineasDespues / ControladorPrincipal.LINEAS_POR_NIVEL
            if (lineasDespues > 0 && multiploDespues > multiploAntes) {
                val nivelesASubir = multiploDespues - multiploAntes
                for (i in 0 until nivelesASubir) {
                    nivelActual++
                    if (ControladorPrincipal.tiempoCaidaPieza > ControladorPrincipal.REDUCCION_TIEMPO_POR_NIVEL) {
                        ControladorPrincipal.tiempoCaidaPieza -= ControladorPrincipal.REDUCCION_TIEMPO_POR_NIVEL
                    }
                    efectoSonido("/Musica/Efectos/pasarNivel.mp3")
                }
                labelNivel.text = nivelActual.toString()
                actualizarTimeline()
            }
        }
    }
}

