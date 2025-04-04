package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.WebSocket.CrearPartida.CrearPartidaEmisor
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import javafx.scene.text.Text
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorCrearPartidaPVP: ControladorGEN(), Initializable {
    @FXML lateinit var textoModos: Text
    @FXML lateinit var imgModos: ImageView

    companion object{
        lateinit var stageCrearPartidaPVP: Stage
    }

    private var indice = 0

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        indice = 0
        cambairUISegunIndice()
    }

    @FXML fun crearPartida(){
        CrearPartidaEmisor.crearPartida(jugadorConTodo!!, Listas.LISTA_MODOS_DE_JUEGOS[indice])
    }

    @FXML fun volver(){
        stageCrearPartidaPVP.close()
        CrearPartidaEmisor.cancelarPartida(jugadorConTodo!!)
    }

    @FXML fun atras(){
        if(indice == 0){
            indice = Listas.LISTA_MODOS_DE_JUEGOS.size - 1
        }else{
            indice--
        }
        cambairUISegunIndice()
    }

    @FXML fun siguiente(){
        if(indice == Listas.LISTA_MODOS_DE_JUEGOS.size - 1){
            indice = 0
        }else{
            indice++
        }
        cambairUISegunIndice()
    }

    private fun cambairUISegunIndice(){
        textoModos.text = Listas.LISTA_MODOS_DE_JUEGOS[indice]
        imgModos.image = Listas.LISTA_IMAGENES_MODOS_OFICIALES[indice]
    }

    override fun setStage(stage: Stage?) {
        stageCrearPartidaPVP = stage!!
        stageCrearPartidaPVP.setOnCloseRequest {
            CrearPartidaEmisor.cancelarPartida(jugadorConTodo!!)
        }
    }

    override fun setBoton(b: Button?) {}

}