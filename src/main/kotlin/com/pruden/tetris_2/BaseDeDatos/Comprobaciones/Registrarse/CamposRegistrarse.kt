package com.pruden.tetris_2.BaseDeDatos.Comprobaciones.Registrarse

import com.pruden.tetris_2.BaseDeDatos.hashearContraConSAl
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Controladores.Login.ControladorRegistrarse.Companion.cRegistrarse

fun comprobacionesRegistrar(){
    with(cRegistrarse){
        loginCorrecto = true
        if(comboPais.value == null){
            loginCorrecto = false
            errorLabel.text = "Selecciona tu país"
        }

        if(!comprobarNombreUsuario()) {
            errorLabel.text = "Ese usario ya está registrado"
        }else if (userInput.text.isBlank()){
            loginCorrecto = false
            errorLabel.text = "El nombre no puede estar vacio"
        }else if(passInput.text == repetirPassInput.text){
            if (passInput.text.isBlank()){
                loginCorrecto = false
                errorLabel.text = "No puedes tener la contrasña en blanco"
            }else contraHas = hashearContraConSAl(passInput.text)
        } else {
            loginCorrecto = false
            errorLabel.text = "Las contraseñas no coinciden"
        }
    }
}

private fun comprobarNombreUsuario() :Boolean{
    val todosNombres = ControladorLogin.statment.executeQuery("Select nombre from jugador")
    while (todosNombres.next()){
        if (cRegistrarse.userInput.text == todosNombres.getString("nombre")){
            return false
        }
    }
    return true
}