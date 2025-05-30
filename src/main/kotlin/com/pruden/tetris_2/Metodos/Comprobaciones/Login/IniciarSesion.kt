package com.pruden.tetris_2.Metodos.Comprobaciones.Login

import com.pruden.tetris_2.API.ObjsAuxApi.LoginRequest
import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.Login.ControladorLogin.Companion.cLogin
import com.pruden.tetris_2.Metodos.Comprobaciones.hashearContraConSAl
import com.pruden.tetris_2.Metodos.Stages.cargarStagePrincipal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun iniciarSesionLogin(){
    with(cLogin){
        if(userInput.text.isNotBlank() && passInput.text.isNotBlank()){
            CoroutineScope(Dispatchers.IO).launch {
                val saltResponse = ApiCustom.jugadorService.getSaltDelUsuario(userInput.text)
                if(saltResponse.isSuccessful){

                    val respuesta = ApiCustom.jugadorService.iniciarSesion(
                        LoginRequest(userInput.text, hashearContraConSAl(passInput.text, saltResponse.body()!!))
                    )

                    println(respuesta)

                    when(respuesta.code()){
                        200->{
                            idJugador = respuesta.body()!!.get("id")!!.asInt
                            println(idJugador)

                            jugadorConTodo = ApiCustom.jugadorService.getDatosIniciarSesion(idJugador)

                            ControladorPrincipal.jugarOnline = true
                            javafx.application.Platform.runLater {
                                iniciarHeartbeatJugador()
                                cargarStagePrincipal()
                            }
                        }
                        401->{
                            javafx.application.Platform.runLater {
                                errorLabel.text = "Contraseña incorrecta"
                            }
                        }
                        409->{
                            javafx.application.Platform.runLater {
                                errorLabel.text = "Esa cuenta está online"
                            }
                        }
                    }
                }else{
                    javafx.application.Platform.runLater {
                        errorLabel.text = "Usuario no encontrado"
                    }
                }
            }
        }else{
            errorLabel.text = "Hay campos en blanco"
        }
    }
}

fun iniciarHeartbeatJugador() {
    CoroutineScope(Dispatchers.IO).launch {
        while (idJugador != -1) {
            try {
                ApiCustom.jugadorService.ping(idJugador)
                println("Ping enviado")
            } catch (e: Exception) {
                println("Ping fallido: ${e.message}")
            }

            delay(10_000)
        }

        println("Heartbeat detenido: sesión cerrada o no iniciada")
    }
}
