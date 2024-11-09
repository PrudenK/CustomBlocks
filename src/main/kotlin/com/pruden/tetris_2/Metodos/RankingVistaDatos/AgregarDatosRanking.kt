package com.pruden.tetris_2.Metodos.RankingVistaDatos

import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Controladores.Rankings.ControladorRankings.Companion.cRanking
import java.sql.ResultSet

fun cargarDatosRanking(){
    val datos = consultaDatos()

    cRanking.datosRanking.clear()

    with(datos){
        while (next()){
            cRanking.datosRanking.add(
                Jugador(getString(1), getInt(2), getInt(3), getInt(4),
                getInt(5), getString(6), getString(7))
            )
        }
    }
}

private fun consultaDatos() : ResultSet {
    with(cRanking){
        if (comboPais.value == "Global"){
            val consulta = "Select nombre, j.nivel, p.nivel, lineas, puntuacion, tiempo, pais from jugador j " +
                    "join partida p on j.id = p.idJugador where p.modo = ? order by p.nivel desc, p.lineas desc, p.puntuacion desc limit 100"

            val preparedStatement = ControladorLogin.conexion.prepareStatement(consulta)

            preparedStatement.setString(1, comboModo.value)

            return preparedStatement.executeQuery()
        }else{
            val consulta = "Select nombre, j.nivel, p.nivel, lineas, puntuacion, tiempo, pais from jugador j " +
                    "join partida p on j.id = p.idJugador where p.modo = ? and j.pais = ? order by p.nivel desc, p.lineas desc, p.puntuacion desc limit 100"

            val preparedStatement = ControladorLogin.conexion.prepareStatement(consulta)

            preparedStatement.setString(1, comboModo.value)
            preparedStatement.setString(2, comboPais.value)

            return preparedStatement.executeQuery()
        }
    }
}