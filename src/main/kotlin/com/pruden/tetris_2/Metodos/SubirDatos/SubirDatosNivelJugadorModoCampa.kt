package com.pruden.tetris_2.Metodos.SubirDatos

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idNivelActual
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaNivelesJugador
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun subirDatosNivelCompeltado(){
    CoroutineScope(Dispatchers.IO).launch {
        ApiCustom.nivelJugadorService.completarNivel(
            tiempo = "/${cPrin.cronometroLabel.text.split("/")[0]}",
            puntuacion = cPrin.labelPuntuacion.text.split("/")[0].toInt(),
            idNivel = idNivelActual,
            id = idJugador
        )

        listaNivelesJugador[idNivelActual].desbloqueado = true
        listaNivelesJugador[idNivelActual-1].completado = true
    }
}