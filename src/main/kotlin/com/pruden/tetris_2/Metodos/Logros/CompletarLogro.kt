package com.pruden.tetris_2.Metodos.Logros

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaLogrosJugador
import com.pruden.tetris_2.Metodos.Stages.cargarStageNotificacionLogro
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun completarLogro(idLogro : Int){
    CoroutineScope(Dispatchers.IO).launch {
        ApiCustom.logroService.completarLogro(idLogro, idJugador)
        val logro = listaLogrosJugador.find{ it.idLogro == idLogro}
        logro!!.completado = true

        javafx.application.Platform.runLater {
            cargarStageNotificacionLogro(Stage(), logro)
        }
    }
}