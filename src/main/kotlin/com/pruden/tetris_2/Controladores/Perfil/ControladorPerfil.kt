package com.pruden.tetris_2.Controladores.Perfil

import com.pruden.tetris_2.BaseDeDatos.CargarDatosPerfil.*
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.Login.ControladorLogin.Companion.statment
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarPartida
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorPerfil : ControladorGEN(), Initializable {
    private lateinit var stagePerfil: Stage

    @FXML lateinit var usuarioLabel: Label
    @FXML lateinit var fechaIniLabel: Label
    @FXML lateinit var nivelLabel: Label
    @FXML lateinit var experienciaLabel: Label
    @FXML lateinit var rankingLabel: Label
    @FXML lateinit var paisLabel: Label
    @FXML lateinit var puntosTotalesLabel: Label
    @FXML lateinit var lineasTotalesLabel: Label
    @FXML lateinit var partidasTotalesLabel: Label
    @FXML lateinit var tiempoTotalLabel: Label
    @FXML lateinit var totalPiezas: Label
    @FXML lateinit var maxNivelModoLabel: Label
    @FXML lateinit var maxLineasModoLabel: Label
    @FXML lateinit var maxPuntuModoLabel: Label
    @FXML lateinit var maxTiempoModoLabel: Label
    @FXML lateinit var lineasSumModoLabel: Label
    @FXML lateinit var puntosSumModoLabel: Label
    @FXML lateinit var tiempoSumModoLabel: Label

    @FXML lateinit var puntosCustomLabel: Label
    @FXML lateinit var lineasCustomLabel: Label
    @FXML lateinit var partidasCustomLabel: Label
    @FXML lateinit var tiempoCustomLabel: Label
    @FXML lateinit var customPiezasLabel: Label

    @FXML lateinit var comboBox: ComboBox<String>

    @FXML lateinit var verPiezasB: Button

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cPerfil = this

        cronometro.parar()

        comboBox.items.addAll(listaModos)
        comboBox.value = listaModos[0]

        cargarDatosUsuarioPerfil()
        cargarDatosModos()
        cargarDatosEstaTotales()
        cargarDatosCustom()

        comboBox.valueProperty().addListener { _, _, _ ->
            cargarDatosModos()
        }
    }

    companion object{
        lateinit var cPerfil : ControladorPerfil
    }

    @FXML fun verPiezas(){
        crearStage(ClaseStage("Vistas/Perfil/vista_Perfil_Piezas.fxml",verPiezasB,700.0,820.0, null,0, 0))
    }

    @FXML fun volver(){
        reanudarPartida()
        stagePerfil.close()
    }

    override fun setStage(stage: Stage?) {
        stagePerfil = stage!!
    }
    override fun setBoton(b: Button?) {}
}