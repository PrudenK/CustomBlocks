package com.pruden.tetris_2.Controladores.ModoCampa

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.PantallaDeCarga.cargaProgressBarCargarNivel
import com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.PantallaDeCarga.cargarLabelsCargaNivel

import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ProgressBar
import javafx.scene.input.KeyEvent
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorCargarNivel: Initializable {
    lateinit var stageCargarNivel: Stage
    @FXML lateinit var progressBar: ProgressBar

    @FXML lateinit var tituloLabel: Label
    @FXML lateinit var caidaInicialLabel: Label
    @FXML lateinit var saltoTiempoLabel: Label
    @FXML lateinit var saltoTiempoLineasLabel: Label
    @FXML lateinit var limiteRotacionesLabel: Label
    @FXML lateinit var holdLabel: Label
    @FXML lateinit var tamaTableroLabel: Label
    @FXML lateinit var siguientesPiezasLabel: Label
    @FXML lateinit var tipoTableroLabel: Label
    @FXML lateinit var dashLabel: Label
    @FXML lateinit var objetivosLabel: Label
    @FXML lateinit var porcentajeCargaLabel: Label

    @FXML lateinit var escLabel: Label
    @FXML lateinit var escB: Button

    var cargaCompleta = false

    companion object{
        lateinit var cCargarNivel : ControladorCargarNivel
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cCargarNivel = this


        escB.isVisible = false
        cargaCompleta = false

        progressBar.progress = 0.0
        cargaProgressBarCargarNivel()

        cargarLabelsCargaNivel()

        Platform.runLater{
            stageCargarNivel.scene.addEventFilter(KeyEvent.KEY_PRESSED) { event ->
                if (event.code == javafx.scene.input.KeyCode.ESCAPE && cargaCompleta) {
                    stageCargarNivel.close()
                    cPrin.partdiaNueva()
                }
            }
        }

    }
}