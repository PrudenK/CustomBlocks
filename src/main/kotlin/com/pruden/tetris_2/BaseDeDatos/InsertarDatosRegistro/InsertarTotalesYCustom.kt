package com.pruden.tetris_2.BaseDeDatos.InsertarDatosRegistro

import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Controladores.Login.ControladorRegistrarse

fun insertarEstasGen(){
    val listaEsta = listOf("estaCustom", "estaTotales")
    for (esta : String in listaEsta) {
        val consulta = """
            INSERT INTO $esta (idJugador, lineasSum, puntuacionesSum, tiempoTotal, partidas)
            VALUES (?, 0, 0, '00:00:00',0)
        """
        val preparedStatment = ControladorLogin.conexion.prepareStatement(consulta)

        preparedStatment.setInt(1, ControladorRegistrarse.idNuevoJugador)
        preparedStatment.executeUpdate()
    }
}