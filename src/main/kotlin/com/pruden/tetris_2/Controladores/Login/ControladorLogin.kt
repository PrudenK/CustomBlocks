package com.pruden.tetris_2.Controladores.Login

import com.pruden.tetris_2.BaseDeDatos.getConexion
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugarOnline
import com.pruden.tetris_2.Metodos.Eventos.arrastrarFun
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.cargarStagePrincipal
import com.pruden.tetris_2.Metodos.Stages.cargarStageRegistrarse
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.Pane
import javafx.stage.Stage
import java.net.URL
import java.sql.Connection
import java.sql.Statement
import java.util.*

class ControladorLogin : Initializable{
    @FXML lateinit var paneLogin: Pane
    @FXML lateinit var passInput: PasswordField
    @FXML lateinit var userInput: TextField
    @FXML lateinit var errorLabel: Label
    @FXML lateinit var iniciarSesionB: Button

    companion object{
        lateinit var cLogin : ControladorLogin

        lateinit var stageLogin: Stage

        lateinit var conexion : Connection
        lateinit var statment : Statement
    }


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cLogin = this

        arrastrarFun(paneLogin)


    }

    @FXML fun iniciarSesion(){

        conexion = getConexion()




        cargarStagePrincipal()


        jugarOnline = true
    }

    @FXML fun jugarOff(){
        cargarStagePrincipal()


        jugarOnline = false
    }

    @FXML fun registrarse(){
        conexion = getConexion()

        cargarStageRegistrarse(iniciarSesionB)
    }



}