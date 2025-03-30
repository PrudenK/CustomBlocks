package com.pruden.tetris_2.Controladores.ModosDeJuego

import com.pruden.tetris_2.Controladores.ControladorGEN
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorMenuModos: ControladorGEN() {
    lateinit var stageMenuMundos : Stage







    override fun setStage(stage: Stage?) {
        stageMenuMundos = stage!!
    }

    override fun setBoton(b: Button?) {}
}