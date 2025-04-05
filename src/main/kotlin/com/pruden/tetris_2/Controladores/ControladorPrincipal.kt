package com.pruden.tetris_2.Controladores

import com.pruden.tetris_2.API.Constantes.publicidad.ApiPublicidad
import com.pruden.tetris_2.API.ObjsAux.*
import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Constantes.Logros
import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Metodos.ModosDeJuego.PVP.cambairUIaPVP
import com.pruden.tetris_2.Metodos.Comprobaciones.Login.cerrarSesionApi
import com.pruden.tetris_2.Metodos.ControladorPrincipal.cargarTodoInit
import com.pruden.tetris_2.Metodos.ControladorPrincipal.cerrarSesion
import com.pruden.tetris_2.Metodos.Cronometro.Cronometro
import com.pruden.tetris_2.Metodos.DialogoAccion.mostrarDialogoConAccion
import com.pruden.tetris_2.Metodos.IniciarPartida.*
import com.pruden.tetris_2.Metodos.Logros.completarLogro
import com.pruden.tetris_2.Metodos.Matriz.imprimirMatriz_TAB
import com.pruden.tetris_2.Metodos.Publicidad.abrirBanner
import com.pruden.tetris_2.Metodos.Stages.crearStage
import com.pruden.tetris_2.Metodos.Timelines.cargarTimeLineAuncios
import com.pruden.tetris_2.Metodos.Timelines.indiceActualAnuncio
import com.pruden.tetris_2.Piezas.Piezas
import com.pruden.tetris_2.WebSocket.PartidaEnCurso.PartidaEnCursoEmisor
import javafx.animation.Timeline
import javafx.application.Platform
import javafx.beans.property.BooleanProperty
import javafx.beans.property.IntegerProperty
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.value.ChangeListener
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.stage.Stage
import java.net.URL
import java.util.*
import java.util.concurrent.locks.Lock
import kotlin.system.exitProcess

class ControladorPrincipal : Initializable {
    @FXML lateinit var canvasPrincipal: Canvas
    @FXML lateinit var canvasMascara: Canvas
    @FXML lateinit var canvasSiguientePieza1: Canvas
    @FXML lateinit var canvasSiguientePieza2: Canvas
    @FXML lateinit var canvasSiguientePieza3: Canvas
    @FXML lateinit var canvasHold: Canvas

    @FXML lateinit var idPrincipal : Pane
    @FXML lateinit var paneCuentaRegresiva : Pane
    @FXML lateinit var cuentaRegresivaIMG : ImageView
    @FXML lateinit var labelLineas: Label
    @FXML lateinit var labelPuntuacion: Label
    @FXML lateinit var labelNivel: Label
    @FXML lateinit var labelNivelTit: Label
    @FXML lateinit var cronometroLabel: Label
    @FXML lateinit var labelModo: Label
    @FXML lateinit var mundoNivel: Label


    @FXML lateinit var nuevaPartidaB: Button
    @FXML lateinit var sesionB: Button
    @FXML lateinit var clan: Button
    @FXML lateinit var pvp: Button
    @FXML lateinit var modos: Button
    @FXML lateinit var custom_B: Button



    @FXML lateinit var nivelMarcoNivelTit: Label
    @FXML lateinit var tiempoMarcoNivel: Label
    @FXML lateinit var puntuacionMarcoNivel: Label
    @FXML lateinit var lineasMarcoNivel: Label
    @FXML lateinit var tiempoMarcoNivelRes: Label
    @FXML lateinit var puntuacionMarcoNivelRes: Label
    @FXML lateinit var lineasMarcoNivelRes: Label
    @FXML lateinit var labelModoEstatico: Label

    @FXML lateinit var stackPane : StackPane

    @FXML lateinit var imgPublicidad : ImageView

    @FXML lateinit var paneSinglePlayer: Pane
    @FXML lateinit var panePVP: Pane

    @FXML lateinit var nivelHostNombre: Label
    @FXML lateinit var nivelVisiLabel: Label
    @FXML lateinit var nivelHostLabel: Label
    @FXML lateinit var nivelVisiNombre: Label

    @FXML lateinit var puntuacionHostNombre: Label
    @FXML lateinit var puntuacionVisiLabel: Label
    @FXML lateinit var puntuacionHostLabel: Label
    @FXML lateinit var puntuacionVisiNombre: Label

    @FXML lateinit var lineasHostNombre: Label
    @FXML lateinit var lineasVisiLabel: Label
    @FXML lateinit var lineasHostLabel: Label
    @FXML lateinit var lineasVisiNombre: Label

    @FXML lateinit var mensajeRivalNivel: Label


    companion object {
        const val TAMA_TABLERO_SECUN = 5.0
        const val TAMA_CELDA_SECUN = 30.0
        val FONDO = Color.web("#595959")!!
        var tipoPieza = 4
        var tipoTableroSecun = 1
        var tipoTableroPrin = 1

        var ALTURA_CANVAS_SECUN = 150.0
        var ANCHO_CANVAS_SECUN = 150.0

        var TIEMPO_CAIDA_PIEZAS_INICIAL = 1500
        var LINEAS_POR_NIVEL = 10
        var REDUCCION_TIEMPO_POR_NIVEL = 100
        var LIMITE_ROTACIONES = 999999999
        var LIMITE_ROTACIONES_B = false

        var rotacionesActuales = 0
        var tiempoCaidaPieza = TIEMPO_CAIDA_PIEZAS_INICIAL

        var puedeHoldear = false
        var holdActivo = true
        var dashActivo = false

        var siguientesPiezaActivo = true

        var partidaEnCurso = false

        lateinit var piezaActual : Piezas


        lateinit var gcPrincipal: GraphicsContext
        lateinit var gcMascara: GraphicsContext
        lateinit var gcSiguiente1: GraphicsContext
        lateinit var gcSiguiente2: GraphicsContext
        lateinit var gcSiguiente3: GraphicsContext
        lateinit var gcHold: GraphicsContext


        var cuentaRegresivaHecha = false
        var animacionEnCurso = false



        var matrizNumerica: Array<IntArray> = Array(Globales.FILAS +1) { IntArray(Globales.COLUMNAS) }
        var piezaHold: ArrayList<Piezas> = ArrayList()


        var hasPerdido = false

        lateinit var lockCuentaRegresiva : Lock
        lateinit var cPrin: ControladorPrincipal
        lateinit var timelinePartida : Timeline

        lateinit var cronometro : Cronometro

        val numLineas: IntegerProperty = SimpleIntegerProperty()
        var cerrarStageAltF4 : BooleanProperty = SimpleBooleanProperty(false)

        var stackPaneX = 0.0
        var stackPaneY = 0.0

        var jugarOnline = false

        lateinit var stagePrincipal: Stage

        var idJugador = -1

        var tiempoObj = ""
        var lineasObj = ""
        var objPuntuacionBajar = ""

        var nivelEnJuego = false

        var objFasesNivel = ""

        var nivelTerminado = false
        var nivelCompletado = false

        //logros
        var logroZZZ = false


        var idNivelActual = -1

        var jugadorConTodo: JugadorInicioSesion? = null



        var partidaPVPenCurso = false

        var eresHostPVP = false
        var eresVisitantePVP = false
        var idRivalPVP = -1
        var elRivarHaPerdido = false
        var esperarResolucionPVP = false

        lateinit var listenerNivel: ChangeListener<Number>
        var listenerNivelRegistrado = false
    }


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cPrin = this
        cargarTodoInit()

        cargarTimeLineAuncios()
    }

    @FXML fun opciones() {
        if (!animacionEnCurso) crearStage(Stages.OPCIONES)
    }
    @FXML fun custom() {
        if (!animacionEnCurso) crearStage(Stages.CUSTOM_OPCIONES)
    }

    @FXML fun modosDeJuego() {
        if(!animacionEnCurso) crearStage(Stages.MENU_MODOS_DE_JUEGO)
    }

    @FXML fun sesion(){
        if(partidaPVPenCurso){
            dialogoAbandonarPartidaPVP("Si sales abandonarás la partida") {
                cerrarSesionApi()
                cerrarSesion()
            }
        }else{
            cerrarSesionApi()
            cerrarSesion()
        }
    }

    @FXML fun partdiaNueva() {
        if(nuevaPartidaB.text == "Abandonar partida"){
            dialogoAbandonarPartidaPVP("¿Quieres abandonar la partida?") {
                cambairUIaPVP(false)
                timelinePartida.stop()
                partidaEnCurso =false
                cronometro.parar()
            }
        }else{
            reiniciarPartida()
            if(jugarOnline){
                if(logroZZZ && !jugadorConTodo!!.listaLogros.find { it.idLogro == Logros.ZZZ }!!.completado){
                    completarLogro(Logros.ZZZ)
                }
            }
        }
    }

    @FXML fun borrar() {
        //TIEMPO_CAIDA_PIEZAS_INICIAL = 32411234
        imprimirMatriz_TAB()
        println(ApiPublicidad.anuncios)
        println(tiempoCaidaPieza)
        println(idNivelActual)
    }

    @FXML fun salir() {
        if(partidaPVPenCurso){
            dialogoAbandonarPartidaPVP("Si sales abandonarás la partida") {
                cerrarSesionApi()
                Platform.exit()
                exitProcess(0)
            }
        }else{
            cerrarSesionApi()
            Platform.exit()
            exitProcess(0)
        }
    }

    @FXML fun abrirPublicidad(){
        abrirBanner(ApiPublicidad.anuncios[indiceActualAnuncio].link, ApiPublicidad.anuncios[indiceActualAnuncio].id)
        opciones()
    }

    @FXML fun clan(){
        if(jugarOnline){
            if (!animacionEnCurso) crearStage(Stages.CLAN_MENU)
        }
    }

    private fun dialogoAbandonarPartidaPVP(mensaje: String ,accion: (() -> Unit) ){
        mostrarDialogoConAccion(mensaje,
            onConfirmar = {
                PartidaEnCursoEmisor.mensajeEstandar("rivalAbandona")
                accion.invoke()
            }
        )
    }
}