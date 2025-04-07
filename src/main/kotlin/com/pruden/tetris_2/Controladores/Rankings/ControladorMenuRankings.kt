package com.pruden.tetris_2.Controladores.Rankings

import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorMenuRankings: ControladorGEN() {
    companion object{
        lateinit var stageMenuRankings : Stage
    }

    @FXML fun volver(){
        stageMenuRankings.close()
    }

    @FXML fun partidas(){
        crearStage(Stages.RANKINGS_PARTIDAS)
    }

    @FXML fun jugadores(){

    }




    override fun setStage(stage: Stage?) {
        stageMenuRankings = stage!!
    }

    override fun setBoton(b: Button?) {}
}