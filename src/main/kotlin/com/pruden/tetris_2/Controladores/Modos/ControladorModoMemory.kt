package com.pruden.tetris_2.Controladores.Modos

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.tipoTableroPrin
import com.pruden.tetris_2.Controladores.Modos.ControladorModosJuego.Companion.modoMemory
import com.pruden.tetris_2.Metodos.DibujarTablero.cambioDeTablero
import com.pruden.tetris_2.Metodos.Modos.cargarCambiosModo
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorModoMemory : ControladorGEN(){
    private lateinit var stage : Stage
    private lateinit var cPrincipal : ControladorPrincipal

    @FXML
    private fun salir(){
        stage.close()
    }

    @FXML
    private fun guardar(){
        cargarCambiosModo(modoMemory)
        cPrincipal.reiniciarPartida()
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