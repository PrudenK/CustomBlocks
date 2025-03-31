package com.pruden.tetris_2.Metodos.Logros

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Constantes.Globales.colaLogros
import com.pruden.tetris_2.Constantes.Globales.mostrandoNotificacion
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Metodos.Stages.cargarStageNotificacionLogro
import javafx.animation.PauseTransition
import javafx.stage.Stage
import javafx.util.Duration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun completarLogro(idLogro : Int){
    CoroutineScope(Dispatchers.IO).launch {
        ApiCustom.logroService.completarLogro(idLogro, idJugador)
        val logro = jugadorConTodo!!.listaLogros.find{ it.idLogro == idLogro}
        logro!!.completado = true

        withContext(Dispatchers.Main) {
            logro.let {
                colaLogros.add(it)
                mostrarSiguienteNotificacion()
            }
        }
    }
}

fun mostrarSiguienteNotificacion() {
    if (mostrandoNotificacion || colaLogros.isEmpty()) return

    val logro = colaLogros.removeFirst()
    mostrandoNotificacion = true

    val stage = Stage()
    cargarStageNotificacionLogro(stage, logro)

    val delay = PauseTransition(Duration.seconds(2.0))
    delay.setOnFinished {
        stage.close()
        mostrandoNotificacion = false
        mostrarSiguienteNotificacion()
    }
    delay.play()
}
