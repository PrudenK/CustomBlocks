package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
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
        crearStage(ClaseStage("Vistas/Clan/vistaCrearClan.fxml", cPrin.nuevaPartidaB, 466.0, 539.0, null, 0, 0))
    }



    override fun setStage(stage: Stage?) {
        stageClanOpciones = stage!!
    }

    override fun setBoton(b: Button?) {}
}