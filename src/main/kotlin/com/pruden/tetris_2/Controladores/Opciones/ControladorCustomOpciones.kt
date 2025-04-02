package com.pruden.tetris_2.Controladores.Opciones

import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarPartida
import com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.cambiarLabelsAlSalirDelModoCampa
import com.pruden.tetris_2.Metodos.Observables.cambiosTipoTablero
import com.pruden.tetris_2.Metodos.Observables.cambiosTipoTableroSecundario
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.beans.property.BooleanProperty
import javafx.beans.property.SimpleBooleanProperty
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorCustomOpciones : ControladorGEN(), Initializable{
    @FXML lateinit var tablero: Button

    private lateinit var elemnto : Button
    private lateinit var stageCustomOpciones: Stage

    companion object{
        var cambioPiezas = false
        var cambioTablero = false
        var cambioOtrasConfi = false
        var cambioTipoTablero = false
        var cambioTipoTableroSinReiniciar = false
        var cambioTipoTableroSinReiniciarSecundario = false
        var haGuardadoTipoTablero = false
        lateinit var cerrarYGuardarCambio : BooleanProperty
    }


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cronometro.parar()
        cerrarYGuardarCambio = SimpleBooleanProperty(false)

        cerrarYGuardarCambio.addListener { _, _, newValue ->
            if (newValue) {
                cambiasAlCerrar()
                cerrarYGuardarCambio.set(false)
            }
        }
    }

    @FXML fun volver() {
        cambiasAlCerrar()
        stageCustomOpciones.close()
    }


    private fun cambiasAlCerrar(){


        if (cambioPiezas || cambioTablero || cambioOtrasConfi || cambioTipoTablero){
            cPrin.labelModo.text = "Custom"


            cambiarLabelsAlSalirDelModoCampa()

            cPrin.partdiaNueva()
        }else{
            if(haGuardadoTipoTablero) {
                if (cambioTipoTableroSinReiniciar) {
                    cambiosTipoTablero()
                }
                if (cambioTipoTableroSinReiniciarSecundario) {
                    cambiosTipoTableroSecundario()
                    cambioTipoTableroSinReiniciarSecundario = false
                }
                haGuardadoTipoTablero = false
            }
            reanudarPartida()
        }



        cambioPiezas = false
        cambioOtrasConfi = false

    }





    @FXML fun customPiezas() {
        crearStage(Stages.CUSTOM_PIEZAS)
    }

    @FXML fun tipoPiezas() {
        crearStage(Stages.CUSTOM_TIPO_PIEZAS)
    }

    @FXML fun tablero() {
        crearStage(Stages.CUSTOM_TABLERO)
    }

    @FXML fun tipoTablero() {
        crearStage(Stages.CUSTOM_TIPO_TABLERO)
    }

    @FXML fun otrasConfiguraciones() {
        crearStage(Stages.CUSTOM_OTRAS_CONFIGURACIONES)
    }















    override fun setStage(stage: Stage?) {
        stageCustomOpciones = stage!!
    }

    override fun setBoton(b: Button?) {
        elemnto = b!!
    }
}