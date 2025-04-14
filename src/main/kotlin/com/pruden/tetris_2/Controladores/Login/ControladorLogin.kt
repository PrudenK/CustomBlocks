package com.pruden.tetris_2.Controladores.Login

import com.pruden.tetris_2.Metodos.Comprobaciones.Login.iniciarSesionLogin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugarOnline
import com.pruden.tetris_2.Metodos.Eventos.arrastrarFun
import com.pruden.tetris_2.Metodos.Stages.cargarStagePrincipal
import com.pruden.tetris_2.Metodos.Stages.cargarStageRegistrarse
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.Pane
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
    }


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cLogin = this

        userInput.text = "Pruden"
        passInput.text = "1234"

    }

    @FXML fun iniciarSesion(){
        CoroutineScope(Dispatchers.Default).launch {
            iniciarSesionB.isDisable = true
            delay(2000)
            iniciarSesionB.isDisable = false
        }
        iniciarSesionLogin()
    }

    @FXML fun jugarOff(){
        jugarOnline = false
        cargarStagePrincipal()

    }

    @FXML fun registrarse(){
        cargarStageRegistrarse()
        stageLogin.close()
    }

}