package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.WebSocket.CrearPartida.CrearPartidaEmisor
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import javafx.scene.text.Text
import javafx.stage.Stage
import javafx.util.Duration
import java.net.URL
import java.util.*

class ControladorCrearPartidaPVP: ControladorGEN(), Initializable {
    @FXML lateinit var textoModos: Text
    @FXML lateinit var imgModos: ImageView

    @FXML lateinit var partidaCreada: Label
    @FXML lateinit var subtitulo: Label

    private var timeline: Timeline? = null

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
        timeline?.stop()
        crearAnimacionEsperando()
    }

    @FXML fun volver(){
        timeline?.stop()
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
            timeline?.stop()
            CrearPartidaEmisor.cancelarPartida(jugadorConTodo!!)
        }
    }

    private fun crearAnimacionEsperando(){
        subtitulo.isVisible = false
        partidaCreada.isVisible = true
        val estados = listOf(
            "Partida creada, esperando rival",
            "Partida creada, esperando rival.",
            "Partida creada, esperando rival..",
            "Partida creada, esperando rival..."
        )

        var indice = 0

        timeline = Timeline(
            KeyFrame(Duration.seconds(0.3), {
                partidaCreada.text = estados[indice]
                indice = (indice + 1) % estados.size
            })
        )

        timeline!!.cycleCount = Timeline.INDEFINITE
        timeline!!.play()
    }


    override fun setBoton(b: Button?) {}

}