package com.pruden.tetris_2.Controladores.ModosDeJuego.PVP

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.ObjsAuxApi.PartidaPVP
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.eresHostPVP
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idRivalPVP
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
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
        var resultadoNombre = "1-0"
        when(resultado){
            "Ganas" ->{
                titulo.text = "¡Has ganado!"
                img.image = deRutaAImagen("/Imagenes/Logos/ganador.png")
            }
            "Pierdes"->{
                titulo.text = "¡Has perdido!"
                img.image = deRutaAImagen("/Imagenes/Logos/perder.png")
                resultadoNombre = "0-1"
            }
            "Empate"->{
                titulo.text = "¡Empate!"
                img.image = deRutaAImagen("/Imagenes/Logos/empate.png")
                resultadoNombre = "1/2"
            }
            "Abandono"->{
                titulo.text = "Tu rival se ha rendido"
                img.image = deRutaAImagen("/Imagenes/Logos/ganador.png")
                titulo.style = "-fx-font-family: 'Liberation Mono'; -fx-font-size: 18px; -fx-text-fill: #e9e8e8; -fx-font-weight: bold;"
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

                cPrin.nivelHostLabel.text = "1"
                cPrin.lineasHostLabel.text = "0"
                cPrin.puntuacionHostLabel.text = "0"

                cPrin.nivelVisiLabel.text = "1"
                cPrin.lineasVisiLabel.text = "0"
                cPrin.puntuacionVisiLabel.text = "0"

                cPrin.mensajeRivalNivel.isVisible = false
            }

            if(eresHostPVP){
                val response = ApiCustom.partidaService.subirPartidaPVP(
                    PartidaPVP(
                        host = jugadorConTodo!!.id,
                        visitante = idRivalPVP,
                        modo = cPrin.labelModo.text,
                        resultado = resultadoNombre
                    )
                )

                println(response)
            }
        }

    }

    @FXML fun volver(){
        Platform.runLater {
            val c = nombreVisi.scene.window as Stage
            c.close()
        }// lo pongo así pq a veces no funciona de la manera clásica
    }

    @FXML fun revancha(){

    }


    override fun setStage(stage: Stage?) {
        println(12343143141341341)
        stageTerminarPartidaPVP = stage!!
    }

    override fun setBoton(b: Button?) {}
}