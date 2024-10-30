package com.pruden.tetris_2.Controladores.Modos

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorModoClasico : ControladorGEN(){
    private lateinit var stage : Stage


    @FXML private fun salir(){
        stage.close()
    }

    @FXML private fun guardar(){
        stage.close()
    }





    override fun setStage(stage: Stage?) {
        this.stage = stage!!
    }

    override fun setBoton(b: Button?) {

    }

    override fun setControladorPrincipal(principal: ControladorPrincipal?) {
    }
}