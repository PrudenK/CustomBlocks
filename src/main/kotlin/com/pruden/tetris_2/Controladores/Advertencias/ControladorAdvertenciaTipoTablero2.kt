package com.pruden.tetris_2.Controladores.Advertencias

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTipoTablero.Companion.guardarTipoTablero
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorAdvertenciaTipoTablero2: ControladorGEN(), Initializable {
    private lateinit var stage : Stage
    @FXML private lateinit var labelAdvertencia : Label

    companion object{
        var mensajeAdvertenciaTT2 : String = ""
        var haGuardadoAdvertencia = false
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        haGuardadoAdvertencia = false
        labelAdvertencia.text = mensajeAdvertenciaTT2
    }


    @FXML
    private fun cancelar() {
        stage.close()
    }


    @FXML
    private fun guardar() {
        haGuardadoAdvertencia = true
        guardarTipoTablero.set(true)
        stage.close()
    }


    override fun setStage(stage: Stage?) {
        this.stage = stage!!
    }
    override fun setBoton(b: Button?) {}
}