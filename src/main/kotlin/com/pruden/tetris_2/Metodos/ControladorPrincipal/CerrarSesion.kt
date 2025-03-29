package com.pruden.tetris_2.Metodos.ControladorPrincipal

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.Clan.ControladorCrearClan.Companion.fotoClanSeleccionada
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas
import com.pruden.tetris_2.Controladores.TusModos.ControladorCrearModo.Companion.fotoModoDeJuegoSeleccionada
import com.pruden.tetris_2.Metodos.BolsaPiezas.piezasBolsa
import com.pruden.tetris_2.Metodos.BolsaPiezas.siguientePieza
import com.pruden.tetris_2.Metodos.Modos.cargarPosicionesPiezasModos
import com.pruden.tetris_2.Metodos.Stages.cargarLogin
import javafx.stage.Stage

fun cerrarSesion(){
    if(!ControladorPrincipal.animacionEnCurso){
        vTableroPrin()
        vTipos()
        vConfiguracionesCustom()
        vReiniciarPartida()
        ControladorCustomPiezas.listaPiezasSeleccionadas = cargarPosicionesPiezasModos(intArrayOf(0, 1, 2, 3, 4, 5, 6))
        vStages()
        idJugador = -1

        //Fotos
        fotoModoDeJuegoSeleccionada = null
        fotoClanSeleccionada = null

    }
}

private fun vTableroPrin(){
    Globales.FILAS = 20
    Globales.COLUMNAS = 10
    Globales.TAMANO_CELDA =33
}

private fun vTipos(){
    ControladorPrincipal.tipoPieza = 4
    ControladorPrincipal.tipoTableroSecun = 1
    ControladorPrincipal.tipoTableroPrin = 1
}

private fun vConfiguracionesCustom(){
    ControladorPrincipal.TIEMPO_CAIDA_PIEZAS_INICIAL = 1500
    ControladorPrincipal.LINEAS_POR_NIVEL = 10
    ControladorPrincipal.REDUCCION_TIEMPO_POR_NIVEL = 100
    ControladorPrincipal.LIMITE_ROTACIONES = 999999999
    ControladorPrincipal.LIMITE_ROTACIONES_B = false
    ControladorPrincipal.rotacionesActuales = 0
    ControladorPrincipal.tiempoCaidaPieza = ControladorPrincipal.TIEMPO_CAIDA_PIEZAS_INICIAL
    ControladorPrincipal.puedeHoldear = false
    ControladorPrincipal.holdActivo = true
    ControladorPrincipal.dashActivo = false
    ControladorPrincipal.siguientesPiezaActivo = true
}

private fun vReiniciarPartida(){
    ControladorPrincipal.timelinePartida.stop()
    ControladorPrincipal.partidaEnCurso = false
    ControladorPrincipal.animacionEnCurso = false

    siguientePieza.clear()
    piezasBolsa.clear()
    ControladorPrincipal.piezaHold.clear()
}

private fun vStages(){
    ControladorPrincipal.stagePrincipal.close()
    cargarLogin(Stage())
}