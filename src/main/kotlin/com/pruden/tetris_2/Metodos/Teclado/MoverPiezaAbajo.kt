package com.pruden.tetris_2.Metodos.Teclado

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaActual
import com.pruden.tetris_2.Metodos.Media.Audio.efectoSonido
import com.pruden.tetris_2.Metodos.BolsaPiezas.devolverPiezaAleatoria
import javafx.scene.control.Label
import javafx.scene.input.KeyEvent

fun bajar(labelPuntuacion: Label){
    if (moverPiezaAbajo()) {
        labelPuntuacion.text = (labelPuntuacion.text.toInt() + 2).toString()
        efectoSonido("/Musica/Efectos/sonidoMoverPieza.mp3")
    }
}

fun moverEspacio(event : KeyEvent, labelPuntuacion : Label){
    event.consume()
    while (moverPiezaAbajo()) {
        labelPuntuacion.text = (labelPuntuacion.text.toInt() + 4).toString()
    }
    efectoSonido("/Musica/Efectos/caidaPieza.mp3")
}

fun moverPiezaAbajo() :Boolean{
    if(piezaActual.bajar()){
        piezaActual = devolverPiezaAleatoria()
        return false
    }
    return true
}

