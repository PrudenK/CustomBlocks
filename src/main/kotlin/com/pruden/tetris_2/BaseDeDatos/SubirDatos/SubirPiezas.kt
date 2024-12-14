package com.pruden.tetris_2.BaseDeDatos.SubirDatos

import com.pruden.tetris_2.BaseDeDatos.CargarDatosPerfil.listaInstancias
import com.pruden.tetris_2.BaseDeDatos.CargarDatosPerfil.nombresPiezas
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Piezas.*

var contadorPiezas = MutableList(nombresPiezas.size) { 0 }

fun sumarTipoPieza(pieza : Piezas){
    for ((indice, p) in listaInstancias.withIndex()){
        if (p.isInstance(pieza)){
            contadorPiezas[indice] += 1
            break
        }
    }
}
fun subirTodoEstaPiezas(){
    for (pieza in nombresPiezas){
        subirPiezas(pieza)
    }
    val consultaSubirTotal = """
        Update estaPiezas 
        set total = ?
        where idJugador = ${ControladorPrincipal.idJugador}
    """

    val consultaObtenerTotal = """
       Select total from estaPiezas
        where idJugador = ${ControladorPrincipal.idJugador}
    """

    val totalPiezas = ControladorLogin.statment.executeQuery(consultaObtenerTotal)
    totalPiezas.next()
    val piezaActu = totalPiezas.getInt("total") + contadorPiezas.sum()

    val preparedStatement = ControladorLogin.conexion.prepareStatement(consultaSubirTotal)

    preparedStatement.setInt(1,piezaActu)

    preparedStatement.executeUpdate()
}

private fun subirPiezas(piezaColumna : String){
    val consultaSubirPieza = """
        Update estaPiezas 
        set $piezaColumna = ?
        where idJugador = ${ControladorPrincipal.idJugador}
    """

    val consultaObtenerPieza = """
       Select $piezaColumna from estaPiezas
        where idJugador = ${ControladorPrincipal.idJugador}
    """

    val piezaTabla = ControladorLogin.statment.executeQuery(consultaObtenerPieza)
    piezaTabla.next()
    val piezaActu = piezaTabla.getInt(piezaColumna) + contadorPiezas[nombresPiezas.indexOf(piezaColumna)]

    val preparedStatement = ControladorLogin.conexion.prepareStatement(consultaSubirPieza)

    preparedStatement.setInt(1,piezaActu)

    preparedStatement.executeUpdate()
}

