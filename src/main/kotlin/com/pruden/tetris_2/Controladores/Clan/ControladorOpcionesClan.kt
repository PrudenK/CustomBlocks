package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.Controladores.ControladorGEN
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorOpcionesClan : ControladorGEN() {
    lateinit var stageClanOpciones: Stage


    @FXML fun miClan(){

    }

    @FXML fun buscarClan(){

    }

    @FXML fun crearClan(){

    }



    override fun setStage(stage: Stage?) {
        stageClanOpciones = stage!!
    }

    override fun setBoton(b: Button?) {}
}