package com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.PantallaDeCarga

import com.pruden.tetris_2.API.ObjsAux.Nivel
import com.pruden.tetris_2.Controladores.ModoCampa.ControladorCargarNivel.Companion.cCargarNivel


lateinit var nivelModoCampa : Nivel

fun cargarLabelsCargaNivel(){
    with(nivelModoCampa){
        with(cCargarNivel){
            tituloLabel.text = nombre
            caidaInicialLabel.text = tiempoCaidaInicial.toString()
            saltoTiempoLabel.text = saltoDeTiempoPorLineas.toString()
            saltoTiempoLineasLabel.text = lienasParaAumentar.toString()
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

