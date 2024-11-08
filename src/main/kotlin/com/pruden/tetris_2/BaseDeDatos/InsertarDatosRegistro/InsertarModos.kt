package com.pruden.tetris_2.BaseDeDatos.InsertarDatosRegistro

import com.pruden.tetris_2.BaseDeDatos.CargarDatosPerfil.listaModos
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Controladores.Login.ControladorRegistrarse

fun insetarEnTablasModos(){
    for (modo : String in listaModos){
        val consulta = """
                INSERT INTO $modo (
                    idJugador, maxNivel, maxLineas, maxPuntuacion, maxTiempo, lineasSum, puntuacionesSum, tiempoTotal
                ) VALUES (
                    ?, 0, 0, 0, '00:00:00', 0, 0, '00:00:00'
                )
            """
        val preparedStatment = ControladorLogin.conexion.prepareStatement(consulta)

        preparedStatment.setInt(1, ControladorRegistrarse.idNuevoJugador)
        preparedStatment.executeUpdate()
    }
}