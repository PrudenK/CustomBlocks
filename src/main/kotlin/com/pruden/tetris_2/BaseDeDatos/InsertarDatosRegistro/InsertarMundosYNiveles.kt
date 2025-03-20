package com.pruden.tetris_2.BaseDeDatos.InsertarDatosRegistro

import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Controladores.Login.ControladorRegistrarse

//todo seran implementados cuando tenga todos los niveles
fun insertatMundo(){
    val consulta = "Insert into mundo (idMundo, idJugador, completado, desbloqueado) values (?,?,false,false)"
    for (i in 1..9){
       // val preparedStatment = ControladorLogin.conexion.prepareStatement(consulta)
        //preparedStatment.setInt(1, i)
        //preparedStatment.setInt(2, ControladorRegistrarse.idNuevoJugador)
        //preparedStatment.executeUpdate()
    }
}

fun insertarNivel(){
    val consulta = "Insert into nivel (idNivel, idMundo, idJugador, tiempoObj, puntuacionObj, mejorTiempo, " +
            "mejorPuntuacion, completado, desbloqueado) values (?, ? ,?, ?, ?, ?, 0, false, fasle)"

    for (i in 1..9){
        for (j in 1..9){

        }
    }
}