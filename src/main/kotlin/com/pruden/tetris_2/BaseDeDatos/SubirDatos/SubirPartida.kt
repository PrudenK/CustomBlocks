package com.pruden.tetris_2.BaseDeDatos.SubirDatos

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import java.sql.Timestamp

fun subirDatosPartida(){
    val sentenciaSubirPartida =
        """
            INSERT INTO partida (
                idJugador, modo, nivel, puntuacion, tiempo, lineas, fechaJuego
            ) VALUES (?, ?, ?, ?, ?, ?, ?)
        """

    val preparedStatment = ControladorLogin.conexion.prepareStatement(sentenciaSubirPartida)

    preparedStatment.setInt(1, ControladorPrincipal.idJugador)
    preparedStatment.setString(2, ControladorPrincipal.cPrin.labelModo.text)
    preparedStatment.setString(3, ControladorPrincipal.cPrin.labelNivel.text)
    preparedStatment.setString(4, ControladorPrincipal.cPrin.labelPuntuacion.text)
    preparedStatment.setString(5, ControladorPrincipal.cPrin.cronometroLabel.text)
    preparedStatment.setString(6, ControladorPrincipal.cPrin.labelLineas.text)
    preparedStatment.setTimestamp(7, Timestamp(System.currentTimeMillis()) )

    preparedStatment.executeUpdate()
}