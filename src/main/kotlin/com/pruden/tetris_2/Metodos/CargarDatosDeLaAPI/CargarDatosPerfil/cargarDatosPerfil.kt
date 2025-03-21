package com.pruden.tetris_2.Metodos.CargarDatosDeLaAPI.CargarDatosPerfil

import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.Perfil.ControladorPerfil.Companion.cPerfil
import javafx.scene.image.Image
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
                fechaIniLabel.text = jugador.getFechaFormateada()
                paisLabel.text = jugador.pais
                imagenPerfil.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${jugador.imagen}", true)
            }
        }
    }
}

fun cargarDatosPartidas(otroModo: String = ""){
    with(cPerfil){
        var modoActual = Listas.LISTA_MODOS_DE_JUEGOS[Listas.LISTA_MODOS_DE_JUEGOS.indexOf(comboBox.value)]

        if(otroModo.isNotBlank()){
            modoActual = otroModo
        }

        CoroutineScope(Dispatchers.IO).launch {
            val estadisticas = ApiCustom.partidaService.getEstadisticasPorModoYUsuario(ControladorPrincipal.idJugador, modoActual)

            javafx.application.Platform.runLater {
                when(modoActual){
                    "Custom" -> {
                        lineasCustomLabel.text = estadisticas.lineasSum.toString()
                        puntosCustomLabel.text = estadisticas.puntuacionesSum.toString()
                        tiempoCustomLabel.text = estadisticas.tiempoTotal
                        partidasCustomLabel.text = estadisticas.totalDePartidas.toString()
                    }
                    "Todos" -> {
                        lineasTotalesLabel.text = estadisticas.lineasSum.toString()
                        puntosTotalesLabel.text = estadisticas.puntuacionesSum.toString()
                        tiempoTotalLabel.text = estadisticas.tiempoTotal
                        partidasTotalesLabel.text = estadisticas.totalDePartidas.toString()
                    }
                    else -> {
                        maxNivelModoLabel.text = estadisticas.maxNivel.toString()
                        maxLineasModoLabel.text = estadisticas.maxLineas.toString()
                        maxPuntuModoLabel.text = estadisticas.maxPuntuacion.toString()
                        maxTiempoModoLabel.text = estadisticas.maxTiempo
                        lineasSumModoLabel.text = estadisticas.lineasSum.toString()
                        puntosSumModoLabel.text = estadisticas.puntuacionesSum.toString()
                        tiempoSumModoLabel.text = estadisticas.tiempoTotal
                        partidasJugadasModos.text = estadisticas.totalDePartidas.toString()
                    }
                }
            }
        }
    }
}