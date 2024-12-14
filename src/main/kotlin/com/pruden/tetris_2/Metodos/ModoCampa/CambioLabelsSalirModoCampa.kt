package com.pruden.tetris_2.Metodos.ModoCampa

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.nivelEnJuego
import com.pruden.tetris_2.Metodos.BorrarPiezas.objLineasNivel

fun cambiarLabelsAlSalirDelModoCampa(){
    if(nivelEnJuego){
        ControladorPrincipal.cPrin.mundoNivel.text = ""
        ControladorPrincipal.tiempoObj = ""
        ControladorPrincipal.lineasObj = ""

        nivelEnJuego = false

        ControladorPrincipal.cPrin.cronometroLabel.text = "00:00:00"
        ControladorPrincipal.cPrin.labelPuntuacion.text = "0"
        ControladorPrincipal.cPrin.labelLineas.text = "0"

        ControladorPrincipal.objPuntuacionBajar = ""
        objLineasNivel = ""
        ControladorPrincipal.cPrin.labelNivelTit.text = "Nivel"
    }
}