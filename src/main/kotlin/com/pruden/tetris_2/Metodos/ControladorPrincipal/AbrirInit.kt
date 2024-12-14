package com.pruden.tetris_2.Metodos.ControladorPrincipal

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Metodos.Cronometro.Cronometro
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroPrincipal
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroSecundario
import com.pruden.tetris_2.Metodos.Eventos.arrastrarFun
import com.pruden.tetris_2.Metodos.IniciarPartida.setStackpane18x10
import com.pruden.tetris_2.Metodos.Matriz.rellenarMatriz
import com.pruden.tetris_2.Metodos.Media.Audio.musicaPartida
import com.pruden.tetris_2.Metodos.Media.deRutaAAudio
import com.pruden.tetris_2.Metodos.Observables.cargarObervableCerrarStageAltF4
import com.pruden.tetris_2.Metodos.Observables.cargarObervableNivel
import javafx.animation.Timeline
import javafx.application.Platform
import javafx.scene.shape.Rectangle
import java.util.concurrent.locks.ReentrantLock


fun cargarTodoInit(){
    tablerosInit()
    cargarArrastrar()
    cargarVariablesInit()
    cargarObervablesInit()
    Platform.runLater{
        cargarMusicaInit()
    }

    cargarBotonIniciarCerrarSesionInit()
}

private fun tablerosInit(){
    rellenarMatriz()
    cargarGc()
    cargarTableros()
    cPrin.canvasPrincipal.clip = Rectangle(0.0, (2 * ControladorPrincipal.TAMANO_CELDA).toDouble(),
        cPrin.canvasPrincipal.width, cPrin.canvasPrincipal.height - 2 * ControladorPrincipal.TAMANO_CELDA)
    ControladorPrincipal.stackPaneX = cPrin.stackPane.layoutX
    ControladorPrincipal.stackPaneY = cPrin.stackPane.layoutY
    setStackpane18x10()
}

private fun cargarArrastrar(){
    arrastrarFun(cPrin.idPrincipal)
}
private fun cargarObervablesInit(){
    cargarObervableCerrarStageAltF4()
    cargarObervableNivel()
}

private fun cargarMusicaInit(){
    musicaPartida(deRutaAAudio("/Musica/Canciones/saturada.mp3"))
}

private fun cargarVariablesInit(){
    ControladorPrincipal.timelinePartida = Timeline()
    ControladorPrincipal.lockCuentaRegresiva = ReentrantLock()
    ControladorPrincipal.cronometro = Cronometro()
}
private fun cargarBotonIniciarCerrarSesionInit(){
    Platform.runLater{
        cPrin.sesionB.text = if (ControladorPrincipal.jugarOnline) "Cerrar sesión" else "Iniciar sesión"
    }
}

private fun cargarTableros(){
    dibujarTableroPrincipal()
    dibujarTableroSecundario(ControladorPrincipal.gcSiguiente1)
    dibujarTableroSecundario(ControladorPrincipal.gcSiguiente2)
    dibujarTableroSecundario(ControladorPrincipal.gcSiguiente3)
    dibujarTableroSecundario(ControladorPrincipal.gcHold)
}

private fun cargarGc(){
    ControladorPrincipal.gcPrincipal = cPrin.canvasPrincipal.graphicsContext2D
    ControladorPrincipal.gcMascara = cPrin.canvasMascara.graphicsContext2D
    ControladorPrincipal.gcSiguiente1 = cPrin.canvasSiguientePieza1.graphicsContext2D
    ControladorPrincipal.gcSiguiente2 = cPrin.canvasSiguientePieza2.graphicsContext2D
    ControladorPrincipal.gcSiguiente3 = cPrin.canvasSiguientePieza3.graphicsContext2D
    ControladorPrincipal.gcHold = cPrin.canvasHold.graphicsContext2D
}

