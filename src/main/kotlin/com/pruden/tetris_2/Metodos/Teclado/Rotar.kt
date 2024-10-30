package com.pruden.tetris_2.Metodos.Teclado

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Metodos.Media.Audio.efectoSonido

fun rotarPieza(){
    if (ControladorPrincipal.LIMITE_ROTACIONES_B) {
        if (ControladorPrincipal.rotacionesActuales > 0) {
            if (ControladorPrincipal.piezaActual.rotar()) {
                ControladorPrincipal.rotacionesActuales--
                efectoSonido("/Musica/Efectos/audioRotar.mp3")
            }
        }
    } else {
        if (ControladorPrincipal.piezaActual.rotar()) {
            efectoSonido("/Musica/Efectos/audioRotar.mp3")
        }
    }
}
