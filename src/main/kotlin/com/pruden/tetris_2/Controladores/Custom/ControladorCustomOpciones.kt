package com.pruden.tetris_2.Controladores.Custom

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.DibujarTablero.General.dibujarTableroPrincipal
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarTimeline
import com.pruden.tetris_2.Metodos.IniciarPartida.setStackpane12x8
import com.pruden.tetris_2.Metodos.IniciarPartida.setStackpane18x10
import com.pruden.tetris_2.Metodos.IniciarPartida.setStackpane30x20
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
    private lateinit var elemnto : Button
    private lateinit var stageCustomOpciones: Stage
    private lateinit var cPrincipal: ControladorPrincipal

    companion object{
        var cambioPiezas = false
        var cambioTablero = false
        var cambioOtrasConfi = false
        lateinit var cerrarYGuardarCambio : BooleanProperty
    }


    override fun initialize(location: URL?, resources: ResourceBundle?) {
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
        if (cambioTablero){
            cPrincipal.cargarTablero()

            matrizNumerica = Array(FILAS + 1) { IntArray(COLUMNAS) }
            dibujarTableroPrincipal()

            if (FILAS == 20) {
                setStackpane18x10()
            } else if (FILAS == 14) {
                setStackpane12x8()
            } else if (FILAS == 32) {
                setStackpane30x20()
            }
        }


        if (cambioPiezas || cambioTablero || cambioOtrasConfi){
            cPrincipal.reiniciarPartida()
        }else{
            reanudarTimeline()
            cronometro.reanudar()
        }

        cambioPiezas = false
        cambioTablero = false
        cambioOtrasConfi = false
    }





    @FXML private fun customPiezas() {
        crearStage(ClaseStage("Vistas/Custom/vista_Custom_Piezas.fxml",elemnto,700.0,820.0, null,0, 0))
    }

    @FXML private fun tipoPiezas() {
        crearStage(ClaseStage("Vistas/Custom/vista_Custom_Tipo_Piezas.fxml", elemnto,315.0,400.0, null,0, -60))
    }

    @FXML private fun tablero() {
        crearStage(ClaseStage("Vistas/Custom/vista_Custom_Tablero.fxml",elemnto,410.0,550.0, null,0, -40))
    }

    @FXML private fun tipoTablero() {
        crearStage(ClaseStage("Vistas/Custom/vista_Custom_Tipo_Tablero.fxml", elemnto,570.0,501.0, null,0, -20))
    }

    @FXML private fun otrasConfiguraciones() {
        crearStage(ClaseStage("Vistas/Custom/vista_Custom_Otras_Configuraciones.fxml", elemnto,600.0,506.0, null,0, -20))
    }















    override fun setStage(stage: Stage?) {
        stageCustomOpciones = stage!!
    }

    override fun setBoton(b: Button?) {
        elemnto = b!!
    }

    override fun setControladorPrincipal(principal: ControladorPrincipal?) {
        cPrincipal = principal!!
    }


}