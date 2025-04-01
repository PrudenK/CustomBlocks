package com.pruden.tetris_2.Metodos.PartidasGuardadas

import com.pruden.tetris_2.API.ObjsAux.PartidaGuardada
import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FONDO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES_B
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LINEAS_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.REDUCCION_TIEMPO_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TIEMPO_CAIDA_PIEZAS_INICIAL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcHold
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente1
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente2
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.gcSiguiente3
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.rotacionesActuales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.siguientesPiezaActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroSecun
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas.Companion.listaPiezasSeleccionadas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaNumColumnas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaNumFilas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaTamaCelda
import com.pruden.tetris_2.Metodos.BolsaPiezas.dibujarPiezasSiguientes
import com.pruden.tetris_2.Metodos.BolsaPiezas.piezasBolsa
import com.pruden.tetris_2.Metodos.BolsaPiezas.siguientePieza
import com.pruden.tetris_2.Metodos.DibujarTablero.General.borrarTableroSecundario
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroPrincipal
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroSecundario
import com.pruden.tetris_2.Metodos.DibujarTablero.General.pintarPiezaTableroSecun
import com.pruden.tetris_2.Metodos.DibujarTablero.cambioDeTablero
import com.pruden.tetris_2.Metodos.Matriz.pintarMatriz
import com.pruden.tetris_2.Metodos.ModosDeJuego.Modos.cargarPosicionesPiezasModos
import com.pruden.tetris_2.Metodos.Piezas.Pintar.pintarCasilla
import com.pruden.tetris_2.Metodos.Timelines.actualizarTimeline
import com.pruden.tetris_2.Metodos.Timelines.borrarMascara
import com.pruden.tetris_2.Piezas.*

fun cargarPartidaGuardada(p : PartidaGuardada){
    with(p){
        // Eliminr pieza hold de antes si la hay
        if(ControladorPrincipal.piezaHold.isNotEmpty()){
            ControladorPrincipal.piezaHold.removeAt(0)
        }
        piezasBolsa.clear()


        Globales.FILAS = (listaNumFilas[tamaTablero])
        Globales.COLUMNAS = (listaNumColumnas[tamaTablero])
        Globales.TAMANO_CELDA = (listaTamaCelda[tamaTablero])

        cambioDeTablero()

        tipoTableroPrin = diseTablero
        tipoTableroSecun = tipoTableroSecun

        dibujarTableroPrincipal()
        borrarTableroSecundario(gcHold)


        dibujarTableroSecundario(gcHold)
        dibujarTableroSecundario(gcSiguiente1)
        dibujarTableroSecundario(gcSiguiente2)
        dibujarTableroSecundario(gcSiguiente3)

        borrarMascara()
        dibujarTableroPrincipal()

        cPrin.labelModo.text = modo

        cPrin.cronometroLabel.text = tiempo
        cronometro.setTiempo(tiempo)

        cPrin.labelPuntuacion.text = puntuacion.toString()
        cPrin.labelLineas.text = lineas.toString()
        cPrin.labelNivel.text = nivel.toString()

        ControladorPrincipal.tipoPieza = disePiezas

        matrizNumerica = tableroPartida.map { it.toIntArray() }.toTypedArray()

        for (i in 0 until Globales.FILAS) {
            for (j in 0 until Globales.COLUMNAS) {
                pintarCasilla(FONDO,i.toDouble(), j.toDouble())
            }
        }

        for (j in Globales.FILAS downTo 0) {
            pintarMatriz(j, -10)
        }

        siguientePieza.clear()
        siguientePieza.addAll(mapearLetrasAPiezasGuardadas(siguientesPiezas))

        ControladorPrincipal.partidaEnCurso = true

        dibujarPiezasSiguientes(-1)

        listaPiezasSeleccionadas = cargarPosicionesPiezasModos(arraPiezas())


        ControladorPrincipal.holdActivo = holdActivo()
        ControladorPrincipal.puedeHoldear = puedeHoldear()
        ControladorPrincipal.dashActivo = dashActivo()

        if(hayPiezaEnHold()){
            val piezaHold = mapearLetrasAPiezasGuardadas(piezaEnHold)[0]
            pintarPiezaTableroSecun(gcHold, piezaHold)
            ControladorPrincipal.piezaHold.add(piezaHold)
        }


        TIEMPO_CAIDA_PIEZAS_INICIAL = velocidadCaidaActual
        LINEAS_POR_NIVEL = lineasParaSaltoDeNivel
        REDUCCION_TIEMPO_POR_NIVEL = saltoDeTiempoPorNivel
        LIMITE_ROTACIONES_B = hayLimiteDeRotacion()
        if (LIMITE_ROTACIONES_B) {
            LIMITE_ROTACIONES = limiteRotaciones
            rotacionesActuales = numRotacionesDeLaPiezaActual
        }


        siguientesPiezaActivo = siguientesPiezasActivo()

        println(piezaActual)
        ControladorPrincipal.piezaActual = mapearLetrasAPiezasGuardadas(piezaActual)[0]

        ControladorPrincipal.piezaActual.orientacion = rotacionPiezaActual()

        /*
            Para 3x3 todas es -1, -1
            Para 4x4 rotación 0, es -1, -1
            Para O_v6, X_v3 r0 y única es -1, -1

            MiniI para r1 es -1, -1

         */

        var ajusteFila = -1
        var ajusteColumna = -1

        when(this.piezaActual){
            "E", "H_v2", "S_v3", "Z_v3" ->{ // 5x5
                ajusteFila = -2
                ajusteColumna = -2
            }
            "I", "Twin_O", "Twin_Y" -> { // 4x4
                when (rotacionPiezaActual()) {
                    1 -> ajusteColumna = -2
                    2 -> {
                        ajusteFila = -2
                        ajusteColumna = -2
                    }
                    3 -> ajusteFila = -2
                }
            }
            // 2x2
            "Mini_I"->{
                when(rotacionPiezaActual()){
                    0-> ajusteFila = 0
                    2-> ajusteColumna = 0
                    3-> {
                        ajusteFila = 0
                        ajusteColumna = 0
                    }
                }
            }
            "Mini_I_v2", "Mini_L"->{
                when(rotacionPiezaActual()){
                    0-> ajusteColumna = 0
                    1->{
                        ajusteColumna = 0
                        ajusteFila = 0
                    }
                    2-> ajusteFila = 0
                }
            }
            "O", "Mini_O"->{
                ajusteFila = 0
                ajusteColumna = 0
            }
        }

        ControladorPrincipal.piezaActual.fila = filaCentroPiezaActual() + ajusteFila
        ControladorPrincipal.piezaActual.columna = columnaCentroPiezaActual() + ajusteColumna


        //actualizarTimeline()
        cronometro.reanudar()

        ControladorPrincipal.piezaActual.pintar()

        //cambiarLabelsAlSalirDelModoCampa()

    }
}

fun mapearLetrasAPiezasGuardadas(letras: String): ArrayList<Piezas> {
    val columna = Globales.COLUMNAS / 2
    val piezas = ArrayList<Piezas>()

    letras.replace("_", "").split(",").forEach { letra ->
        val index = Listas.LETRAS_PIEZAS.indexOf(letra)
        val pieza = when (index) {
            0 -> Pieza_O(0, columna)
            1 -> Pieza_I(0, columna)
            2 -> Pieza_L(0, columna)
            3 -> Pieza_Z(0, columna)
            4 -> Pieza_J(0, columna)
            5 -> Pieza_S(0, columna)
            6 -> Pieza_T(0, columna)
            7 -> Pieza_P(0, columna)
            8 -> Pieza_X(0, columna)
            9 -> Pieza_U(0, columna)
            10 -> Pieza_L_v2(0, columna)
            11 -> Pieza_W(0, columna)
            12 -> Pieza_T_v2(0, columna)
            13 -> Pieza_Z_v2(0, columna)
            14 -> Pieza_X_v2(0, columna)
            15 -> Pieza_L_v3(0, columna)
            16 -> Pieza_F(0, columna)
            17 -> Pieza_O_v2(0, columna)
            18 -> Pieza_S_v2(0, columna)
            19 -> Pieza_B(0, columna)
            20 -> Pieza_Y(0, columna)
            21 -> Pieza_K(0, columna)
            22 -> Pieza_I_v2(0, columna)
            23 -> Pieza_C(0, columna)
            24 -> Pieza_O_v3(0, columna)
            25 -> Pieza_V(0, columna)
            26 -> Pieza_H(0, columna)
            27 -> Pieza_I_v3(-1, columna - 1)
            28 -> Pieza_Y_v2(0, columna)
            29 -> Pieza_O_v4(0, columna)
            30 -> Pieza_J_v2(0, columna)
            31 -> Pieza_A(0, columna)
            32 -> Pieza_Mini_I(0, columna)
            33 -> Pieza_Mini_I_v2(0, columna)
            34 -> Pieza_Mini_L(0, columna)
            35 -> Pieza_Mini_O(0, columna)
            36 -> Pieza_O_v5(0, columna)
            37 -> Pieza_O_v6(0, columna)
            38 -> Pieza_X_v3(0, columna)
            39 -> Pieza_E(-1, columna - 1)
            40 -> Pieza_Twin_O(0, columna)
            41 -> Pieza_Twin_Y(0, columna)
            42 -> Pieza_Pickaxe(0, columna)
            43 -> Pieza_S_v3(-1, columna - 1)
            44 -> Pieza_Twin_O_v2(0, columna)
            45 -> Pieza_Z_v3(-1, columna - 1)
            46 -> Pieza_Ladder(0, columna)
            47 -> Pieza_H_v2(-1, columna-1)
            else -> null
        }

        if (pieza != null) {
            piezas.add(pieza)
        } else {
            println("Letra no reconocida: $letra")
        }
    }

    return piezas
}
