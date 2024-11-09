package com.pruden.tetris_2.Metodos.PartidaVistaDatos

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Controladores.Partidas.ControladorPartidas.Companion.cPartidas
import java.sql.ResultSet

fun cargarDatosPartidas(){
    cPartidas.datosPartida.clear()
    val datos = consultaPartidas()
    with(datos){
        while (next()){
            cPartidas.datosPartida.add(
                Partida(getInt(1), getString(2), getInt(3), getInt(4),
                getString(5), getInt(6), getString(7))
            )
        }
    }
    ordenar()
}

private fun consultaPartidas() : ResultSet {
    return if (cPartidas.comboFiltrar.value == "Todos"){
        ControladorLogin.statment.executeQuery("Select idPartida, modo, nivel, puntuacion, tiempo, lineas, fechaJuego from partida where idJugador = ${ControladorPrincipal.idJugador}")
    }else{
        val consulta = "SELECT idPartida, modo, nivel, puntuacion, tiempo, lineas, fechaJuego FROM partida WHERE idJugador = ? AND modo = ?"
        val preparedStatement = ControladorLogin.conexion.prepareStatement(consulta)

        preparedStatement.setInt(1, ControladorPrincipal.idJugador)
        preparedStatement.setString(2, cPartidas.comboFiltrar.value)

        return preparedStatement.executeQuery()
    }
}