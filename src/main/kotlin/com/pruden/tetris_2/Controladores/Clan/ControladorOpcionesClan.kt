package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.Controladores.Clan.ControladorMiClan.Companion.idClanControlador
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idClanDelJugador
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.Pane
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ControladorOpcionesClan : ControladorGEN() {
    lateinit var stageClanOpciones: Stage

    @FXML lateinit var pane: Pane
    @FXML lateinit var mensaje: Label

    @FXML lateinit var miClan: Button
    @FXML lateinit var buscarClan: Button
    @FXML lateinit var crearClan: Button
    @FXML lateinit var volver: Button

    private val scope = CoroutineScope(Dispatchers.Default)

    @FXML fun miClan(){
        if(idClanDelJugador != -1){
            idClanControlador = idClanDelJugador
            crearStage(ClaseStage("Vistas/Clan/vistaMiClan.fxml", cPrin.nuevaPartidaB, 553.0, 651.0, null, 0, 0))
        }else{
            mostrarErrorTemporal("No tienes clan todavía")
        }
    }

    @FXML fun buscarClan(){
        crearStage(ClaseStage("Vistas/Clan/vistaBuscarClan.fxml", cPrin.nuevaPartidaB, 534.0, 556.0, null, 0, 0))
    }

    @FXML fun crearClan(){
        if(idClanDelJugador == -1){
            crearStage(ClaseStage("Vistas/Clan/vistaCrearClan.fxml", cPrin.nuevaPartidaB, 466.0, 539.0, null, 0, 0))
        }else{
            mostrarErrorTemporal("No puedes crear un clan si ya estás en uno")
        }
    }

    @FXML fun volver() = stageClanOpciones.close()

    private var animacionEnCurso = false


    private fun mostrarErrorTemporal(texto: String) {
        if (animacionEnCurso) return

        animacionEnCurso = true

        Platform.runLater {
            mensaje.text = texto
            mensaje.isVisible = true
            miClan.layoutY = 115.0
            buscarClan.layoutY = 115.0
            crearClan.layoutY = 115.0
            volver.layoutY = 165.0
            pane.prefHeight = 222.0
            stageClanOpciones.height = 222.0
        }

        scope.launch {
            delay(3000)
            Platform.runLater {
                mensaje.isVisible = false
                miClan.layoutY = 85.0
                buscarClan.layoutY = 85.0
                crearClan.layoutY = 85.0
                volver.layoutY = 135.0
                pane.prefHeight = 192.0
                stageClanOpciones.height = 192.0

                animacionEnCurso = false
            }
        }
    }

    override fun setStage(stage: Stage?) {
        stageClanOpciones = stage!!
    }

    override fun setBoton(b: Button?) {}
}