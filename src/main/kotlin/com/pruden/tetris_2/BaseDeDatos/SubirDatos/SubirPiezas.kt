package com.pruden.tetris_2.BaseDeDatos.SubirDatos

import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Piezas.*

var contadorPiezas = MutableList(Listas.NOMBRES_PIEZAS.size) { 0 }

fun sumarTipoPieza(pieza : Piezas){
    for ((indice, p) in Listas.LISTA_INSTANCIAS_PIEZAS.withIndex()){
        if (p.isInstance(pieza)){
            contadorPiezas[indice] += 1
            break
        }
    }
}
fun subirTodoEstaPiezas(){
    for (pieza in Listas.NOMBRES_PIEZAS){
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
    val piezaActu = piezaTabla.getInt(piezaColumna) + contadorPiezas[Listas.NOMBRES_PIEZAS.indexOf(piezaColumna)]

    val preparedStatement = ControladorLogin.conexion.prepareStatement(consultaSubirPieza)

    preparedStatement.setInt(1,piezaActu)

    preparedStatement.executeUpdate()
}

