package com.pruden.tetris_2.Controladores.Opciones

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarPartida
import com.pruden.tetris_2.Metodos.ModosDeJuego.ModoCampa.cambiarLabelsAlSalirDelModoCampa
import com.pruden.tetris_2.Metodos.Observables.cambiosTipoTablero
import com.pruden.tetris_2.Metodos.Observables.cambiosTipoTableroSecundario
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
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

    @FXML private fun volver() {
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





    @FXML private fun customPiezas() {
        crearStage(ClaseStage("Vistas/Custom/vista_Custom_Piezas.fxml",elemnto,700.0,820.0, null,0, 0))
    }

    @FXML private fun tipoPiezas() {
        crearStage(ClaseStage("Vistas/Custom/vista_Custom_Tipo_Piezas.fxml", elemnto,315.0,400.0, null,0, -60))
    }

    @FXML private fun tablero() {
        crearStage(ClaseStage("Vistas/Custom/vista_Custom_Tablero.fxml", elemnto,431.0,582.0, null,0, -40))
    }

    @FXML private fun tipoTablero() {
        crearStage(ClaseStage("Vistas/Custom/vista_Custom_Tipo_Tablero.fxml", elemnto,570.0,501.0, null,0, -20))
    }

    @FXML private fun otrasConfiguraciones() {
        crearStage(ClaseStage("Vistas/Custom/vista_Custom_Otras_Configuraciones.fxml", elemnto,643.0,491.0, null,0, -20))
    }















    override fun setStage(stage: Stage?) {
        stageCustomOpciones = stage!!
    }

    override fun setBoton(b: Button?) {
        elemnto = b!!
    }
}