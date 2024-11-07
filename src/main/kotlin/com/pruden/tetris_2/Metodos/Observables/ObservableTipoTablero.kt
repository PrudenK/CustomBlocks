package com.pruden.tetris_2.Metodos.Observables

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcHold
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente1
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente2
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente3
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroSecun
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones.Companion.cambioTipoTablero
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones.Companion.cambioTipoTableroSinReiniciar
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones.Companion.cambioTipoTableroSinReiniciarSecundario
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTipoTablero.Companion.guardarTipoTablero
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTipoTablero.Companion.guardarTipoTableroSinReiciniar
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTipoTablero.Companion.guardarTipoTableroSinReiciniarSecundario
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTipoTablero.Companion.stageTipoTablero
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTipoTablero.Companion.tableroPrincipalNum
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTipoTablero.Companion.tableroSecundarioNum
import com.pruden.tetris_2.Metodos.BolsaPiezas.dibujarPiezasSiguientes
import com.pruden.tetris_2.Metodos.DibujarTablero.General.borrarTableroSecundario
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroPrincipal
import com.pruden.tetris_2.Metodos.Timelines.borrarMascara
import javafx.beans.property.SimpleBooleanProperty

fun cargarObservableTipoTablero(){
    guardarTipoTablero = SimpleBooleanProperty(false)

    guardarTipoTablero.addListener { _, _, newValue ->
        if (newValue) {

            cambioTipoTablero = true
            stageTipoTablero.close()
        }
    }
}

fun cargarObservableTipoTableroSinReiniciar(){
    guardarTipoTableroSinReiciniar = SimpleBooleanProperty(false)

    guardarTipoTableroSinReiciniar.addListener { _, _, newValue ->
        if (newValue) {
            cambioTipoTableroSinReiniciar  = true
            stageTipoTablero.close()
        }
    }
}

fun cargarObservableTipoTableroSinReiniciarSecundario(){
    guardarTipoTableroSinReiciniarSecundario = SimpleBooleanProperty(false)

    guardarTipoTableroSinReiciniarSecundario.addListener { _, _, newValue ->
        if (newValue) {
            cambioTipoTableroSinReiniciarSecundario  = true
            stageTipoTablero.close()
        }
    }
}



fun cambiosTipoTablero() {
    tipoTableroPrin = tableroPrincipalNum
    tipoTableroSecun = tableroSecundarioNum

    borrarMascara()
    dibujarTableroPrincipal()

    cambiosTipoTableroSecundario()
}

fun cambiosTipoTableroSecundario() {
    tipoTableroSecun = tableroSecundarioNum

    borrarTableroSecundario(gcSiguiente1)
    borrarTableroSecundario(gcSiguiente2)
    borrarTableroSecundario(gcSiguiente3)
    borrarTableroSecundario(gcHold)

    dibujarPiezasSiguientes(-1)
}
