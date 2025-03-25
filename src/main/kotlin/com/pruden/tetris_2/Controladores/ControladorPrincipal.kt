package com.pruden.tetris_2.Controladores

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.Constantes.publicidad.ApiPublicidad
import com.pruden.tetris_2.API.ObjsAux.*
import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Constantes.Logros
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas.Companion.listaPiezasSeleccionadas
import com.pruden.tetris_2.Metodos.Comprobaciones.Login.cerrarSesionApi
import com.pruden.tetris_2.Metodos.ControladorPrincipal.cargarTodoInit
import com.pruden.tetris_2.Metodos.ControladorPrincipal.cerrarSesion
import com.pruden.tetris_2.Metodos.Cronometro.Cronometro
import com.pruden.tetris_2.Metodos.IniciarPartida.*
import com.pruden.tetris_2.Metodos.Logros.completarLogro
import com.pruden.tetris_2.Metodos.Matriz.imprimirMatriz_TAB
import com.pruden.tetris_2.Metodos.ModoCampa.PantallaDeCarga.cargaProgressBarCargarNivel
import com.pruden.tetris_2.Metodos.Publicidad.abrirBanner
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.cargarStageNotificacionLogro
import com.pruden.tetris_2.Metodos.Stages.crearStage
import com.pruden.tetris_2.Metodos.Timelines.cargarTimeLineAuncios
import com.pruden.tetris_2.Metodos.Timelines.indiceActualAnuncio
import com.pruden.tetris_2.Piezas.Piezas
import javafx.animation.Timeline
import javafx.application.Platform
import javafx.beans.property.BooleanProperty
import javafx.beans.property.IntegerProperty
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
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


    @FXML lateinit var nivelMarcoNivelTit: Label
    @FXML lateinit var tiempoMarcoNivel: Label
    @FXML lateinit var puntuacionMarcoNivel: Label
    @FXML lateinit var lineasMarcoNivel: Label
    @FXML lateinit var tiempoMarcoNivelRes: Label
    @FXML lateinit var puntuacionMarcoNivelRes: Label
    @FXML lateinit var lineasMarcoNivelRes: Label

    @FXML lateinit var stackPane : StackPane

    @FXML lateinit var imgPublicidad : ImageView

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

        var listaSuscripciones = mutableListOf<Suscripcion>()
        var listaMundos = mutableListOf<Mundo>()
        var listaNiveles = mutableListOf<Nivel>()
        var listaMundosJugador = mutableListOf<MundoJugador>()
        var listaNivelesJugador = mutableListOf<NivelJugador>()
        var listaLogrosJugador = mutableListOf<LogroJugador>()

        var numeroPartidasClasicas = -1
        var numeroLineasAcumuladas = -1
        var puntuacionAcumulada = -1
        var logroZZZ = false

        var idClanDelJugador = -1

        var idNivelActual = -1
    }


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cPrin = this
        cargarTodoInit()

        cargarTimeLineAuncios()
    }

    @FXML fun opciones() {
        if (!animacionEnCurso) crearStage(ClaseStage("Vistas/Otras/vistaOpciones.fxml", nuevaPartidaB,
            300.0, 350.0, timelinePartida, 0, 0))
    }
    @FXML fun custom() {
        if (!animacionEnCurso) crearStage(ClaseStage("Vistas/Custom/vista_Custom_Opciones.fxml", nuevaPartidaB,
            315.0,382.0, timelinePartida, 0, -60))
    }

    @FXML fun modosDeJuego() {
        if (!animacionEnCurso) crearStage(ClaseStage("Vistas/Modos/vista_Modos_Juego.fxml", nuevaPartidaB,
            355.0, 544.0, timelinePartida, 0, 0))
    }

    @FXML fun sesion(){
        cerrarSesionApi()
        cerrarSesion()
    }

    @FXML fun partdiaNueva() {
        reiniciarPartida()
        if(logroZZZ && !listaLogrosJugador.find { it.idLogro == Logros.ZZZ }!!.completado){
            completarLogro(Logros.ZZZ)
        }
    }

    @FXML fun borrar() {
        TIEMPO_CAIDA_PIEZAS_INICIAL = 32411234
        imprimirMatriz_TAB()
        println(ApiPublicidad.anuncios)
        println(listaSuscripciones)
        println(listaMundos)
        println(listaNiveles)
        println(listaMundosJugador)
        println(listaNivelesJugador)
        println(idNivelActual)

        println(tiempoCaidaPieza)


        println(listaLogrosJugador)

        println(numeroPartidasClasicas)
        println(numeroLineasAcumuladas)
        println(puntuacionAcumulada)

        println(listaPiezasSeleccionadas)
        println(idClanDelJugador)

    }

    @FXML fun salir() {
        cerrarSesionApi()
        Platform.exit()
        exitProcess(0)
    }

    @FXML fun abrirPublicidad(){
        abrirBanner(ApiPublicidad.anuncios[indiceActualAnuncio].link, ApiPublicidad.anuncios[indiceActualAnuncio].id)
        opciones()
    }

    @FXML fun campa(){
        if (!animacionEnCurso) crearStage(ClaseStage("Vistas/ModoCampa/vista_Menu_Mundos.fxml", nuevaPartidaB, 711.0, 809.0, timelinePartida, 0, 0))
    }

    @FXML fun suscripciones(){
        if (!animacionEnCurso) crearStage(ClaseStage("Vistas/Suscripciones/vistaSuscripciones.fxml", nuevaPartidaB, 383.0, 416.0, timelinePartida, 0, 0))
    }

    @FXML fun logros(){
        if (!animacionEnCurso) crearStage(ClaseStage("Vistas/Logros/vistaLogros.fxml", nuevaPartidaB, 676.0, 727.0, timelinePartida, 0, 0))
    }

    @FXML fun clan(){
        if (!animacionEnCurso) crearStage(ClaseStage("Vistas/Clan/vistaClanMenu.fxml", nuevaPartidaB, 471.0, 140.0, timelinePartida, 0, -60))
    }
}