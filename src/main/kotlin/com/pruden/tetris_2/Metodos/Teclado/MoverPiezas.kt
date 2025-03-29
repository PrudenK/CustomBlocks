package com.pruden.tetris_2.Metodos.Teclado

import com.pruden.tetris_2.Constantes.Logros
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.dashActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaActual
import com.pruden.tetris_2.Metodos.Logros.completarLogro
import com.pruden.tetris_2.Piezas.Pieza_Z_v3
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.util.Duration

private var upPressedTimeLine: Timeline? = null


fun moverPiezas(evento: KeyEvent) {
    if (partidaEnCurso) {
        try {
            when {
                evento.code == KeyCode.LEFT && evento.isControlDown && dashActivo -> dashIzquierda()
                evento.code == KeyCode.LEFT -> piezaActual.izquierda()
                evento.code == KeyCode.RIGHT && evento.isControlDown && dashActivo -> dashDerecha()
                evento.code == KeyCode.RIGHT -> piezaActual.derecha()
                evento.code == KeyCode.DOWN -> bajar()
                evento.code == KeyCode.UP -> {
                    rotarPieza()

                    if (upPressedTimeLine == null && piezaActual is Pieza_Z_v3 && !jugadorConTodo.listaLogros.find { it.idLogro == Logros.NAIN_NAIN_NAIN }!!.completado) {
                        upPressedTimeLine = Timeline(
                            KeyFrame(Duration.seconds(1.0), {
                                completarLogro(Logros.NAIN_NAIN_NAIN)
                            })
                        )
                        upPressedTimeLine!!.setOnFinished {
                            upPressedTimeLine = null
                        }
                        upPressedTimeLine!!.play()
                    }

                }
                evento.code == KeyCode.SPACE -> moverEspacio(evento)
                evento.code == KeyCode.H -> holdear()
            }
        } catch (e: Exception) {
            println("error")
        }
    }
}

fun onKeyReleased(evento: KeyEvent) {
    if (evento.code == KeyCode.UP) {
        upPressedTimeLine?.stop()
        upPressedTimeLine = null
    }
}

