package com.pruden.tetris_2.Controladores.Suscripciones

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.SuscripcionJugador
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ModosDeJuego.TusModos.ControladorTusModos
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

    companion object{
        var indiceSuscripciones = 0
        var seAbreDesdeTusModos = false
    }

    private var animacionEnCurso = false
    private val scope = CoroutineScope(Dispatchers.Default)

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private val fechaInicio = LocalDate.now()
    private val fechaFin = fechaInicio.plusDays(31)

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        cambiosSuscripcion()
    }

    @FXML fun cerrar(){
        stageSuscripciones.close()
        if(seAbreDesdeTusModos){
            seAbreDesdeTusModos = false
            ControladorTusModos.stageTusModos.show()
        }
    }

    @FXML fun comprar(){
        val suscripcion = jugadorConTodo!!.listaSuscripciones[indiceSuscripciones]
        CoroutineScope(Dispatchers.IO).launch {
            val response = ApiCustom.suscripcionJugadorService.jugadorSeSuscribe(idJugador, suscripcion.tipo)
            println(response)
            when(response.code()){
                201 ->{
                    mostrarErrorTemporal("Suscripción tramitada con éxito")
                    mensajeSuscripcion.textFill = Color.web("#9abbe1")
                    jugadorConTodo!!.suscripcionDelJugador = SuscripcionJugador(
                        tipo = suscripcion.tipo,
                        fechainicio = fechaInicio.format(formatter),
                        fechafin = fechaFin.format(formatter)
                    )

                    Platform.runLater {
                        comprar.text = "Activa"
                        comprar.isDisable = true
                    }
                    paraTimeLineAnuncios()
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
        if(indiceSuscripciones == 0){
            indiceSuscripciones = jugadorConTodo!!.listaSuscripciones.size-1
        }else indiceSuscripciones--
        cambiosSuscripcion()
    }

    @FXML fun siguiente(){
        if(indiceSuscripciones == jugadorConTodo!!.listaSuscripciones.size-1){
            indiceSuscripciones = 0
        }else indiceSuscripciones++
        cambiosSuscripcion()
    }

    private fun cambiosSuscripcion(){
        val suscripcion = jugadorConTodo!!.listaSuscripciones[indiceSuscripciones]
        tituloSuscripcion.text = suscripcion.nombre
        modosSuscripcion.text = "- Podrás crear ${suscripcion.nummodos} modos"
        partidasSuscripcion.text = "- Podrás guardar ${suscripcion.numPartidasGuardadas} partidas"
        precioSuscripcion.text = "- Precio: ${suscripcion.precio}"
        nombreSusCarrusel.text = suscripcion.nombre
        imgSuscripcion.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${suscripcion.imagen}", true)

        val suscripcionJugador = jugadorConTodo!!.suscripcionDelJugador!!.tipo
        if(suscripcionJugador != -1){
            if(indiceSuscripciones > suscripcionJugador -1 ){
                comprar.text = "Mejorar"
            }else{
                comprar.text = "Activa"
            }
        }else{
            comprar.text = "Comprar"
        }
        comprar.isDisable = indiceSuscripciones <= suscripcionJugador-1

        println("Indice: $indiceSuscripciones")
        println("Sus user: $suscripcionJugador")

    }

    override fun setStage(stage: Stage?) {
        stageSuscripciones = stage!!
    }

    override fun setBoton(b: Button?) {
    }


}