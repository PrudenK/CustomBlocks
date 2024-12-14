package com.pruden.tetris_2.BaseDeDatos.Comprobaciones.Login

import com.pruden.tetris_2.BaseDeDatos.comprobarContra
import com.pruden.tetris_2.BaseDeDatos.getConexion
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Controladores.Login.ControladorLogin.Companion.cLogin
import com.pruden.tetris_2.Metodos.Stages.cargarStagePrincipal

fun iniciarSesionLogin(){
    with(cLogin){
        ControladorLogin.conexion = getConexion()

        var loginCorrecto = false

        val nombresContras = ControladorLogin.statment.executeQuery("Select id, nombre, contrasena from jugador")
        while (nombresContras.next()){
            if (userInput.text == nombresContras.getString("nombre")
                && comprobarContra(passInput.text, nombresContras.getNString("contrasena"))
            ){
                ControladorPrincipal.idJugador = nombresContras.getInt("id")
                loginCorrecto = true
                break

            }
        }

        if(loginCorrecto){
            cargarStagePrincipal()
            ControladorPrincipal.jugarOnline = true
        }else errorLabel.text = "Login incorrecto"
    }
}