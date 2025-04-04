package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.Controladores.Clan.ControladorJugadorClan
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.WebSocket.BuscarPartida.BuscarPartidaEmisor
import com.pruden.tetris_2.WebSocket.BuscarPartida.JugadorConModo
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.control.Button
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

    companion object{
        lateinit var stageBuscarPartida: Stage
    }

    private var jobRefrescar: kotlinx.coroutines.Job? = null



    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        println("✅ Inicializando controlador de buscar partida...")

        cargarPartidas() // Primera carga

        jobRefrescar = CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                println("🔁 Job de refresco ejecutándose...")
                delay(1500)
                Platform.runLater {
                    println("🔄 Recargando partidas desde job...")
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

    private fun cargarPartidas(){
        BuscarPartidaEmisor.buscarPartidas(jugadorConTodo!!, object : BuscarPartidaEmisor.Listener {
            override fun onPartidasRecibidas(jugadores: List<JugadorConModo>) {
                for((fila, j) in jugadores.withIndex()){
                    val loader = FXMLLoader(javaClass.getResource("/com/pruden/tetris_2/Vistas/PVP/itemJugadorBuscarPartida.fxml"))
                    val item = loader.load<Pane>()
                    val controller = loader.getController<ControladorJugadorBuscarPartida>()
                    controller.setPartidaJugador(j)

                    Platform.runLater {
                        gridPartidas.add(item, 0, fila)
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