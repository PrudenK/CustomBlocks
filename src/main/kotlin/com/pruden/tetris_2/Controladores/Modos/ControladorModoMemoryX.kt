package com.pruden.tetris_2.Controladores.Modos

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Opciones.ControladorModosJuego
import com.pruden.tetris_2.Controladores.Opciones.ControladorModosJuego.Companion.modoMemoryX
import com.pruden.tetris_2.Metodos.Modos.cargarCambiosModo
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorModoMemoryX : ControladorGEN(){
    private lateinit var stage : Stage
    private lateinit var cPrincipal : ControladorPrincipal

    @FXML
    private fun salir(){
        stage.close()
    }

    @FXML
    private fun guardar(){
        cargarCambiosModo(modoMemoryX)
        cPrincipal.partdiaNueva()
        stage.close()
        ControladorModosJuego.stageModos.close()
    }

    override fun setStage(stage: Stage?) {
        this.stage = stage!!
    }
    override fun setBoton(b: Button?) {}
    override fun setControladorPrincipal(principal: ControladorPrincipal?) {
        cPrincipal = principal!!
    }
}