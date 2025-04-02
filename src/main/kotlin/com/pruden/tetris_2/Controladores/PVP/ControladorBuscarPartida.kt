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
import java.net.URL
import java.util.*

class ControladorBuscarPartida: ControladorGEN(), Initializable {
    @FXML lateinit var gridPartidas: GridPane

    companion object{
        lateinit var stageBuscarPartida: Stage
    }



    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        cargarPartidas()
    }

    @FXML fun volver(){
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
    }
    override fun setBoton(b: Button?) {}


}