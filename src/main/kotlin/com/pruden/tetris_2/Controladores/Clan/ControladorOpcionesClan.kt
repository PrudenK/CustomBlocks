package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.Clan.ControladorClan.Companion.idClanControlador
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaPVPenCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarPartida
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.Pane
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class ControladorOpcionesClan : ControladorGEN(), Initializable {
    lateinit var stageClanOpciones: Stage

    @FXML lateinit var pane: Pane
    @FXML lateinit var mensaje: Label

    @FXML lateinit var miClan: Button
    @FXML lateinit var buscarClan: Button
    @FXML lateinit var crearClan: Button
    @FXML lateinit var volver: Button
    @FXML lateinit var chat: Button

    private val scope = CoroutineScope(Dispatchers.Default)

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        if(!partidaPVPenCurso){
            cronometro.parar()
            timelinePartida.stop()
        }
    }

    @FXML fun miClan(){
        if(jugadorConTodo!!.clan != null){
            idClanControlador = jugadorConTodo!!.clan!!.idclan
            crearStage(Stages.MI_CLAN)
        }else{
            mostrarErrorTemporal("No tienes clan todavía")
        }
    }

    @FXML fun buscarClan(){
        crearStage(Stages.BUSCAR_CLAN)
    }

    @FXML fun crearClan(){
        if(jugadorConTodo!!.clan == null){
            crearStage(Stages.CREAR_CLAN)
        }else{
            mostrarErrorTemporal("No puedes crear un clan si ya estás en uno")
        }
    }

    @FXML fun chat(){
        if(jugadorConTodo!!.clan != null){
            crearStage(Stages.CHAT_DEL_CLAN)
        }else{
            mostrarErrorTemporal("No tienes clan todavía")
        }
    }

    @FXML fun volver() {
        reanudarPartida()
        stageClanOpciones.close()
    }


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
            chat.layoutY = 165.0
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
                chat.layoutY = 135.0
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