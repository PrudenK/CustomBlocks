package com.pruden.tetris_2.Metodos.ModosDeJuego.TusModos

import com.pruden.tetris_2.API.ObjsAux.ModoDeJuegoAPI
import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES_B
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LINEAS_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.REDUCCION_TIEMPO_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TIEMPO_CAIDA_PIEZAS_INICIAL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.dashActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcHold
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente1
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente2
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente3
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.holdActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.siguientesPiezaActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroSecun
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas.Companion.listaPiezasSeleccionadas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaNumColumnas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaNumFilas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaTamaCelda
import com.pruden.tetris_2.Metodos.BolsaPiezas.piezasBolsa
import com.pruden.tetris_2.Metodos.BolsaPiezas.siguientePieza
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroPrincipal
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroSecundario
import com.pruden.tetris_2.Metodos.DibujarTablero.cambioDeTablero
import com.pruden.tetris_2.Metodos.IniciarPartida.reiniciarPartida
import com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.cambiarLabelsAlSalirDelModoCampa
import com.pruden.tetris_2.Metodos.ModosDeJuego.Modos.cargarPosicionesPiezasModos
import com.pruden.tetris_2.Metodos.Timelines.borrarMascara

fun cargarCambiosTusModos(modo : ModoDeJuegoAPI){
    val listaIndicesAjustadosDisePiezas = listOf(0,3,4,5,6)
    with(modo){
        listaPiezasSeleccionadas = cargarPosicionesPiezasModos(arraPiezas())
        TIEMPO_CAIDA_PIEZAS_INICIAL = tiempocaidainicial
        LINEAS_POR_NIVEL = lineasparasaltonivel
        REDUCCION_TIEMPO_POR_NIVEL = saltodetiempopornivel
        LIMITE_ROTACIONES_B = hayLimiteRotaciones()
        if (LIMITE_ROTACIONES_B) LIMITE_ROTACIONES = limiterotaciones
        holdActivo = hayHoldActivado()

        Globales.FILAS = (listaNumFilas[tablero])
        Globales.COLUMNAS = (listaNumColumnas[tablero])
        Globales.TAMANO_CELDA = (listaTamaCelda[tablero])

        siguientesPiezaActivo = siguientesPiezas()

        siguientePieza.clear()
        piezasBolsa.clear()

        cPrin.labelModo.text = nombre

        tipoTableroPrin = tipotableroprincipal

        ControladorPrincipal.tipoPieza = listaIndicesAjustadosDisePiezas[tipopieza]
        tipoTableroSecun = tipotablerosecun

        dashActivo = dashDisponible()

        cambioDeTablero()
        borrarMascara()

        dibujarTableroPrincipal()
        dibujarTableroSecundario(gcHold)
        dibujarTableroSecundario(gcSiguiente1)
        dibujarTableroSecundario(gcSiguiente2)
        dibujarTableroSecundario(gcSiguiente3)

        cambiarLabelsAlSalirDelModoCampa()
        cPrin.partdiaNueva()
    }
}