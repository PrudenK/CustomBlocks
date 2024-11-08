package com.pruden.tetris_2.Metodos.Perder

import com.pruden.tetris_2.BaseDeDatos.SubirDatos.subirDatosPerder
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.hasPerdido
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugarOnline
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage

fun comprbarPerder(){
    if (verificarPerdida()) {
        hasPerdido = true
        timelinePartida.stop()
        cronometro.parar()

        crearStage(ClaseStage("Vistas/Otras/vista_Perder.fxml", cPrin.nuevaPartidaB, 315.0, 400.0, null, 0, -60))

        if (jugarOnline) subirDatosPerder()
    }
}

fun verificarPerdida(): Boolean {
    for (columna in 0 until COLUMNAS) {
        if (matrizNumerica[2][columna] != BLANCO) {  // Si alguna celda no está vacía
            return true // Has perdido
        }
    }
    return false // No has perdido
}

