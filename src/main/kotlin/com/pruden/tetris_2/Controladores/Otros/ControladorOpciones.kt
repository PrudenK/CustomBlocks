package com.pruden.tetris_2.Controladores.Otros

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.hasPerdido
import com.pruden.tetris_2.Metodos.IniciarPartida.iniciarPartida
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarTimeline
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorOpciones : ControladorGEN(){
    @FXML private lateinit var sonidoo_B: Button
    private var stageOpciones: Stage? = null
    private var cPrincipal: ControladorPrincipal? = null


    @FXML
    private fun salir() {
        Platform.exit()
    }
    @FXML
    private fun sonido() {
        crearStage(ClaseStage("Vistas/Otras/vistaSonido.fxml", sonidoo_B, 315.0, 400.0, null, 0, 0))
    }

    @FXML
    private fun reiniciar() {
        cPrincipal!!.reiniciarPartida()
        stageOpciones!!.close()
    }
    @FXML
    private fun reanudar() {
        if (!hasPerdido) {
            cronometro.reanudar()
            reanudarTimeline()
        }
        stageOpciones!!.close()
    }


    override fun setStage(stage: Stage?) {
        stageOpciones = stage
    }

    override fun setBoton(b: Button?) {
        println()
    }

    override fun setControladorPrincipal(principal: ControladorPrincipal?) {
        cPrincipal = principal
    }
}