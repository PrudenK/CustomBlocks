package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.WebSocket.BuscarPartida.BuscarPartidaEmisor
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.TextArea
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorBuscarPartida: ControladorGEN(), Initializable {
    @FXML lateinit var textArea: TextArea


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
        BuscarPartidaEmisor.buscarPartidas(jugadorConTodo!!.id, object : BuscarPartidaEmisor.Listener {
            override fun onPartidasRecibidas(partidas: List<String>) {
                textArea.text = partidas.joinToString("\n")
            }
        })
    }

    override fun setStage(stage: Stage?) {
        stageBuscarPartida = stage!!
    }
    override fun setBoton(b: Button?) {}


}