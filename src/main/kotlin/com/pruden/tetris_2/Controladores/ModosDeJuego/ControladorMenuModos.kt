package com.pruden.tetris_2.Controladores.ModosDeJuego

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugarOnline
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.timelinePartida
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.effect.ColorAdjust
import javafx.scene.image.ImageView
import javafx.scene.layout.Pane
import javafx.scene.text.Text
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class ControladorMenuModos: ControladorGEN(), Initializable {
    lateinit var stageMenuMundos : Stage

    @FXML lateinit var imgModos: ImageView
    @FXML lateinit var imgCadena: ImageView
    @FXML lateinit var textoModos: Text
    @FXML lateinit var titulo: Label
    @FXML lateinit var mensajeError: Label

    @FXML lateinit var atras: Button
    @FXML lateinit var volver: Button
    @FXML lateinit var siguiente: Button
    @FXML lateinit var entrar: Button

    @FXML lateinit var pane: Pane


    private var indiceModo = 0

    private val listaNombres = listOf(
        "Modos oficiales", "Modo campaña", "Tus modos", "Modo 1vs1"
    )

    private val imagenesModos = listOf(
        deRutaAImagen("/Imagenes/ModosDeJuego/ModosOficialesMenu.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/ModoCampaMenu.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/TusModosMenu.jpg"),
        deRutaAImagen("/Imagenes/ModosDeJuego/modoPVP.jpg"),
    )

    private val stagesModos = listOf(
        Stages.MODOS_DE_JUEGO_OFICIALES,
        Stages.MODO_CAMPA_MENU_MODOS,
        Stages.MENU_TUS_MODOS_DE_JUEGO,
        Stages.MENU_PVP
    )


    companion object{
        lateinit var cMenuModos : ControladorMenuModos
    }


    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        cMenuModos = this
        actualizarUI()
    }

    @FXML fun siguiente(){
        if(indiceModo == imagenesModos.size -1){
            indiceModo = 0
        }else indiceModo++
        actualizarUI()
    }


    @FXML fun atras(){
        if(indiceModo == 0){
            indiceModo = imagenesModos.size -1
        }else indiceModo--
        actualizarUI()
    }

    @FXML fun volver() = stageMenuMundos.close()


    @FXML fun entrar(){
        when(indiceModo){
            0-> {
                crearStage(stagesModos[0])
            }
            1, 3->{
                if(jugarOnline){
                    crearStage(stagesModos[indiceModo])
                }else{
                    mostrarErrorTemporal("¡Tines que jugar online!")
                }
            }
            2->{
                if(jugarOnline && jugadorConTodo!!.suscripcionDelJugador!!.tipo != -1){
                    crearStage(stagesModos[2], stageMenuMundos)
                }else{
                    mostrarErrorTemporal("¡Necesitas una suscripción!")
                }
            }
        }
    }

    private val grayscale = ColorAdjust().apply { saturation = -1.0 }

    private fun actualizarUI(){
        imgModos.image = imagenesModos[indiceModo]
        textoModos.text = listaNombres[indiceModo]
        titulo.text = listaNombres[indiceModo]

        when(indiceModo){
            0 ->{
                imgCadena.image = null
                imgModos.effect = null
            }
            1, 3->{
                if(!jugarOnline){
                    imgCadena.image = Globales.CADENA
                    imgModos.effect = grayscale
                }else{
                    imgCadena.image = null
                    imgModos.effect = null
                }
            }
            2->{
                if(jugadorConTodo == null || jugadorConTodo!!.suscripcionDelJugador?.tipo == -1){
                    imgCadena.image = Globales.CADENA
                    imgModos.effect = grayscale
                }else{
                    imgCadena.image = null
                    imgModos.effect = null
                }
            }
        }
    }

    private var animacionEnCurso = false
    private val scope = CoroutineScope(Dispatchers.Default)

    private fun mostrarErrorTemporal(texto: String) {
        if (animacionEnCurso) return

        animacionEnCurso = true

        Platform.runLater {
            mensajeError.text = texto
            mensajeError.isVisible = true

            atras.layoutY = 360.0
            siguiente.layoutY = 360.0
            textoModos.layoutY = 384.0
            volver.layoutY = 413.0
            entrar.layoutY = 413.0
            imgModos.layoutY = 95.0
            imgCadena.layoutY = 95.0
            pane.prefHeight = 466.0
            stageMenuMundos.height = 466.0

        }

        scope.launch {
            delay(3000)
            Platform.runLater {
                mensajeError.isVisible = false

                atras.layoutY = 330.0
                siguiente.layoutY = 330.0
                textoModos.layoutY = 354.0
                volver.layoutY = 383.0
                entrar.layoutY = 383.0
                imgModos.layoutY = 65.0
                imgCadena.layoutY = 65.0
                pane.prefHeight = 436.0
                stageMenuMundos.height = 436.0

                animacionEnCurso = false
            }
        }
    }

    override fun setStage(stage: Stage?) {
        stageMenuMundos = stage!!
    }
    override fun setBoton(b: Button?) {}
}