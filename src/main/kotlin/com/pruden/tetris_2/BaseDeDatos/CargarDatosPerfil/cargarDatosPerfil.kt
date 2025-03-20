package com.pruden.tetris_2.BaseDeDatos.CargarDatosPerfil

import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Controladores.Perfil.ControladorPerfil.Companion.cPerfil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun cargarDatosUsuarioPerfil(){
    CoroutineScope(Dispatchers.IO).launch {
        val jugador = ApiCustom.jugadorService.getJugadorPorId(ControladorPrincipal.idJugador)

        javafx.application.Platform.runLater {
            with(cPerfil){
                usuarioLabel.text = jugador.nombre
                nivelLabel.text = jugador.nivel.toString()
                experienciaLabel.text = jugador.experiencia.toString()
                fechaIniLabel.text = jugador.getFechaFormateada()
                paisLabel.text = jugador.pais
            }
        }
    }
}

fun cargarDatosModos(){
    with(cPerfil){
        val modoActual = Listas.LISTA_MODOS_ESTADISTICAS[Listas.LISTA_MODOS_DE_JUEGOS.indexOf(comboBox.value)]

        val consulta = "Select maxNivel, maxLineas, maxPuntuacion, maxTiempo, lineasSum, puntuacionesSum, " +
                "tiempoTotal from $modoActual where idJugador = ${ControladorPrincipal.idJugador}"

        val datos = ControladorLogin.statment.executeQuery(consulta)

        datos.next()

        maxNivelModoLabel.text = datos.getInt("maxNivel").toString()
        maxLineasModoLabel.text = datos.getInt("maxLineas").toString()
        maxPuntuModoLabel.text = datos.getInt("maxPuntuacion").toString()
        maxTiempoModoLabel.text = datos.getString("maxTiempo")
        lineasSumModoLabel.text = datos.getInt("lineasSum").toString()
        puntosSumModoLabel.text = datos.getInt("puntuacionesSum").toString()
        tiempoSumModoLabel.text = datos.getString("tiempoTotal")
    }
}

fun cargarDatosEstaTotales(){
    val consulta = "Select lineasSum, puntuacionesSum, tiempoTotal, partidas from estaTotales where idJugador = ${ControladorPrincipal.idJugador}"
    val consultaNumPieza = "Select total from estaPiezas where idJugador = ${ControladorPrincipal.idJugador}"

    var datos = ControladorLogin.statment.executeQuery(consulta)

    datos.next()
    with(cPerfil){
        lineasTotalesLabel.text = datos.getInt("lineasSum").toString()
        puntosTotalesLabel.text = datos.getInt("puntuacionesSum").toString()
        tiempoTotalLabel.text = datos.getString("tiempoTotal").toString()
        partidasTotalesLabel.text = datos.getInt("partidas").toString()

        datos = ControladorLogin.statment.executeQuery(consultaNumPieza)

        datos.next()

        totalPiezas.text = datos.getInt("total").toString()
    }
}

fun cargarDatosCustom(){
    val consulta = "Select lineasSum, puntuacionesSum, tiempoTotal, partidas from estaCustom where idJugador = ${ControladorPrincipal.idJugador}"

    var datos = ControladorLogin.statment.executeQuery(consulta)

    datos.next()

    with(cPerfil){
        lineasCustomLabel.text = datos.getInt("lineasSum").toString()
        puntosCustomLabel.text = datos.getInt("puntuacionesSum").toString()
        tiempoCustomLabel.text = datos.getString("tiempoTotal")
        partidasCustomLabel.text = datos.getInt("partidas").toString()

        val selectPiezasDistintoACero = Listas.NOMBRES_PIEZAS.joinToString(" + ") { "SIGN($it)" }

        val consultaPiezasJugadas = "Select ($selectPiezasDistintoACero) as piezasNoCero from estaPiezas where idJugador = ${ControladorPrincipal.idJugador}"

        datos = ControladorLogin.statment.executeQuery(consultaPiezasJugadas)

        datos.next()

        customPiezasLabel.text = datos.getInt("piezasNoCero").toString()+"/32"
    }

}