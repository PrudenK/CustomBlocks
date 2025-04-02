package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.WebSocket.CrearPartida.PartidaEmisor
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorCrearPartidaPVP: ControladorGEN() {
    companion object{
        lateinit var stageCrearPartidaPVP: Stage
    }

    @FXML fun crearPartida(){
        val modo = "Clásico"


        PartidaEmisor.crearPartida(jugadorConTodo!!.id, modo)

    }

    @FXML fun volver(){
        stageCrearPartidaPVP.close()
    }



    override fun setStage(stage: Stage?) {
        stageCrearPartidaPVP = stage!!
    }

    override fun setBoton(b: Button?) {}
}