package com.pruden.tetris_2.Controladores

import com.pruden.tetris_2.Metodos.Media.Audio.musicaPartida
import com.pruden.tetris_2.Metodos.BorrarPiezas.initLabelsBorrarLineas
import com.pruden.tetris_2.Metodos.BorrarPiezas.reiniciarLineasBorradas
import com.pruden.tetris_2.Metodos.Cronometro.Cronometro
import com.pruden.tetris_2.Metodos.DibujarTablero.General.borrarTableroSecundario
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroPrincipal
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroSecundario
import com.pruden.tetris_2.Metodos.DibujarTablero.General.pintarPiezaTableroSecun
import com.pruden.tetris_2.Metodos.Eventos.arrastrarFun
import com.pruden.tetris_2.Metodos.IniciarPartida.*
import com.pruden.tetris_2.Metodos.Matriz.borrarCasillas
import com.pruden.tetris_2.Metodos.Matriz.imprimirMatriz_TAB
import com.pruden.tetris_2.Metodos.Matriz.rellenarMatriz
import com.pruden.tetris_2.Metodos.Observables.cargarObervableCerrarStageAltF4
import com.pruden.tetris_2.Metodos.Observables.cargarObervableNivel
import com.pruden.tetris_2.Metodos.Observables.initLabelsObervableNivel
import com.pruden.tetris_2.Metodos.Perder.initBotonPartida
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import com.pruden.tetris_2.Metodos.Teclado.initLabelsMoverPiezas
import com.pruden.tetris_2.Metodos.Teclado.moverPiezas
import com.pruden.tetris_2.Piezas.Piezas
import javafx.animation.Timeline
import javafx.application.Platform
import javafx.beans.property.BooleanProperty
import javafx.beans.property.IntegerProperty
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import javafx.scene.input.KeyEvent
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import java.net.URL
import java.util.*
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class ControladorPrincipal : Initializable {
    @FXML lateinit var canvasPrincipal: Canvas
    @FXML lateinit var canvasSiguientePieza1: Canvas
    @FXML lateinit var canvasSiguientePieza2: Canvas
    @FXML lateinit var canvasSiguientePieza3: Canvas
    @FXML lateinit var canvasHold: Canvas


    @FXML private lateinit var idPrincipal : Pane
    @FXML private lateinit var cuentaRegresivaIMG : ImageView
    @FXML lateinit var labelLineas: Label
    @FXML lateinit var labelPuntuacion: Label
    @FXML lateinit var labelNivel: Label
    @FXML private lateinit var cronometroLabel: Label
    @FXML private lateinit var nuevaPartidaB: Button

    @FXML private lateinit var stackPane : StackPane


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        timelinePartida = Timeline()

        musicaPartida(javaClass.getResource("/Musica/Canciones/saturada.mp3")!!.toExternalForm())

        cargarLabels()
        cargarGc()

        arrastrarFun(idPrincipal)

        cargarTableros()

        rellenarMatriz()

        canvasPrincipal.clip = Rectangle(0.0, (2 * TAMANO_CELDA).toDouble(), canvasPrincipal.width, canvasPrincipal.height - 2 * TAMANO_CELDA)

        lockCuentaRegresiva = ReentrantLock()

        cronometro = Cronometro(controladorPrincipal)

        cargarObervableCerrarStageAltF4()
        cargarObervableNivel()

        stackPaneX = stackPane.layoutX
        stackPaneY = stackPane.layoutY

        setStackpane18x10()


    }

    init { controladorPrincipal = this }

    fun iniciarCronometroLabel() : Label{
        return cronometroLabel
    }


    companion object {
        var FILAS = 20
        var COLUMNAS = 10
        var TAMANO_CELDA =33
        var BLANCO = 0
        var CENTRO_BLANCO = 80
        var BORDE_TABLERO = 9
        const val TAMA_TABLERO_SECUN = 5.0
        const val TAMA_CELDA_SECUN = 30.0
        val FONDO = Color.web("#595959")

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


        var siguientesPiezaActivo = true

        var partidaEnCurso = false

        lateinit var piezaActual : Piezas
        lateinit var gcPrincipal: GraphicsContext
        lateinit var gcSiguiente1: GraphicsContext
        lateinit var gcSiguiente2: GraphicsContext
        lateinit var gcSiguiente3: GraphicsContext
        lateinit var gcHold: GraphicsContext


        var cuentaRegresivaHecha = false
        var animacionEnCurso = false



        var matrizNumerica: Array<IntArray> = Array(FILAS+1) { IntArray(COLUMNAS) }
        var piezaHold: ArrayList<Piezas> = ArrayList()


        var hasPerdido = false

        lateinit var lockCuentaRegresiva : Lock
        lateinit var controladorPrincipal: ControladorPrincipal
        lateinit var timelinePartida : Timeline

        lateinit var cronometro : Cronometro

        val numLineas: IntegerProperty = SimpleIntegerProperty()
        var cerrarStageAltF4 : BooleanProperty = SimpleBooleanProperty(false)

        var stackPaneX = 0.0
        var stackPaneY = 0.0
    }












    fun pasarEscena(scene: Scene) {
        scene.addEventFilter(KeyEvent.KEY_PRESSED) {event -> moverPiezas(event)}
    }




    @FXML
    private fun opciones() {
        cronometro.parar()
        if (!animacionEnCurso) crearStage(ClaseStage("Vistas/Otras/vistaOpciones.fxml", nuevaPartidaB, 315.0, 400.0,timelinePartida, 0, -60))
    }
    @FXML
    private fun custom() {
        cronometro.parar()
        if (!animacionEnCurso) crearStage(ClaseStage("Vistas/Custom/vista_Custom_Opciones.fxml", nuevaPartidaB,315.0,400.0, timelinePartida, 0, -60))
    }

    @FXML
    private fun modosDeJuego() {
        cronometro.parar()
        if (!animacionEnCurso) crearStage(ClaseStage("Vistas/Modos/vista_Modos_Juego.fxml", nuevaPartidaB, 315.0, 400.0,timelinePartida, 0, -60))
    }

    @FXML
    private fun partdiaNueva() {
        reiniciarPartida()
    }

    @FXML
    private fun borrar() {
        pintarPiezaTableroSecun(gcSiguiente1, piezaActual)
        imprimirMatriz_TAB()
    }

    @FXML
    private fun salir() {
        Platform.exit()
    }


    fun reiniciarPartida(){
        if (!animacionEnCurso) {
            reiniciarLineasBorradas()
            tiempoCaidaPieza = TIEMPO_CAIDA_PIEZAS_INICIAL

            borrarTableroSecundario(gcSiguiente1)
            borrarTableroSecundario(gcSiguiente2)
            borrarTableroSecundario(gcSiguiente3)
            borrarTableroSecundario(gcHold)

            cronometro.parar()
            cronometro.seTCronometroA0()

            cuentaAtras(cuentaRegresivaIMG)

            borrarCasillas()
            reiniciarLabels()


            Thread { iniciarPartida() }.start()
        }
    }

    fun cargarTablero(){
        gcPrincipal.clearRect(0.0,0.0, canvasPrincipal.width, canvasPrincipal.height)
        canvasPrincipal.clip = Rectangle(0.0, (2 * TAMANO_CELDA).toDouble(), canvasPrincipal.width, canvasPrincipal.height - 2 * TAMANO_CELDA)
    }



    private fun cargarLabels(){
        initLabelsBorrarLineas(labelPuntuacion, labelLineas)
        initLabelsMoverPiezas(labelPuntuacion)
        initLabels(labelPuntuacion, labelLineas)
        initLabelsConfiguraciones(labelPuntuacion, labelLineas, labelNivel)
        initBotonPartida(nuevaPartidaB)
        cargarComponentesStackPane(stackPane, cuentaRegresivaIMG)
        initLabelsObervableNivel(labelLineas,labelNivel)
    }

    private fun cargarGc(){
        gcPrincipal = canvasPrincipal.graphicsContext2D
        gcSiguiente1 = canvasSiguientePieza1.graphicsContext2D
        gcSiguiente2 = canvasSiguientePieza2.graphicsContext2D
        gcSiguiente3 = canvasSiguientePieza3.graphicsContext2D
        gcHold = canvasHold.graphicsContext2D
    }

    private fun cargarTableros(){
        dibujarTableroPrincipal()
        dibujarTableroSecundario(gcSiguiente1)
        dibujarTableroSecundario(gcSiguiente2)
        dibujarTableroSecundario(gcSiguiente3)
        dibujarTableroSecundario(gcHold)
    }
}