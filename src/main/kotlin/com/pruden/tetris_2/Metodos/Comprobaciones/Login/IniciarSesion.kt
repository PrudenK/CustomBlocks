package com.pruden.tetris_2.Metodos.Comprobaciones.Login

import com.pruden.tetris_2.API.ObjsAux.LoginRequest
import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.Login.ControladorLogin.Companion.cLogin
import com.pruden.tetris_2.Metodos.CargarDatosDeLaAPI.cargarDatosDelJugador
import com.pruden.tetris_2.Metodos.CargarDatosDeLaAPI.cargarDatosModoCampa
import com.pruden.tetris_2.Metodos.CargarDatosDeLaAPI.cargarSuscripciones
import com.pruden.tetris_2.Metodos.Stages.cargarStagePrincipal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun iniciarSesionLogin(){
    with(cLogin){
        if(userInput.text.isNotBlank() && passInput.text.isNotBlank()){
            CoroutineScope(Dispatchers.IO).launch {
                val respuesta = ApiCustom.jugadorService.iniciarSesion(
                    LoginRequest(userInput.text, passInput.text)
                )

                when(respuesta.code()){
                    200->{
                        idJugador = respuesta.body()!!.get("id")!!.asInt
                        println(idJugador)

                        javafx.application.Platform.runLater {
                            //TODO OOOOOOOOOOOOOOOOO
                            cargarSuscripciones()

                            cargarDatosModoCampa()

                            cargarDatosDelJugador()

                            cargarStagePrincipal()
                            ControladorPrincipal.jugarOnline = true
                        }
                    }
                    404->{
                        javafx.application.Platform.runLater {
                            errorLabel.text = "Usuario no encontrado"
                        }
                    }
                    401->{
                        javafx.application.Platform.runLater {
                            errorLabel.text = "Contraseña incorrecta"
                        }
                    }
                }
            }
        }else{
            errorLabel.text = "Hay campos en blanco"
        }
    }
}