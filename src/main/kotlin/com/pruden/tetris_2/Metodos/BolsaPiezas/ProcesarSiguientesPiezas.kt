package com.pruden.tetris_2.Metodos.BolsaPiezas

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Metodos.DibujarTablero.General.borrarTableroSecundario
import com.pruden.tetris_2.Metodos.DibujarTablero.General.pintarPiezaTableroSecun
import com.pruden.tetris_2.Piezas.Piezas

fun dibujarPiezasSiguientes(ajustTableros: Int) {
    if (ControladorPrincipal.siguientesPiezaActivo && ControladorPrincipal.partidaEnCurso) {
        borrarTableroSecundario(ControladorPrincipal.gcSiguiente1)
        borrarTableroSecundario(ControladorPrincipal.gcSiguiente2)
        borrarTableroSecundario(ControladorPrincipal.gcSiguiente3)

        borrarTableroSecundario(ControladorPrincipal.gcHold)

        val siguientePieza1: Piezas = siguientePieza[1 + ajustTableros]
        val siguientePieza2: Piezas = siguientePieza[2 + ajustTableros]
        val siguientePieza3: Piezas = siguientePieza[3 + ajustTableros]

        pintarPiezaTableroSecun(ControladorPrincipal.gcSiguiente1, siguientePieza1)
        pintarPiezaTableroSecun(ControladorPrincipal.gcSiguiente2, siguientePieza2)
        pintarPiezaTableroSecun(ControladorPrincipal.gcSiguiente3, siguientePieza3)

        if (ControladorPrincipal.piezaHold.isNotEmpty()) pintarPiezaTableroSecun(ControladorPrincipal.gcHold, ControladorPrincipal.piezaHold[0])
    }
}