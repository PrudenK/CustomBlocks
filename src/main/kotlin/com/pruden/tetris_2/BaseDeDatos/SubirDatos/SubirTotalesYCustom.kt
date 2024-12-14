package com.pruden.tetris_2.BaseDeDatos.SubirDatos

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Metodos.Cronometro.formatoASegundos
import com.pruden.tetris_2.Metodos.Cronometro.segundosAFormato

fun subirDatosEstaTotalesYCustom(tabla : String){
    val sentenciaUpdateEstaTotales =
        """
            UPDATE $tabla 
            SET 
                lineasSum = ?, 
                puntuacionesSum = ?, 
                tiempoTotal = ?, 
                partidas = ? 
                WHERE idJugador = ?
        """


    val registros = ControladorLogin.statment.executeQuery("Select * from $tabla where idJugador = ${ControladorPrincipal.idJugador}")

    registros.next()

    val lineasActu = registros.getInt("lineasSum") + ControladorPrincipal.cPrin.labelLineas.text.toInt()
    val puntuacionesActu = registros.getInt("puntuacionesSum") + ControladorPrincipal.cPrin.labelPuntuacion.text.toInt()
    val tiempoActuSecs = formatoASegundos(registros.getString("tiempoTotal")) + formatoASegundos(ControladorPrincipal.cPrin.cronometroLabel.text)
    val partidasActu = registros.getInt("partidas") + 1

    val tiempoActuFormato = segundosAFormato(tiempoActuSecs)

    val preparedStatment = ControladorLogin.conexion.prepareStatement(sentenciaUpdateEstaTotales)

    preparedStatment.setInt(1,lineasActu)
    preparedStatment.setInt(2,puntuacionesActu)
    preparedStatment.setString(3,tiempoActuFormato)
    preparedStatment.setInt(4,partidasActu)
    preparedStatment.setInt(5, ControladorPrincipal.idJugador)

    preparedStatment.executeUpdate()
}