package com.pruden.tetris_2.Metodos.ModosDeJuego.PVP

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin

fun     // Limpieza después de cerrarse
compararJugadoresDesdeUI(): Resultado {
    val nivelPropio: Int
    val lineasPropias: Int
    val puntosPropios: Int
    val nivelRival: Int
    val lineasRival: Int
    val puntosRival: Int

    if (ControladorPrincipal.eresHostPVP) {
        nivelPropio = cPrin.nivelHostLabel.text.toInt()
        lineasPropias = cPrin.lineasHostLabel.text.toInt()
        puntosPropios = cPrin.puntuacionHostLabel.text.toInt()

        nivelRival = cPrin.nivelVisiLabel.text.toInt()
        lineasRival = cPrin.lineasVisiLabel.text.toInt()
        puntosRival = cPrin.puntuacionVisiLabel.text.toInt()
    } else {
        nivelPropio = cPrin.nivelVisiLabel.text.toInt()
        lineasPropias = cPrin.lineasVisiLabel.text.toInt()
        puntosPropios = cPrin.puntuacionVisiLabel.text.toInt()

        nivelRival = cPrin.nivelHostLabel.text.toInt()
        lineasRival = cPrin.lineasHostLabel.text.toInt()
        puntosRival = cPrin.puntuacionHostLabel.text.toInt()
    }

    return when {
        nivelPropio < nivelRival -> Resultado.GANA_EL_OTRO
        nivelPropio > nivelRival -> Resultado.GANA_EL_JUGADOR

        lineasPropias < lineasRival -> Resultado.GANA_EL_OTRO
        lineasPropias > lineasRival -> Resultado.GANA_EL_JUGADOR

        puntosPropios < puntosRival -> Resultado.GANA_EL_OTRO
        puntosPropios > puntosRival -> Resultado.GANA_EL_JUGADOR

        else -> Resultado.EMPATE
    }
}
