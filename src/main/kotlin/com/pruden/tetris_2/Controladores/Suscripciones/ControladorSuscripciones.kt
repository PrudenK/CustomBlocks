package com.pruden.tetris_2.Controladores.Suscripciones

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.SuscripcionJugador
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaSuscripciones
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.suscripcionDelJugador
import com.pruden.tetris_2.Metodos.Timelines.cargarTimeLineAuncios
import com.pruden.tetris_2.Metodos.Timelines.paraTimeLineAnuncios
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.URL
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class ControladorSuscripciones : ControladorGEN(), Initializable{
    lateinit var stageSuscripciones: Stage

    @FXML lateinit var modosSuscripcion: Label
    @FXML lateinit var partidasSuscripcion: Label
    @FXML lateinit var tituloSuscripcion: Label
    @FXML lateinit var nombreSusCarrusel: Label
    @FXML lateinit var precioSuscripcion: Label
    @FXML lateinit var imgSuscripcion: ImageView
    @FXML lateinit var cerrar: Button
    @FXML lateinit var comprar: Button
    @FXML lateinit var pane: Pane
    @FXML lateinit var mensajeSuscripcion: Label

    private var indice = 0
    private var animacionEnCurso = false
    private val scope = CoroutineScope(Dispatchers.Default)

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private val fechaInicio = LocalDate.now()
    private val fechaFin = fechaInicio.plusDays(31)

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        indice = 0
        cambiosSuscripcion()
    }

    @FXML fun cerrar(){
        stageSuscripciones.close()
    }

    @FXML fun comprar(){
        val suscripcion = listaSuscripciones[indice]
        CoroutineScope(Dispatchers.IO).launch {
            val response = ApiCustom.suscripcionJugadorService.jugadorSeSuscribe(idJugador, suscripcion.tipo)

            when(response.code()){
                201 ->{
                    mostrarErrorTemporal("Suscripción tramitada con éxito")
                    mensajeSuscripcion.textFill = Color.web("#9abbe1")
                    suscripcionDelJugador = SuscripcionJugador(
                        tipo = suscripcion.tipo,
                        fechainicio = fechaInicio.format(formatter),
                        fechafin = fechaFin.format(formatter)
                    )
                    paraTimeLineAnuncios()
                }
                409->{
                    mostrarErrorTemporal("Ya tienes una suscripción activa")
                    mensajeSuscripcion.textFill = Color.web("#f88b8b")
                }
            }
        }
    }

    private fun mostrarErrorTemporal(texto: String) {
        if (animacionEnCurso) return

        animacionEnCurso = true

        Platform.runLater {
            mensajeSuscripcion.text = texto
            mensajeSuscripcion.isVisible = true
            cerrar.layoutY = 390.0
            comprar.layoutY = 390.0
            pane.prefHeight = 446.0
            stageSuscripciones.height = 446.0
        }

        scope.launch {
            delay(3000)
            Platform.runLater {
                mensajeSuscripcion.isVisible = false
                cerrar.layoutY = 360.0
                comprar.layoutY = 360.0
                pane.prefHeight = 416.0
                stageSuscripciones.height = 416.0

                animacionEnCurso = false
            }
        }
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