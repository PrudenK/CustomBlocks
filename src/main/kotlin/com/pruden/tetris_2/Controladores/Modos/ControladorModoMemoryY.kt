package com.pruden.tetris_2.Controladores.Modos

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.Opciones.ControladorModosJuego
import com.pruden.tetris_2.Controladores.Opciones.ControladorModosJuego.Companion.modoMemoryY
import com.pruden.tetris_2.Metodos.Modos.cargarCambiosModo
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorModoMemoryY : ControladorGEN(){
    private lateinit var stage : Stage

    @FXML
    private fun salir(){
        stage.close()
    }

    @FXML
    private fun guardar(){
        cargarCambiosModo(modoMemoryY)
        cPrin.partdiaNueva()
        stage.close()
        ControladorModosJuego.stageModos.close()
    }

    override fun setStage(stage: Stage?) {
        this.stage = stage!!
    }
    override fun setBoton(b: Button?) {}
}