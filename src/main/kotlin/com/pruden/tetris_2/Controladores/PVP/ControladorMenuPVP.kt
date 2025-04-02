package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorMenuPVP: ControladorGEN() {

    companion object{
        lateinit var stageMenuPVP: Stage
    }


    @FXML fun crearPartida(){
        crearStage(Stages.CREAR_PARTIDA_PVP)
    }

    @FXML fun buscarPartida(){
        crearStage(Stages.BUSCAR_PARTIDA_PVP)
    }

    @FXML fun volver() = stageMenuPVP.close()

    override fun setStage(stage: Stage?) {
        stageMenuPVP = stage!!
    }


    override fun setBoton(b: Button?) {}
}