package com.pruden.tetris_2.Metodos.Comprobaciones.Registrarse

import com.pruden.tetris_2.Metodos.Comprobaciones.hashearContraConSAl
import com.pruden.tetris_2.Controladores.Login.ControladorRegistrarse.Companion.cRegistrarse

fun comprobacionesRegistrar(){
    with(cRegistrarse){
        registroCorrecto = true
        if(comboPais.value == null){
            registroCorrecto = false
            errorLabel.text = "Selecciona tu país"
        }

        if (userInput.text.isBlank()){
            registroCorrecto = false
            errorLabel.text = "El nombre no puede estar vacio"
        }else if(passInput.text == repetirPassInput.text){
            if (passInput.text.isBlank()){
                registroCorrecto = false
                errorLabel.text = "No puedes tener la contrasña en blanco"
            }else contraHas = hashearContraConSAl(passInput.text)
        } else {
            registroCorrecto = false
            errorLabel.text = "Las contraseñas no coinciden"
        }
    }
}