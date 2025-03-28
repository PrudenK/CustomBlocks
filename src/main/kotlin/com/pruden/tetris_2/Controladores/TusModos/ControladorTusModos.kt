package com.pruden.tetris_2.Controladores.TusModos

import com.pruden.tetris_2.Controladores.ControladorGEN
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorTusModos: ControladorGEN(), Initializable {
    lateinit var stageTusModos: Stage


    @FXML lateinit var textoModos: javafx.scene.text.Text

    override fun initialize(p0: URL?, p1: ResourceBundle?) {

    }


    @FXML fun jugar(){

    }

    @FXML fun atras(){

    }

    @FXML fun siguiente(){

    }

    @FXML fun volver() = stageTusModos.close()


    override fun setStage(stage: Stage?) {
        stageTusModos = stage!!
    }

    override fun setBoton(b: Button?) {
    }
}