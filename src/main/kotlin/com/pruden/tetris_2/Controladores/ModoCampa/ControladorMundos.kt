package com.pruden.tetris_2.Controladores.ModoCampa

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Metodos.ModoCampa.Data.cargarAccionesImageViewsNiveles
import com.pruden.tetris_2.Metodos.ModoCampa.Data.imagenesMundo1
import com.pruden.tetris_2.Metodos.ModoCampa.Data.listaImagenesMundos
import com.pruden.tetris_2.Metodos.ModoCampa.Data.listaNivelesMundo1
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
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

    var mundoActual = 1
    val listaNivelesMundos = listOf(listaNivelesMundo1)

    companion object{
        lateinit var cMundo1: ControladorMundos

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

        val listaImageView = listOf(nivel1, nivel2, nivel3, nivel4, nivel5, nivel6, nivel7, nivel8, nivel9)

        for (i in imagenesMundo1.indices){
            listaImageView[i].image = listaImagenesMundos[mundoActual][i]
        }
    }

    override fun setStage(stage: Stage?) {
        stageMundo1 = stage!!
    }

    override fun setBoton(b: Button?) {
    }
}