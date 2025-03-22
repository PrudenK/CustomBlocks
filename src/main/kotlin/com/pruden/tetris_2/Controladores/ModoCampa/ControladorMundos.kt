package com.pruden.tetris_2.Controladores.ModoCampa

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Metodos.ModoCampa.Data.*
import com.pruden.tetris_2.Metodos.ModoCampa.Dataº.cargarAccionesImageViewsNiveles
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import javafx.stage.Stage
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

    @FXML lateinit var labelNumMundo: Label

    val listaNivelesMundos = listOf(listaNivelesMundo1, listaNivelesMundo2, listaNivelesMundo3, listaNivelesMundo4,
        listaNivelesMundo5, listaNivelesMundo6, listaNivelesMundo7, listaNivelesMundo8, listaNivelesMundo9)

    companion object{
        lateinit var cMundo1: ControladorMundos
        var mundoActual = 1
    }


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cMundo1 = this

        cargarAccionesImageViewsNiveles()
    }


    @FXML fun volver(){
        stageMundo1.close()
    }


    fun setMundo(mundo : Int){
        mundoActual = mundo-1

        labelNumMundo.text = "Mundo "+ (mundoActual+1)

        Platform.runLater {
            val listaImageView = listOf(nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9)

            for (i in imagenesMundo1.indices){
                listaImageView[i].image = listaImagenesMundos[mundoActual][i]
            }
        }
    }

    override fun setStage(stage: Stage?) {
        stageMundo1 = stage!!
    }

    override fun setBoton(b: Button?) {
    }
}