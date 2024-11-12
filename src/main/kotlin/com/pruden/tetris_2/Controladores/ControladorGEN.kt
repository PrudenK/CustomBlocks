package com.pruden.tetris_2.Controladores

import javafx.scene.control.Button
import javafx.stage.Stage


abstract class ControladorGEN { // esta clase la necesito para el polimorfismo en crear Stage
    abstract fun setStage(stage: Stage?)
    abstract fun setBoton(b: Button?)
}
