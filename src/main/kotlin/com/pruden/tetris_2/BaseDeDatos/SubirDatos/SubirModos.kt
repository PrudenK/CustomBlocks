package com.pruden.tetris_2.BaseDeDatos.SubirDatos

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Metodos.Cronometro.formatoASegundos
import com.pruden.tetris_2.Metodos.Cronometro.segundosAFormato
import kotlin.math.max

fun subirDatosModo(){
    val listaModosEsta = listOf("estaClasico", "estaClasicoV2", "estaAllIn", "estaAlgebra","estaRapidO",
        "estaMemory", "estaMemoryX", "estaMemoryY")

    val listaModos = listOf("Clásico", "Clásico v2", "All in", "Algebra", "RapidO", "Memory", "MemoryX", "MemoryY")

    val hashMapModos = HashMap<String, String>()

    for (i in listaModos.indices) {
        hashMapModos[listaModos[i]] = listaModosEsta[i]
    }

    val tablaConsulta = hashMapModos[ControladorPrincipal.cPrin.labelModo.text]


    val consulta = """
        UPDATE $tablaConsulta
        SET 
            maxNivel = ?, 
            maxLineas = ?, 
            maxPuntuacion = ?, 
            maxTiempo = ?, 
            lineasSum = ?, 
            puntuacionesSum = ?, 
            tiempoTotal = ?
        WHERE idJugador = ?
    """

    val registros = ControladorLogin.statment.executeQuery("Select * from $tablaConsulta where idJugador = ${ControladorPrincipal.idJugador}")

    registros.next()

    val maxNivel = max(registros.getInt("maxNivel"), ControladorPrincipal.cPrin.labelNivel.text.toInt())
    val maxLineas = max(registros.getInt("maxLineas"), ControladorPrincipal.cPrin.labelLineas.text.toInt())
    val maxPuntuacion = max(registros.getInt("maxPuntuacion"), ControladorPrincipal.cPrin.labelPuntuacion.text.toInt())
    val maxTiempo = segundosAFormato(
        max(
            formatoASegundos(registros.getString("maxTiempo")), formatoASegundos(
                ControladorPrincipal.cPrin.cronometroLabel.text)
        )
    )

    val lineasSum = registros.getInt("lineasSum") + ControladorPrincipal.cPrin.labelLineas.text.toInt()
    val puntuacionesSum = registros.getInt("puntuacionesSum") + ControladorPrincipal.cPrin.labelPuntuacion.text.toInt()
    val tiempoTotal = segundosAFormato(
        formatoASegundos(registros.getString("tiempoTotal")) + formatoASegundos(
            ControladorPrincipal.cPrin.cronometroLabel.text)
    )


    val preparedStatment = ControladorLogin.conexion.prepareStatement(consulta)

    preparedStatment.setInt(1, maxNivel)
    preparedStatment.setInt(2, maxLineas)
    preparedStatment.setInt(3, maxPuntuacion)
    preparedStatment.setString(4, maxTiempo)
    preparedStatment.setInt(5, lineasSum)
    preparedStatment.setInt(6, puntuacionesSum)
    preparedStatment.setString(7, tiempoTotal)
    preparedStatment.setInt(8, ControladorPrincipal.idJugador)

    preparedStatment.executeUpdate()
}