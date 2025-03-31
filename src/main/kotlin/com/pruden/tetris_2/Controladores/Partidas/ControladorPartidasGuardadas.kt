package com.pruden.tetris_2.Controladores.Partidas

import com.pruden.tetris_2.Controladores.ControladorGEN
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import javafx.stage.Stage

class ControladorPartidasGuardadas: ControladorGEN() {
    @FXML lateinit var nombre1: Label
    @FXML lateinit var nombre2: Label
    @FXML lateinit var nombre3: Label

    @FXML lateinit var cadena1: ImageView
    @FXML lateinit var cadena2: ImageView
    @FXML lateinit var cadena3: ImageView

    @FXML lateinit var imgGuardado1: ImageView
    @FXML lateinit var imgGuardado2: ImageView
    @FXML lateinit var imgGuardado3: ImageView

    companion object{
        lateinit var stagePartidasGuardadas: Stage
    }

    @FXML fun marco1(){

    }
    @FXML fun marco2(){

    }
    @FXML fun marco3(){

    }

    @FXML fun volver(){
        stagePartidasGuardadas.close()
    }

    override fun setStage(stage: Stage?) {
        stagePartidasGuardadas = stage!!
    }

    override fun setBoton(b: Button?) {

    }
}