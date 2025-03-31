package com.pruden.tetris_2.Controladores.Opciones

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.ObjsAux.PartidaGuardada
import com.pruden.tetris_2.Constantes.Globales.FILAS
import com.pruden.tetris_2.Constantes.Listas.LISTA_VALORES_FILAS_TABLERO
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LINEAS_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.REDUCCION_TIEMPO_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.animacionEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.dashActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.holdActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaActual
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaHold
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.rotacionesActuales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.siguientesPiezaActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tiempoCaidaPieza
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoPieza
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroSecun
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOtrasConfiguraciones.Companion.limiteRotaciones
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas.Companion.listaPiezasSeleccionadas
import com.pruden.tetris_2.Metodos.BolsaPiezas.siguientePieza
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarPartida
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class ControladorOpciones : ControladorGEN(), Initializable{
    @FXML private lateinit var sonidoo_B: Button
    private var stageOpciones: Stage? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        //arrastrarFun(sonidoo_B, stagePrincipal)
        cronometro.parar()
    }
    @FXML fun volver() {
        reanudarPartida()
        stageOpciones!!.close()
    }
    @FXML fun sonido() {
        crearStage(ClaseStage("Vistas/Otras/vistaSonido.fxml", sonidoo_B, 243.0, 264.0, null, 0, 0))
    }

    @FXML fun reiniciar() {
        cPrin.partdiaNueva()
        stageOpciones!!.close()
    }
    @FXML fun reanudar() {
        reanudarPartida()
        stageOpciones!!.close()
    }

    @FXML fun perfil(){
        crearStage(ClaseStage("Vistas/Perfil/vista_Perfil.fxml", cPrin.nuevaPartidaB, 683.0, 602.0, timelinePartida, 0, 0))
    }

    @FXML fun rankings(){
        crearStage(ClaseStage("Vistas/Rankings/vista_Ranking.fxml", cPrin.nuevaPartidaB, 731.0, 600.0, timelinePartida, 0, 0))
    }

    @FXML fun guardar(){
        // val matriz = partidaGuardada.tableroPartida.map { it.toIntArray() }.toTypedArray()

        var piezaHoldS = ""
        if(piezaHold.size == 1){
            piezaHoldS = piezaHold[0].javaClass.toString().replace("class com.pruden.tetris_2.Piezas.Pieza_", "")
        }

        val partida = PartidaGuardada(
            idJugador = jugadorConTodo!!.id,
            numPartidaGuardada = 0,
            modo = cPrin.labelModo.text.toString(),
            tiempo = cPrin.cronometroLabel.text.toString(),
            puntuacion = cPrin.labelPuntuacion.text.toInt(),
            lineas = cPrin.labelLineas.text.toInt(),
            nivel = cPrin.labelNivel.text.toInt(),
            tableroPartida = matrizNumerica.map { it.toList() },
            tamaTablero = LISTA_VALORES_FILAS_TABLERO.indexOf(FILAS),
            diseTablero = tipoTableroPrin,
            diseTableroSecun = tipoTableroSecun,
            siguientesPiezasActivo = if (siguientesPiezaActivo) 1 else 0,
            siguientesPiezas = siguientePieza.map { it.javaClass.toString()
                .replace("class com.pruden.tetris_2.Piezas.Pieza_", "") }
                .toString().replace("[", "").replace("]", "")
                .replace(" ",""),
            arrayPiezas = codificarPiezasSeleccionadas(listaPiezasSeleccionadas),
            disePiezas = tipoPieza,
            holdActivo = if (holdActivo) 1 else 0,
            dashActivo = if (dashActivo) 1 else 0,
            piezaEnHold = piezaHoldS,
            velocidadCaidaActual = tiempoCaidaPieza,
            lineasParaSaltoDeNivel = LINEAS_POR_NIVEL,
            saltoDeTiempoPorNivel = REDUCCION_TIEMPO_POR_NIVEL,
            limiteRotaciones = if(LIMITE_ROTACIONES == 999999999) -1 else LIMITE_ROTACIONES,
            piezaActual = piezaActual.javaClass.toString().replace("class com.pruden.tetris_2.Piezas.Pieza_", ""),
            posicionPiezaActual = "${piezaActual.getFilaCentro()}_${piezaActual.getColumnaCentro()}_${piezaActual.orientacion}",
            numRotacionesDeLaPiezaActual = rotacionesActuales
        )



        CoroutineScope(Dispatchers.IO).launch {
            val response = ApiCustom.partidaGuardadaService.guardarPartida(partida)

            println(response)
        }




    }

    fun codificarPiezasSeleccionadas(lista: List<Boolean>): String {
        val resultado = lista.mapIndexedNotNull { index, seleccionada ->
            if (seleccionada) index else null
        }.joinToString("_")
        return if(resultado == "") "0_1_2_3_4_5_6" else resultado
    }

    override fun setStage(stage: Stage?) {
        stageOpciones = stage
    }

    override fun setBoton(b: Button?) {
        println()
    }
}