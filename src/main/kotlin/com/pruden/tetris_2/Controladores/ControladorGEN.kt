package com.pruden.tetris_2.Controladores

import javafx.scene.control.Button
import javafx.stage.Stage


abstract class ControladorGEN {
    abstract fun setStage(stage: Stage?)
    abstract fun setBoton(b: Button?)
}
