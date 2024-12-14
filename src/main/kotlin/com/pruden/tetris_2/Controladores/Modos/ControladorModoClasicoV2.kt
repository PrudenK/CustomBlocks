package com.pruden.tetris_2.Controladores.Modos

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.Opciones.ControladorModosJuego
import com.pruden.tetris_2.Controladores.Opciones.ControladorModosJuego.Companion.modoClasicoV2
import com.pruden.tetris_2.Metodos.Modos.cargarCambiosModo
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorModoClasicoV2 : ControladorGEN(){
    private lateinit var stage : Stage
    @FXML
    private fun salir(){
        stage.close()
    }

    @FXML
    private fun guardar(){
        cargarCambiosModo(modoClasicoV2)
        cPrin.partdiaNueva()
        stage.close()
        ControladorModosJuego.stageModos.close()
    }

    override fun setStage(stage: Stage?) {
        this.stage = stage!!
    }
    override fun setBoton(b: Button?) {}
}