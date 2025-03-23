package com.pruden.tetris_2.Metodos.Perder

import com.pruden.tetris_2.Metodos.SubirDatos.subirDatosPartida
import com.pruden.tetris_2.Metodos.SubirDatos.subirTodoEstaPiezas
import com.pruden.tetris_2.Metodos.SubirDatos.sumarTipoPieza
import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.hasPerdido
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.nivelEnJuego
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Metodos.ModoCampa.FinDelNivel.perderNivelModoCampa
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage

fun comprbarPerder(){
    if (verificarPerdida()) {
        hasPerdido = true
        timelinePartida.stop()
        cronometro.parar()

        if(nivelEnJuego){
            perderNivelModoCampa()
        }else{
            crearStage(ClaseStage("Vistas/Otras/vista_Perder.fxml", cPrin.nuevaPartidaB, 315.0, 232.0, null, 0, -120))
        }


        subirDatosFinDePartida()
    }
}

fun subirDatosFinDePartida(){
    subirDatosPartida()
    sumarTipoPieza(ControladorPrincipal.piezaActual)
    subirTodoEstaPiezas()
}

private fun verificarPerdida(): Boolean {
    for (columna in 0 until Globales.COLUMNAS) {
        if (matrizNumerica[2][columna] != Globales.BLANCO) {  // Si alguna celda no está vacía
            return true // Has perdido
        }
    }
    return false // No has perdido
}

