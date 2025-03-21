package com.pruden.tetris_2.Controladores.Suscripciones

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaSuscripciones
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorSuscripciones : ControladorGEN(), Initializable{
    lateinit var stageSuscripciones: Stage

    @FXML lateinit var modosSuscripcion: Label
    @FXML lateinit var partidasSuscripcion: Label
    @FXML lateinit var tituloSuscripcion: Label
    @FXML lateinit var nombreSusCarrusel: Label
    @FXML lateinit var precioSuscripcion: Label
    @FXML lateinit var imgSuscripcion: ImageView


    private var indice = 0

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        indice = 0
        cambiosSuscripcion()
    }

    @FXML fun cerrar(){
        stageSuscripciones.close()
    }

    @FXML fun comprar(){

    }

    @FXML fun atras(){
        if(indice == 0){
            indice = listaSuscripciones.size-1
        }else indice--
        cambiosSuscripcion()
    }

    @FXML fun siguiente(){
        if(indice == listaSuscripciones.size-1){
            indice = 0
        }else indice++
        cambiosSuscripcion()
    }

    private fun cambiosSuscripcion(){
        val suscripcion = listaSuscripciones[indice]
        tituloSuscripcion.text = suscripcion.nombre
        modosSuscripcion.text = "- Podrás crear ${suscripcion.nummodos} modos"
        partidasSuscripcion.text = "- Podrás guardar ${suscripcion.numPartidasGuardadas} partidas"
        precioSuscripcion.text = "- Precio: ${suscripcion.precio}"
        nombreSusCarrusel.text = suscripcion.nombre
        imgSuscripcion.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${suscripcion.imagen}", true)
    }

    override fun setStage(stage: Stage?) {
        stageSuscripciones = stage!!
    }

    override fun setBoton(b: Button?) {
    }


}