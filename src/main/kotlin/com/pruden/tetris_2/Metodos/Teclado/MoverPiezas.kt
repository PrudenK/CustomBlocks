package com.pruden.tetris_2.Metodos.Teclado

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaActual
import javafx.scene.control.Label
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent



private lateinit var labelPuntuacion : Label


fun initLabelsMoverPiezas(label: Label){
    labelPuntuacion = label
}

fun moverPiezas(evento : KeyEvent){
    if(partidaEnCurso) {
        try {
            if (evento.code == KeyCode.LEFT) { piezaActual.izquierda()
            } else if (evento.code == KeyCode.RIGHT) {
                piezaActual.derecha()
            } else if (evento.code == KeyCode.DOWN) {
                bajar(labelPuntuacion)
            } else if (evento.code == KeyCode.UP) {
                rotarPieza()
            } else if (evento.code == KeyCode.SPACE) {
                moverEspacio(evento, labelPuntuacion)
            }else if(evento.code == KeyCode.H){
                holdear()
            }
        } catch (ignored: Exception) {
            println(ignored.message)
        }
    }
}



