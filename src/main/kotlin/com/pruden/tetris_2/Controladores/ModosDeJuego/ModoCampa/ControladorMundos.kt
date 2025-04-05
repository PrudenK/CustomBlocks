package com.pruden.tetris_2.Controladores.ModosDeJuego.ModoCampa

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.Dataº.cargarAccionesImageViewsNiveles
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.Tooltip
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import javafx.util.Duration
import java.net.URL
import java.util.*

class ControladorMundos : ControladorGEN(), Initializable {
    lateinit var stageMundo1 : Stage
    @FXML lateinit var volverB: Button

    @FXML lateinit var nivel1 : ImageView
    @FXML lateinit var nivel2 : ImageView
    @FXML lateinit var nivel3 : ImageView
    @FXML lateinit var nivel4 : ImageView
    @FXML lateinit var nivel5 : ImageView
    @FXML lateinit var nivel6 : ImageView
    @FXML lateinit var nivel7 : ImageView
    @FXML lateinit var nivel8 : ImageView
    @FXML lateinit var nivel9 : ImageView


    @FXML lateinit var cadenaNivel1 : ImageView
    @FXML lateinit var cadenaNivel2 : ImageView
    @FXML lateinit var cadenaNivel3 : ImageView
    @FXML lateinit var cadenaNivel4 : ImageView
    @FXML lateinit var cadenaNivel5 : ImageView
    @FXML lateinit var cadenaNivel6 : ImageView
    @FXML lateinit var cadenaNivel7 : ImageView
    @FXML lateinit var cadenaNivel8 : ImageView
    @FXML lateinit var cadenaNivel9 : ImageView

    @FXML lateinit var labelNumMundo: Label

    companion object{
        lateinit var cMundo1: ControladorMundos
        var mundoActual = 1
    }


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cMundo1 = this

        cargarAccionesImageViewsNiveles()


        nivel1.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${jugadorConTodo!!.listaMundos[0].imagen}", true)

        println("${ConstantesCustomAPI.PATH_CUSTOM}${jugadorConTodo!!.listaMundos[0].imagen}")
        println(nivel1.image)
    }


    @FXML fun volver(){
        stageMundo1.close()
    }


    fun setMundo(mundo : Int){
        mundoActual = mundo-1

        labelNumMundo.text = "Mundo "+ (mundoActual+1)

        Platform.runLater {
            val listaImageView = listOf(nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9)
            val listaImageViewCadena = listOf(cadenaNivel1, cadenaNivel2, cadenaNivel3, cadenaNivel4, cadenaNivel5,
                cadenaNivel6, cadenaNivel7, cadenaNivel8, cadenaNivel9)

            val listaNivelesAux = jugadorConTodo!!.listaNiveles.filter { it.mundo.idMundo == mundoActual+1 }
            val listaNivelesJugadorAux = jugadorConTodo!!.listaNivelesJugador.filter { it.idMundo == mundoActual+1 }

            for (i in listaNivelesAux.indices){
                listaImageView[i].image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${listaNivelesAux[i].imagen}")
                if(listaNivelesJugadorAux[i].completado){
                    val tooltip = Tooltip(listaNivelesJugadorAux[i].getStats()).apply {
                        showDelay = Duration.millis(350.0)
                        style = "-fx-font-size: 14px; -fx-background-color: #333; -fx-text-fill: white;"
                    }

                    Tooltip.install(listaImageViewCadena[i], tooltip)
                }

            }
        }
    }

    override fun setStage(stage: Stage?) {
        stageMundo1 = stage!!
    }

    override fun setBoton(b: Button?) {
    }
}