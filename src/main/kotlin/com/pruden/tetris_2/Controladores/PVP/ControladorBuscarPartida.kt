package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.WebSocket.BuscarPartida.BuscarPartidaEmisor
import com.pruden.tetris_2.WebSocket.BuscarPartida.JugadorConModo
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.GridPane
import javafx.scene.layout.Pane
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class ControladorBuscarPartida: ControladorGEN(), Initializable {
    @FXML lateinit var gridPartidas: GridPane
    @FXML lateinit var noHayPartidas: Label

    companion object{
        lateinit var stageBuscarPartida: Stage
    }

    private var jobRefrescar: kotlinx.coroutines.Job? = null



    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        cargarPartidas()

        if(ultimaListaPartidas.isEmpty()) {
            noHayPartidas.isVisible = true
        }

        jobRefrescar = CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                delay(500)
                Platform.runLater {
                    cargarPartidas()
                }
            }
        }
    }


    @FXML fun volver(){
        jobRefrescar?.cancel()
        stageBuscarPartida.close()
    }

    @FXML fun recargar(){
        cargarPartidas()
    }


    private var ultimaListaPartidas: List<JugadorConModo> = emptyList()

    private fun cargarPartidas() {
        BuscarPartidaEmisor.buscarPartidas(jugadorConTodo!!, object : BuscarPartidaEmisor.Listener {
            override fun onPartidasRecibidas(jugadores: List<JugadorConModo>) {
                if (jugadores != ultimaListaPartidas) {
                    ultimaListaPartidas = jugadores

                    if(ultimaListaPartidas.isEmpty()){
                        noHayPartidas.isVisible  = true

                        Platform.runLater {
                            gridPartidas.children.clear()
                        }
                    }else{
                        noHayPartidas.isVisible = false


                        Platform.runLater {
                            gridPartidas.children.clear()
                            for ((fila, j) in jugadores.withIndex()) {
                                val loader = FXMLLoader(javaClass.getResource("/com/pruden/tetris_2/Vistas/PVP/itemJugadorBuscarPartida.fxml"))
                                val item = loader.load<Pane>()
                                val controller = loader.getController<ControladorJugadorBuscarPartida>()
                                controller.setPartidaJugador(j)

                                gridPartidas.add(item, 0, fila)
                            }
                        }
                    }
                }
            }
        })
    }


    override fun setStage(stage: Stage?) {
        stageBuscarPartida = stage!!
        stageBuscarPartida.setOnCloseRequest {
            jobRefrescar?.cancel()
        }
    }
    override fun setBoton(b: Button?) {}
}