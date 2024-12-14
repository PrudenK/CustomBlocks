package com.pruden.tetris_2.Controladores.Advertencias

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.cambioDeTAbleroParaTipoPieza
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.guardarTablero
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorAdvertenciaTablero: ControladorGEN() {

    private lateinit var stage : Stage


    @FXML private fun cancelar() {
        stage.close()
    }


    @FXML private fun guardar() {
        cambioDeTAbleroParaTipoPieza = true
        guardarTablero.set(true)
        stage.close()
    }


    override fun setStage(stage: Stage?) {
        this.stage = stage!!
    }
    override fun setBoton(b: Button?) {}
}