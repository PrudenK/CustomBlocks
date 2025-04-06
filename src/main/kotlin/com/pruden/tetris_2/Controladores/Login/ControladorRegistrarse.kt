package com.pruden.tetris_2.Controladores.Login

import com.pruden.tetris_2.Metodos.Comprobaciones.Registrarse.registrarJugador
import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.Login.ControladorLogin.Companion.stageLogin
import com.pruden.tetris_2.Metodos.Eventos.arrastrarFun
import com.pruden.tetris_2.Metodos.Stages.cargarLogin
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.Pane
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorRegistrarse : Initializable{
    @FXML lateinit var paneLogin: Pane
    @FXML lateinit var passInput: PasswordField
    @FXML lateinit var repetirPassInput: PasswordField
    @FXML lateinit var userInput: TextField
    @FXML lateinit var errorLabel: Label
    @FXML lateinit var comboPais: ComboBox<String>
    lateinit var stageRegistrarse :Stage

    var contraHas = ""
    var registroCorrecto = true

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cRegistrarse = this
        arrastrarFun(paneLogin, stageLogin)

        comboPais.items.addAll(Listas.LISTA_PAISES)

        Platform.runLater {
            stageRegistrarse.setOnCloseRequest {
                cargarLogin(Stage())
            }
        }
    }

    companion object{
        lateinit var cRegistrarse : ControladorRegistrarse
    }

    @FXML fun volver(){
        stageLogin.x = stageRegistrarse.x
        stageLogin.y = stageRegistrarse.y

        stageRegistrarse.close()

        cargarLogin(Stage())

    }

    @FXML fun registrarse(){
        registrarJugador()
    }
}