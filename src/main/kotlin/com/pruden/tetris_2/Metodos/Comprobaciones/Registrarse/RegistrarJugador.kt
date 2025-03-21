package com.pruden.tetris_2.Metodos.Comprobaciones.Registrarse

import com.pruden.tetris_2.API.ObjsAux.Jugador
import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.Login.ControladorRegistrarse.Companion.cRegistrarse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun registrarJugador(){
    with(cRegistrarse){
        comprobacionesRegistrar()

        if(registroCorrecto){
            CoroutineScope(Dispatchers.IO).launch {
                val jugador = Jugador(
                    nombre = userInput.text,
                    contrasena = contraHas,
                    pais = comboPais.value
                )

                val respuesta = ApiCustom.jugadorService.crearJugador(jugador)

                when(respuesta.code()){
                    201 -> {
                        javafx.application.Platform.runLater {
                            reiniciarCampos()
                            errorLabel.text = "El registro ha sido correcto"
                        }
                    }
                    409 ->{
                        javafx.application.Platform.runLater {
                            errorLabel.text = "El nombre está repetido"
                        }
                    }
                }
            }
        }
    }
}

private fun reiniciarCampos(){
    with(cRegistrarse){
        userInput.clear()
        passInput.clear()
        repetirPassInput.clear()
        comboPais.value = null
    }
}