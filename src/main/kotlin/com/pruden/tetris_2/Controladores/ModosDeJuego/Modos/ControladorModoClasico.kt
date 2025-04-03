package com.pruden.tetris_2.Controladores.ModosDeJuego.Modos

import com.pruden.tetris_2.Constantes.ModosDeJuego
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ModosDeJuego.ControladorMenuModos
import com.pruden.tetris_2.Controladores.ModosDeJuego.Modos.ControladorModosJuego.Companion.stageModos
import com.pruden.tetris_2.Metodos.ModosDeJuego.Modos.cargarCambiosModo
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorModoClasico : ControladorGEN(){
    private lateinit var stage : Stage
    @FXML private fun salir(){
        stage.close()
    }

    @FXML private fun guardar(){
        cargarCambiosModo(ModosDeJuego.CLASICO)
        cPrin.partdiaNueva()
        stage.close()
        stageModos.close()
        ControladorMenuModos.cMenuModos.stageMenuMundos.close()
    }

    override fun setStage(stage: Stage?) {
        this.stage = stage!!
    }
    override fun setBoton(b: Button?) {}
}