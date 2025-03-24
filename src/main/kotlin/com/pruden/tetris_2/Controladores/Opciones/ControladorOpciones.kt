package com.pruden.tetris_2.Controladores.Opciones

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.animacionEnCurso
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarPartida
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.stage.Stage
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
        crearStage(ClaseStage("Vistas/Perfil/vista_Perfil.fxml", sonidoo_B, 683.0, 602.0, timelinePartida, 0, 0))
    }

    @FXML fun rankings(){
        crearStage(ClaseStage("Vistas/Rankings/vista_Ranking.fxml", sonidoo_B, 731.0, 600.0, timelinePartida, 0, 0))
    }

    override fun setStage(stage: Stage?) {
        stageOpciones = stage
    }

    override fun setBoton(b: Button?) {
        println()
    }
}