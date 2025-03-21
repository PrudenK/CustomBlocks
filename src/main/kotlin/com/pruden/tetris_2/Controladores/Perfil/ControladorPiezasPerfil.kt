package com.pruden.tetris_2.Controladores.Perfil

import com.pruden.tetris_2.Metodos.CargarDatosPerfil.cargarDatosPiezasPerfil
import com.pruden.tetris_2.Controladores.ControladorGEN
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorPiezasPerfil : ControladorGEN(), Initializable {
    lateinit var stagePiezasPerfil : Stage


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cPiezasPerfil = this
        cargarDatosPiezasPerfil()
    }


    companion object{
        lateinit var cPiezasPerfil : ControladorPiezasPerfil
    }


    @FXML fun volver(){
        stagePiezasPerfil.close()
    }


    override fun setStage(stage: Stage?) {
        stagePiezasPerfil = stage!!
    }

    override fun setBoton(b: Button?) {}
}