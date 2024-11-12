package com.pruden.tetris_2.Controladores.ModoCampa

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaEnCurso
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarPartida
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import com.pruden.tetris_2.Metodos.Timelines.reanudarTimeline
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorModoCampa : ControladorGEN(), Initializable {
    lateinit var stageModoCampa : Stage

    @FXML lateinit var completadosMundo1 : Label
    @FXML lateinit var volverB : Button

    companion object{
        lateinit var cModoCampa: ControladorModoCampa
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cronometro.parar()
        cModoCampa = this
    }

    @FXML fun abrirMundo1(){
        crearStage(ClaseStage("Vistas/ModoCampa/vista_Mundo1.fxml", volverB, 600.0, 797.0, null, 0, 0))
    }




    @FXML fun volver(){
        reanudarPartida()
        stageModoCampa.close()
    }


    override fun setStage(stage: Stage?) {
        stageModoCampa = stage!!
    }
    override fun setBoton(b: Button?) {

    }
}