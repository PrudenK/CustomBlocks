package com.pruden.tetris_2.Metodos.IniciarPartida

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOpciones
import com.pruden.tetris_2.Metodos.BorrarPiezas.reiniciarLineasBorradas
import com.pruden.tetris_2.Metodos.DibujarTablero.General.borrarTableroSecundario
import com.pruden.tetris_2.Metodos.DibujarTablero.cambioDeTablero
import com.pruden.tetris_2.Metodos.Matriz.borrarCasillas
import com.pruden.tetris_2.Metodos.Observables.cambiosTipoTablero

fun reiniciarPartida(){
    if (!ControladorPrincipal.animacionEnCurso) {
        ControladorPrincipal.hasPerdido = false
        reiniciarLineasBorradas()
        ControladorPrincipal.tiempoCaidaPieza = ControladorPrincipal.TIEMPO_CAIDA_PIEZAS_INICIAL

        borrarTableroSecundario(ControladorPrincipal.gcSiguiente1)
        borrarTableroSecundario(ControladorPrincipal.gcSiguiente2)
        borrarTableroSecundario(ControladorPrincipal.gcSiguiente3)
        borrarTableroSecundario(ControladorPrincipal.gcHold)

        ControladorPrincipal.cronometro.parar()
        ControladorPrincipal.cronometro.seTCronometroA0()

        cuentaAtras()

        borrarCasillas()
        reiniciarLabels()

        if (ControladorCustomOpciones.cambioTablero){
            cambioDeTablero()
            ControladorCustomOpciones.cambioTablero = false
        }

        if(ControladorCustomOpciones.cambioTipoTablero){
            cambiosTipoTablero()
            ControladorCustomOpciones.cambioTipoTablero = false
        }

        Thread { iniciarPartida() }.start()
    }
}