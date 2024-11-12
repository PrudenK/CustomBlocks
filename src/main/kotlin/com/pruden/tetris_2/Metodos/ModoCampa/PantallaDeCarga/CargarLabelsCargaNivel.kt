package com.pruden.tetris_2.Metodos.ModoCampa.PantallaDeCarga

import com.pruden.tetris_2.Controladores.ModoCampa.ControladorCargarNivel.Companion.cCargarNivel
import com.pruden.tetris_2.Metodos.ModoCampa.Nivel


lateinit var nivel : Nivel

fun cargarLabelsCargaNivel(){
    with(nivel){
        with(cCargarNivel){
            tituloLabel.text = nombre
            caidaInicialLabel.text = tiempoCaidaInicial.toString()
            saltoTiempoLabel.text = saltoDeTiempoPorLineas.toString()
            saltoTiempoLineasLabel.text = lineasParaAumento.toString()
            limiteRotacionesLabel.text = limiteRotaciones()
            holdLabel.text = holdTxt()
            tamaTableroLabel.text= tableroTxt()
            objetivosLabel.text = objetivosTxt()
            siguientesPiezasLabel.text = siguientesPiezas()
            tipoTableroLabel.text = tipoTablero()
            dashLabel.text = dashDisponible()
        }
    }
}

