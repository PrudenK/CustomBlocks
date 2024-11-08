package com.pruden.tetris_2.Metodos.Teclado

import com.pruden.tetris_2.BaseDeDatos.SubirDatos.sumarTipoPieza
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugarOnline
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaActual
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Metodos.Media.Audio.efectoSonido
import com.pruden.tetris_2.Metodos.BolsaPiezas.devolverPiezaAleatoria
import com.pruden.tetris_2.Metodos.DibujarTablero.General.cambiarParesImparesTablero3y4
import javafx.scene.input.KeyEvent

fun bajar(){
    if (moverPiezaAbajo()) {
        cPrin.labelPuntuacion.text = (cPrin.labelPuntuacion.text.toInt() + 2).toString()
        efectoSonido("/Musica/Efectos/sonidoMoverPieza.mp3")
    }
}

fun moverEspacio(event : KeyEvent){
    event.consume()
    while (moverPiezaAbajo()) {
       cPrin.labelPuntuacion.text = (cPrin.labelPuntuacion.text.toInt() + 4).toString()
    }
    efectoSonido("/Musica/Efectos/caidaPieza.mp3")
}

fun moverPiezaAbajo() :Boolean{
    if(piezaActual.bajar()){
        if (jugarOnline) sumarTipoPieza(piezaActual)
        piezaActual = devolverPiezaAleatoria()
        if (tipoTableroPrin == 3 || tipoTableroPrin == 4) cambiarParesImparesTablero3y4()
        return false
    }
    return true
}

