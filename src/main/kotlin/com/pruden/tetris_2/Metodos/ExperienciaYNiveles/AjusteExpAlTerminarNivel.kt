package com.pruden.tetris_2.Metodos.ExperienciaYNiveles

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Metodos.ModosDeJuego.PVP.mostrarMensajeConAnimacion
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun ajusteExpAlTerminarNivel(){
    val xp = SistemaProgresion.calcularXPLinea(
        lineas = cPrin.labelLineas.text.split("/")[0].toInt(),
        modo = cPrin.labelModo.text,
        tipoTablero = ControladorPrincipal.tipoTableroPrin
    )

    jugadorConTodo!!.experiencia += xp
    val experienciaJugador = jugadorConTodo!!.experiencia
    val nivelAntiguo = jugadorConTodo!!.nivel
    val nuevoNivel = SistemaProgresion.calcularNivelPorXP(experienciaJugador)
    jugadorConTodo!!.nivel = nuevoNivel

    CoroutineScope(Dispatchers.IO).launch {
        ApiCustom.jugadorService.jugarActualizaNivelEXP(jugadorConTodo!!.id, experienciaJugador, nuevoNivel)
    }

    if(nuevoNivel > nivelAntiguo){
        mostrarMensajeConAnimacion("¡Has subido al nivel $nuevoNivel!", cPrin.hasSubidDeNivel)
    }
}