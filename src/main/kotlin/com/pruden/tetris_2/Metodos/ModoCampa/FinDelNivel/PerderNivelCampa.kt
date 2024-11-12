package com.pruden.tetris_2.Metodos.ModoCampa.FinDelNivel

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Metodos.BorrarPiezas.objLineasNivel
import com.pruden.tetris_2.Metodos.Cronometro.formatoASegundos
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen

fun perderNivelModoCampa(){
    ControladorPrincipal.partidaEnCurso = false

    cargarLabelsFinNivel("Has perdido")

    cambiarEstilosLabels()

    cPrin.cuentaRegresivaIMG.image = deRutaAImagen("/Imagenes/Logos/marcoPerder.png")
}

private fun cambiarEstilosLabels(){
    if(lineasObjetivoNOCumplidas()) cPrin.lineasMarcoNivelRes.style = "-fx-text-fill: red"

    if(tiempoObjetivoNOCumplido()) cPrin.tiempoMarcoNivelRes.style = "-fx-text-fill: red"

    if(puntuacionObjetivoNOCumplida()) cPrin.puntuacionMarcoNivelRes.style = "-fx-text-fill: red"
}

private fun lineasObjetivoNOCumplidas():Boolean{
    return cPrin.labelLineas.text.split("/")[0].toInt() < objLineasNivel.split("/")[1].toInt()
}

private fun tiempoObjetivoNOCumplido():Boolean{
    return formatoASegundos(cPrin.cronometroLabel.text.split("/")[0]) >= formatoASegundos(cPrin.cronometroLabel.text.split("/")[1])
}

private fun puntuacionObjetivoNOCumplida():Boolean{
    return cPrin.labelPuntuacion.text.split("/")[0].toInt() < ControladorPrincipal.objPuntuacionBajar.split("/")[1].toInt()
}