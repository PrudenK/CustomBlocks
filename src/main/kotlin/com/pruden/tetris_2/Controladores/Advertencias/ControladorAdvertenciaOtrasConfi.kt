package com.pruden.tetris_2.Controladores.Advertencias

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOtrasConfiguraciones.Companion.guardar_valores_otras_confi
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorAdvertenciaOtrasConfi : ControladorGEN() {
    private lateinit var stage: Stage


    @FXML private fun guardar() {
        guardar_valores_otras_confi.set(true)
        stage.close()
    }

    @FXML private fun cancelar() {
        stage.close()
    }


    override fun setStage(stage: Stage?) { this.stage = stage!! }
    override fun setBoton(b: Button?) {}
    override fun setControladorPrincipal(principal: ControladorPrincipal?) {}
}