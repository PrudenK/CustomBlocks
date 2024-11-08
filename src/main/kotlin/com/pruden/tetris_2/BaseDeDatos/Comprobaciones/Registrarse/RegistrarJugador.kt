package com.pruden.tetris_2.BaseDeDatos.Comprobaciones.Registrarse

import com.pruden.tetris_2.BaseDeDatos.InsertarDatosRegistro.insertarEnTablaPiezas
import com.pruden.tetris_2.BaseDeDatos.InsertarDatosRegistro.insertarEstasGen
import com.pruden.tetris_2.BaseDeDatos.InsertarDatosRegistro.insetarEnTablasModos
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Controladores.Login.ControladorRegistrarse
import com.pruden.tetris_2.Controladores.Login.ControladorRegistrarse.Companion.cRegistrarse

fun registrarJugador(){
    with(cRegistrarse){
        val consulta = "Insert into jugador (nombre, contrasena, nivel, fechaini, pais, experiencia) values (?,?,0,current_date,?,0)"
        val preparedStatment = ControladorLogin.conexion.prepareStatement(consulta)

        comprobacionesRegistrar()

        if(loginCorrecto){
            preparedStatment.setString(1, userInput.text)
            preparedStatment.setString(2, contraHas)
            preparedStatment.setString(3, comboPais.value)

            preparedStatment.executeUpdate()

            cargarIdNuevoJugador()

            reiniciarCampos()

            errorLabel.text = "El registro ha sido correcto"


            insertarEnTablaPiezas()
            insetarEnTablasModos()
            insertarEstasGen()
        }
    }
}


private fun cargarIdNuevoJugador(){
    val idNuevo = ControladorLogin.statment.executeQuery("Select max(id) as id from jugador")
    idNuevo.next()
    ControladorRegistrarse.idNuevoJugador = idNuevo.getInt("id")
}


private fun reiniciarCampos(){
    with(cRegistrarse){
        userInput.clear()
        passInput.clear()
        repetirPassInput.clear()
        comboPais.value = null
    }
}

