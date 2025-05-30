package com.pruden.tetris_2.Metodos.Teclado

import com.pruden.tetris_2.Metodos.SubirDatos.contadorPiezas
import com.pruden.tetris_2.Metodos.SubirDatos.sumarTipoPieza
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.eresHostPVP
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugarOnline
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.objPuntuacionBajar
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaPVPenCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaActual
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Metodos.Media.Audio.efectoSonido
import com.pruden.tetris_2.Metodos.BolsaPiezas.devolverPiezaAleatoria
import com.pruden.tetris_2.Metodos.DibujarTablero.General.cambiarParesImparesTablero3y4
import javafx.scene.input.KeyEvent

fun bajar(){
    if (moverPiezaAbajo()) {

        //TODO posible refactor en un futuro
        val label = when {
            partidaPVPenCurso && eresHostPVP -> cPrin.puntuacionHostLabel
            partidaPVPenCurso && !eresHostPVP -> cPrin.puntuacionVisiLabel
            else -> cPrin.labelPuntuacion
        }

        label.text = (label.text.split("/")[0].toInt() + 2).toString() + objPuntuacionBajar
        efectoSonido("/Musica/Efectos/sonidoMoverPieza.mp3")
    }
}

fun moverEspacio(event : KeyEvent){
    event.consume()
    while (moverPiezaAbajo()) {

        val label = when {
            partidaPVPenCurso && eresHostPVP -> cPrin.puntuacionHostLabel
            partidaPVPenCurso && !eresHostPVP -> cPrin.puntuacionVisiLabel
            else -> cPrin.labelPuntuacion
        }


        label.text = (label.text.split("/")[0].toInt() + 4).toString() + objPuntuacionBajar
    }
    efectoSonido("/Musica/Efectos/caidaPieza.mp3")
}

fun moverPiezaAbajo() :Boolean{
    if(piezaActual.bajar()){
        if (jugarOnline) sumarTipoPieza(piezaActual)
        println(contadorPiezas)
        piezaActual = devolverPiezaAleatoria()
        if (tipoTableroPrin == 3 || tipoTableroPrin == 4) cambiarParesImparesTablero3y4()
        return false
    }
    return true
}

