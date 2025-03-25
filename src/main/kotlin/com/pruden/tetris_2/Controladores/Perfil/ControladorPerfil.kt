package com.pruden.tetris_2.Controladores.Perfil

import com.pruden.tetris_2.Metodos.CargarDatosDeLaAPI.CargarDatosPerfil.*
import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import com.pruden.tetris_2.Metodos.SubirDatos.subirImagenPerfilADB
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorPerfil : ControladorGEN(), Initializable {
    private lateinit var stagePerfil: Stage

    @FXML lateinit var usuarioLabel: Label
    @FXML lateinit var fechaIniLabel: Label
    @FXML lateinit var nivelLabel: Label
    @FXML lateinit var rankingLabel: Label
    @FXML lateinit var paisLabel: Label
    @FXML lateinit var puntosTotalesLabel: Label
    @FXML lateinit var lineasTotalesLabel: Label
    @FXML lateinit var partidasTotalesLabel: Label
    @FXML lateinit var tiempoTotalLabel: Label
    @FXML lateinit var maxNivelModoLabel: Label
    @FXML lateinit var maxLineasModoLabel: Label
    @FXML lateinit var maxPuntuModoLabel: Label
    @FXML lateinit var maxTiempoModoLabel: Label
    @FXML lateinit var lineasSumModoLabel: Label
    @FXML lateinit var puntosSumModoLabel: Label
    @FXML lateinit var tiempoSumModoLabel: Label
    @FXML lateinit var partidasJugadasModos: Label

    @FXML lateinit var puntosCustomLabel: Label
    @FXML lateinit var lineasCustomLabel: Label
    @FXML lateinit var partidasCustomLabel: Label
    @FXML lateinit var tiempoCustomLabel: Label

    @FXML lateinit var comboBox: ComboBox<String>

    @FXML lateinit var verPiezasB: Button
    @FXML lateinit var imagenPerfil: ImageView
    @FXML lateinit var editarPerfil: ImageView

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cPerfil = this

        comboBox.items.addAll(Listas.LISTA_MODOS_DE_JUEGOS)
        comboBox.value = Listas.LISTA_MODOS_DE_JUEGOS[0]

        cargarDatosUsuarioPerfil()
        cargarDatosPartidas("Custom")
        cargarDatosPartidas("Todos")
        cargarDatosPartidas()

        comboBox.valueProperty().addListener { _, _, _ ->
            cargarDatosPartidas()
        }

        editarPerfil.setOnMouseClicked {
            subirImagenPerfilADB()
        }
    }

    companion object{
        lateinit var cPerfil : ControladorPerfil
    }

    @FXML fun verPiezas(){
        crearStage(ClaseStage("Vistas/Perfil/vista_Perfil_Piezas.fxml",cPrin.nuevaPartidaB,700.0,820.0, null,0, 0))
    }

    @FXML fun volver() = stagePerfil.close()

    @FXML fun registroPartidas(){
        crearStage(ClaseStage("Vistas/Partidas/vista_Partidas.fxml", cPrin.nuevaPartidaB, 699.0, 634.0, timelinePartida, 0, 0))
    }

    override fun setStage(stage: Stage?) {
        stagePerfil = stage!!
    }
    override fun setBoton(b: Button?) {}
}