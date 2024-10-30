package com.pruden.tetris_2.Metodos.Teclado

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES_B
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcHold
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.holdActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaActual
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaHold
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.puedeHoldear
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.rotacionesActuales
import com.pruden.tetris_2.Metodos.Media.Audio.efectoSonido
import com.pruden.tetris_2.Metodos.BolsaPiezas.devolverPiezaAleatoria
import com.pruden.tetris_2.Metodos.DibujarTablero.General.borrarTableroSecundario
import com.pruden.tetris_2.Metodos.DibujarTablero.General.pintarPiezaTableroSecun
import com.pruden.tetris_2.Piezas.Pieza_I

fun holdear(){
    if (puedeHoldear && holdActivo){
        borrarTableroSecundario(gcHold)
        piezaActual.limpiar()

        piezaActual.set_Orientacion(0)
        if (piezaActual is Pieza_I) {
            piezaActual.set_Orientacion(4)
        }
        pintarPiezaTableroSecun(gcHold, piezaActual)
        piezaHold.add(piezaActual)

        if (piezaHold.size == 1) {
            piezaActual = devolverPiezaAleatoria()
        } else {
            piezaActual = piezaHold.removeAt(0)
            piezaActual.fila = 0
            piezaActual.set_Orientacion(0)
            piezaActual.columna = (COLUMNAS / 2 - 2)
            piezaActual.pintar()

            if(LIMITE_ROTACIONES_B) rotacionesActuales = LIMITE_ROTACIONES
        }
        efectoSonido("/Musica/Efectos/sonido_hold_true.mp3")
        puedeHoldear = false

    } else {
        efectoSonido("/Musica/Efectos/sonido_hold_false.mp3")
    }
}