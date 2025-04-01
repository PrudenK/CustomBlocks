package com.pruden.tetris_2.Metodos.Cronometro

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tiempoObj
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.scene.control.Label
import javafx.util.Duration

class Cronometro () {
    private var cronometroLabel : Label = cPrin.cronometroLabel
    private var horas = 0
    private var minutos = 0
    private var segundos = 0
    private var segundosS : String = ""
    private var minutosS : String = ""
    private var timelineCronometro : Timeline? = null


    fun reiniciar(){
        seTCronometroA0()
        segundos = 0
        minutos = 0
        horas = 0
        encender()
    }


    fun seTCronometroA0() {
        Platform.runLater {
            cronometroLabel.text = "0:00:00"+ tiempoObj
        }
    }

    fun reanudar(){
        if(timelineCronometro != null){
            timelineCronometro!!.play()
        }
    }

    fun parar(){
        if (timelineCronometro != null){
            timelineCronometro!!.stop()
        }
    }

    fun setTiempo(tiempo : String){
        val totalSegundos = formatoASegundos(tiempo)

        horas = totalSegundos / 3600
        minutos = (totalSegundos % 3600) / 60
        segundos = totalSegundos % 60
    }


    private fun encender() {
        if (timelineCronometro == null) {
            timelineCronometro = Timeline(
                KeyFrame(Duration.seconds(1.0),
                    { _: ActionEvent? ->
                        segundos++
                        if (segundos > 59) {
                            segundos = 0
                            minutos++
                            if (minutos > 59) {
                                minutos = 0
                                horas++
                            }
                        }
                        if (segundos.toString().length == 1) {
                            segundosS = ":0$segundos"
                        } else segundosS = ":$segundos"
                        if (minutos.toString().length == 1) {
                            minutosS = ":0$minutos"
                        } else minutosS = ":$minutos"
                        cronometroLabel.text = horas.toString() + minutosS + segundosS + tiempoObj
                    })
            )
        }
        timelineCronometro!!.cycleCount = Timeline.INDEFINITE
        timelineCronometro!!.play()
    }


}