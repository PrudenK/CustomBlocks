package com.pruden.tetris_2.Controladores.PVP

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
        //crearStage()
    }

    @FXML fun buscarPartida(){

    }



    override fun setStage(stage: Stage?) {
        stageMenuPVP = stage!!
    }


    override fun setBoton(b: Button?) {}
}