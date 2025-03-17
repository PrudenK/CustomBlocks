package com.pruden.tetris_2.BaseDeDatos.CargarDatosPerfil

import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Controladores.Perfil.ControladorPiezasPerfil.Companion.cPiezasPerfil
import javafx.application.Platform
import javafx.scene.control.Label

fun cargarDatosPiezasPerfil(){
    Platform.runLater{
        val consulta = "Select * from estaPiezas where idJugador = ${ControladorPrincipal.idJugador}"

        val datos = ControladorLogin.statment.executeQuery(consulta)

        datos.next()

        for (columna in Listas.NOMBRES_PIEZAS_Y_TOTAL){
            val label = cPiezasPerfil.stagePiezasPerfil.scene.lookup("#$columna") as Label
            label.text = datos.getInt(columna).toString()
        }
    }
}