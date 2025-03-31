package com.pruden.tetris_2.Metodos.Observables

import com.pruden.tetris_2.Constantes.Logros
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tiempoCaidaPieza
import com.pruden.tetris_2.Metodos.Cronometro.formatoASegundos
import com.pruden.tetris_2.Metodos.Logros.completarLogro
import com.pruden.tetris_2.Metodos.Media.Audio.efectoSonido
import com.pruden.tetris_2.Metodos.Timelines.actualizarTimeline
import javafx.beans.binding.Bindings
import javafx.beans.binding.NumberBinding
import javafx.beans.value.ObservableValue

fun cargarObervableNivel(){
    with(cPrin){
        val lineasBinding: NumberBinding = Bindings.createIntegerBinding({ labelLineas.text.split("/")[0].toInt() }, labelLineas.textProperty())

        ControladorPrincipal.numLineas.bind(lineasBinding)

        ControladorPrincipal.numLineas.addListener{ _: ObservableValue<out Number>?, oldValue: Number, newValue: Number ->
            val lineasAntes = oldValue.toInt()
            val lineasDespues = newValue.toInt()
            var nivelActual: Int = labelNivel.text.split("/")[0].toInt()
            val multiploAntes: Int = lineasAntes / ControladorPrincipal.LINEAS_POR_NIVEL
            val multiploDespues: Int = lineasDespues / ControladorPrincipal.LINEAS_POR_NIVEL
            if (lineasDespues > 0 && multiploDespues > multiploAntes) {
                val nivelesASubir = multiploDespues - multiploAntes
                for (i in 0 until nivelesASubir) {
                    nivelActual++
                    if (tiempoCaidaPieza > ControladorPrincipal.REDUCCION_TIEMPO_POR_NIVEL) {
                        tiempoCaidaPieza -= ControladorPrincipal.REDUCCION_TIEMPO_POR_NIVEL
                    }
                    efectoSonido("/Musica/Efectos/pasarNivel.mp3")
                }
                labelNivel.text = nivelActual.toString()+ ControladorPrincipal.objFasesNivel
                actualizarTimeline()
            }

            if(ControladorPrincipal.jugarOnline){
                if(cPrin.labelModo.text == "Clásico"){
                    if(nivelActual >= 5 && !jugadorConTodo!!.listaLogros.find { it.idLogro == Logros.SKILLS_I }!!.completado){
                        completarLogro(Logros.SKILLS_I)
                    }

                    if(nivelActual == 5 && !jugadorConTodo!!.listaLogros.find { it.idLogro == Logros.TECLADO_EN_LLAMAS }!!.completado){
                        if(formatoASegundos(cPrin.cronometroLabel.text) <= 300){
                            completarLogro(Logros.TECLADO_EN_LLAMAS)
                        }
                    }

                    if(nivelActual >= 10 && !jugadorConTodo!!.listaLogros.find { it.idLogro == Logros.SKILLS_II }!!.completado){
                        completarLogro(Logros.SKILLS_II)
                    }

                    if(nivelActual >= 15 && !jugadorConTodo!!.listaLogros.find { it.idLogro == Logros.SKILLS_III }!!.completado){
                        completarLogro(Logros.SKILLS_III)
                    }
                }
            }
        }
    }
}