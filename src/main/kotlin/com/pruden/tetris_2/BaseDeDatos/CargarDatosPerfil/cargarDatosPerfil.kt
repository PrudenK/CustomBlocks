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
            val modoActual = Listas.LISTA_MODOS_DE_JUEGOS[Listas.LISTA_MODOS_DE_JUEGOS.indexOf(comboBox.value)]

            CoroutineScope(Dispatchers.IO).launch {
                val estadisticas = ApiCustom.partidaService.getEstadisticasPorModoYUsuario(ControladorPrincipal.idJugador, modoActual)

                javafx.application.Platform.runLater {
                    maxNivelModoLabel.text = estadisticas.maxNivel.toString()
                    maxLineasModoLabel.text = estadisticas.maxLineas.toString()
                    maxPuntuModoLabel.text = estadisticas.maxPuntuacion.toString()
                    maxTiempoModoLabel.text = estadisticas.maxTiempo
                    lineasSumModoLabel.text = estadisticas.lineasSum.toString()
                    puntosSumModoLabel.text = estadisticas.puntuacionesSum.toString()
                    tiempoSumModoLabel.text = estadisticas.tiempoTotal
                }
            }
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