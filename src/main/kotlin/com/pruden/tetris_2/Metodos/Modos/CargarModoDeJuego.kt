package com.pruden.tetris_2.Metodos.Modos


import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES_B
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LINEAS_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.REDUCCION_TIEMPO_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TIEMPO_CAIDA_PIEZAS_INICIAL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.dashActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.holdActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.siguientesPiezaActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas.Companion.listaPiezasSeleccionadas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaNumColumnas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaNumFilas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaTamaCelda
import com.pruden.tetris_2.Metodos.BolsaPiezas.piezasBolsa
import com.pruden.tetris_2.Metodos.BolsaPiezas.siguientePieza
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroPrincipal
import com.pruden.tetris_2.Metodos.DibujarTablero.cambioDeTablero
import com.pruden.tetris_2.Metodos.ModoCampa.cambiarLabelsAlSalirDelModoCampa
import com.pruden.tetris_2.Metodos.Timelines.borrarMascara

fun cargarCambiosModo(modo : ModoDeJuego){
    with(modo){
        listaPiezasSeleccionadas = cargarPosicionesPiezasModos(piezasDisponiblesPosiciones)
        TIEMPO_CAIDA_PIEZAS_INICIAL = tiempoCaidaInicial
        LINEAS_POR_NIVEL = lineasPorNivel
        REDUCCION_TIEMPO_POR_NIVEL = saltoDeTiempoPorNivel
        LIMITE_ROTACIONES_B = limiteRotacionesB
        if (LIMITE_ROTACIONES_B) LIMITE_ROTACIONES = limiteRotacionesNum
        holdActivo = holdActivoModo

        Globales.FILAS = (listaNumFilas[tablero])
        Globales.COLUMNAS = (listaNumColumnas[tablero])
        Globales.TAMANO_CELDA = (listaTamaCelda[tablero])

        siguientesPiezaActivo = siguientesDisponibles

        siguientePieza.clear()
        piezasBolsa.clear()

        cPrin.labelModo.text = nombre

        tipoTableroPrin = tipoTablero

        dashActivo = dash

        cambioDeTablero()

        borrarMascara()
        dibujarTableroPrincipal()

        cambiarLabelsAlSalirDelModoCampa()

    }
}