package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class ControladorTerminarPartidaPVP: ControladorGEN(), Initializable {
    @FXML lateinit var img: ImageView

    @FXML lateinit var nivelHost: Label
    @FXML lateinit var lineasHost: Label
    @FXML lateinit var puntosHost: Label

    @FXML lateinit var nivelVisi: Label
    @FXML lateinit var lineasVisi: Label
    @FXML lateinit var puntosVisi: Label

    @FXML lateinit var nombreHost: Label
    @FXML lateinit var nombreVisi: Label

    @FXML lateinit var titulo: Label



    companion object{
        lateinit var stageTerminarPartidaPVP: Stage
        var resultado = ""
    }


    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        when(resultado){
            "Ganas" ->{
                titulo.text = "¡Has ganado!"
                img.image = deRutaAImagen("/Imagenes/Logos/ganador.png")
            }
            "Pierdes"->{
                titulo.text = "¡Has perdido!"
                img.image = deRutaAImagen("/Imagenes/Logos/perder.png")
            }
            "Empate"->{
                titulo.text = "¡Empate!"
                img.image = deRutaAImagen("/Imagenes/Logos/empate.png")
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            delay(150)
            Platform.runLater{
                nivelHost.text = cPrin.nivelHostLabel.text
                lineasHost.text = cPrin.lineasHostLabel.text
                puntosHost.text = cPrin.puntuacionHostLabel.text

                nivelVisi.text = cPrin.nivelVisiLabel.text
                lineasVisi.text = cPrin.lineasVisiLabel.text
                puntosVisi.text = cPrin.puntuacionVisiLabel.text

                nombreHost.text = cPrin.lineasHostNombre.text.substring(0,cPrin.lineasHostNombre.text.length-1)
                nombreVisi.text = cPrin.lineasVisiNombre.text.substring(0,cPrin.lineasVisiNombre.text.length-1)
            }
        }

    }

    @FXML fun volver(){
        stageTerminarPartidaPVP.close()
    }

    @FXML fun revancha(){

    }


    override fun setStage(stage: Stage?) {
        stageTerminarPartidaPVP = stage!!
    }

    override fun setBoton(b: Button?) {}
}