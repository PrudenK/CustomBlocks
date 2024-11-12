package com.pruden.tetris_2.Metodos.ModoCampa.CargarNivel

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.objFasesNivel
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.objPuntuacionBajar
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero
import com.pruden.tetris_2.Metodos.BorrarPiezas.objLineasNivel
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroPrincipal
import com.pruden.tetris_2.Metodos.DibujarTablero.cambioDeTablero
import com.pruden.tetris_2.Metodos.ModoCampa.Nivel
import com.pruden.tetris_2.Metodos.Modos.cargarPosicionesPiezasModos

fun cargarNivel(nivel: Nivel){
    with(cPrin) {
        with(nivel) {
            mundoNivel.text = nivel.nombre
            ControladorCustomPiezas.listaPiezasSeleccionadas = cargarPosicionesPiezasModos(piezasDisponiblesPosiciones)

            ControladorPrincipal.TIEMPO_CAIDA_PIEZAS_INICIAL = tiempoCaidaInicial
            ControladorPrincipal.LINEAS_POR_NIVEL = lineasParaAumento

            ControladorPrincipal.REDUCCION_TIEMPO_POR_NIVEL = saltoDeTiempoPorLineas

            ControladorPrincipal.LIMITE_ROTACIONES_B = limiteRotacionesB
            if (ControladorPrincipal.LIMITE_ROTACIONES_B) ControladorPrincipal.LIMITE_ROTACIONES = limiteRotacionesNum

            ControladorPrincipal.holdActivo = holdActivoNivel



            ControladorPrincipal.siguientesPiezaActivo = siguientesDisponibles

            ControladorPrincipal.tipoTableroPrin = tipoTablero

            ControladorPrincipal.FILAS = (ControladorCustomTablero.listaNumFilas[tablero])
            ControladorPrincipal.COLUMNAS = (ControladorCustomTablero.listaNumColumnas[tablero])
            ControladorPrincipal.TAMANO_CELDA = (ControladorCustomTablero.listaTamaCelda[tablero])


            dibujarTableroPrincipal()
            cambioDeTablero()


            ControladorPrincipal.dashActivo = dash

            ControladorPrincipal.tiempoObj = tiempoObj
            ControladorPrincipal.lineasObj = lineasObj.toString()

            ControladorPrincipal.nivelEnJuego = true

            cPrin.cronometroLabel.text = "0:00:00" + tiempoObj
            cPrin.labelPuntuacion.text = "0/$puntuacionObj"
            cPrin.labelLineas.text = "0/$lineasObj"

            objPuntuacionBajar = "/$puntuacionObj"
            objLineasNivel = "/$lineasObj"
            objFasesNivel = "/$numFases"

            cPrin.labelNivelTit.text = "Fase del nivel"
            cPrin.labelNivel.text = "0/$numFases"

            cPrin.labelModo.text = "Campaña"

            ControladorPrincipal.nivelTerminado = false
            ControladorPrincipal.nivelCompletado = false

        }
    }
}