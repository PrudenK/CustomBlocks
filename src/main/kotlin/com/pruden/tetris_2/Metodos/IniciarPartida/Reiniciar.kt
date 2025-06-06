package com.pruden.tetris_2.Metodos.IniciarPartida

import com.pruden.tetris_2.Metodos.SubirDatos.contadorPiezas
import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugarOnline
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero
import com.pruden.tetris_2.Controladores.Opciones.ControladorCustomOpciones
import com.pruden.tetris_2.Metodos.BorrarPiezas.reiniciarLineasBorradas
import com.pruden.tetris_2.Metodos.DibujarTablero.General.borrarTableroSecundario
import com.pruden.tetris_2.Metodos.DibujarTablero.cambioDeTablero
import com.pruden.tetris_2.Metodos.Matriz.borrarCasillas
import com.pruden.tetris_2.Metodos.Observables.cambiosTipoTablero
import javafx.application.Platform
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun reiniciarPartida(){
    if (!ControladorPrincipal.animacionEnCurso) {
        ControladorPrincipal.hasPerdido = false
        reiniciarLineasBorradas()
        ControladorPrincipal.tiempoCaidaPieza = ControladorPrincipal.TIEMPO_CAIDA_PIEZAS_INICIAL

        CoroutineScope(Dispatchers.Default).launch {
            delay(250)
            Platform.runLater {
                borrarTableroSecundario(ControladorPrincipal.gcSiguiente1)
                borrarTableroSecundario(ControladorPrincipal.gcSiguiente2)
                borrarTableroSecundario(ControladorPrincipal.gcSiguiente3)
                borrarTableroSecundario(ControladorPrincipal.gcHold)
            }
        }

        ControladorPrincipal.cronometro.parar()
        ControladorPrincipal.cronometro.seTCronometroA0()

        cuentaAtras()

        Platform.runLater {
            borrarCasillas()
            reiniciarLabels()

            if (ControladorCustomOpciones.cambioTablero){
                cambioDeTablero()
                ControladorCustomOpciones.cambioTablero = false
            }

            if(ControladorCustomOpciones.cambioTipoTablero){
                cambiosTipoTablero()
                ControladorCustomOpciones.cambioTipoTablero = false
            }

            ControladorCustomTablero.cambioDeTAbleroParaTipoPieza = false
        }


        if (jugarOnline) contadorPiezas = MutableList(Listas.NOMBRES_PIEZAS.size) { 0 }



        Thread { iniciarPartida() }.start()
    }
}