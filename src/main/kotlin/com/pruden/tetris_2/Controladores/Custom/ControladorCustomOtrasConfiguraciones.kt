package com.pruden.tetris_2.Controladores.Custom

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES_B
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LINEAS_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.REDUCCION_TIEMPO_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TIEMPO_CAIDA_PIEZAS_INICIAL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.dashActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.holdActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.siguientesPiezaActivo
import com.pruden.tetris_2.Metodos.Observables.cargarObservableOtrasConfi
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.beans.property.BooleanProperty
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorCustomOtrasConfiguraciones : ControladorGEN(), Initializable {
    @FXML private lateinit var activarLimite: Button
    @FXML private lateinit var menosLimiteRotacionesB: Button
    @FXML private lateinit var masLimiteRotacionesB: Button
    @FXML private lateinit var activarHoldB: Button
    @FXML private lateinit var siguientesPiezasB: Button
    @FXML private lateinit var activarDashButton: Button

    @FXML private lateinit var labelTiempoCaidaInicial: Label
    @FXML private lateinit var labelLinesSaltoNivel: Label
    @FXML private lateinit var labelSaltoTiempoNivel: Label
    @FXML private lateinit var labelLimiteRotaciones: Label

    private val TIEMPO_MAXIMO_CAIDA = 3000
    private val TIEMPO_MINIMO_CAIDA = 50

    private val LINEAS_SALTO_NIVEL_MINIMO = 1
    private val LINEAS_SALTO_NIVEL_MAXIMO = 99

    private val SALTO_TIEMPO_NIVEL_MINIMO = 50
    private val SALTO_TIEMPO_NIVEL_MAXIMO = 500

    private val LIMITE_ROTACIONES_MINIMO = 0
    private val LIMITE_ROTACIONES_MAXIMO = 10

    private val SALTO_TIEMPO_CAIDA = 50
    private val SALTO_LINEAS_SALTO_NIVEL = 1
    private val SALTO_SALTO_TIEMPO_NIVEL = 50
    private val SALTO_ROTACIONES = 1

    companion object{
        lateinit var stageOtrasConfi: Stage

        lateinit var guardar_valores_otras_confi: BooleanProperty

        var tiempoCaida = 0
        var saltoNivel = 0
        var saltoTiempoNivel = 0
        var rotaciones = 0
        var limiteRotaciones = false
        var activarSiguientesPiezasB = false
        var activarHoldGuardar = false
        var activarDashes = false
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cargarValoresInit()
        cargarObservableOtrasConfi()
    }


    @FXML private fun volver() {
        stageOtrasConfi.close()
    }

    @FXML private fun guardar() {
        crearStage(ClaseStage("Vistas/Advertencias/vista_Advertencia_Otras_Confi.fxml",activarLimite, 370.0, 210.0,null,0,0))
    }

    @FXML private fun reestablecer() {
        activarLimite.text = "Sin límite"
        masLimiteRotacionesB.isDisable = true
        menosLimiteRotacionesB.isDisable = true
        labelLimiteRotaciones.text = "SIN"
        limiteRotaciones = false

        tiempoCaida = 1500
        saltoNivel = 10
        saltoTiempoNivel = 100

        labelTiempoCaidaInicial.text = tiempoCaida.toString()
        labelLinesSaltoNivel.text = saltoNivel.toString()
        labelSaltoTiempoNivel.text = saltoTiempoNivel.toString()

        activarHoldB.text = "Activo"
        siguientesPiezasB.text = "Activo"
        activarDashButton.text = "Desactivado"

        activarSiguientesPiezasB = true
        activarHoldGuardar = true
        activarDashes = false
    }

    @FXML private fun menosTiempoCaidaInicial() {
        if (tiempoCaida > TIEMPO_MINIMO_CAIDA) {
            tiempoCaida -= SALTO_TIEMPO_CAIDA
            labelTiempoCaidaInicial.text = tiempoCaida.toString()
        }
    }

    @FXML private fun masTiempoCaidaInicial() {
        if (tiempoCaida < TIEMPO_MAXIMO_CAIDA) {
            tiempoCaida += SALTO_TIEMPO_CAIDA
            labelTiempoCaidaInicial.text = tiempoCaida.toString()
        }
    }

    @FXML private fun menosLinesSaltoNivel() {
        if (saltoNivel > LINEAS_SALTO_NIVEL_MINIMO) {
            saltoNivel -= SALTO_LINEAS_SALTO_NIVEL
            labelLinesSaltoNivel.text = saltoNivel.toString()
        }
    }

    @FXML private fun masLinesSaltoNivel() {
        if (saltoNivel < LINEAS_SALTO_NIVEL_MAXIMO) {
            saltoNivel += SALTO_LINEAS_SALTO_NIVEL
            labelLinesSaltoNivel.text = saltoNivel.toString()
        }
    }

    @FXML private fun menosSaltoTiempoNivel() {
        if (saltoTiempoNivel > SALTO_TIEMPO_NIVEL_MINIMO) {
            saltoTiempoNivel -= SALTO_SALTO_TIEMPO_NIVEL
            labelSaltoTiempoNivel.text = saltoTiempoNivel.toString()
        }
    }

    @FXML private fun masSaltoTiempoNivel() {
        if (saltoTiempoNivel < SALTO_TIEMPO_NIVEL_MAXIMO) {
            saltoTiempoNivel += SALTO_SALTO_TIEMPO_NIVEL
            labelSaltoTiempoNivel.text = saltoTiempoNivel.toString()
        }
    }

    @FXML private fun menosLimiteRotaciones() {
        if (rotaciones > LIMITE_ROTACIONES_MINIMO) {
            rotaciones -= SALTO_ROTACIONES
            labelLimiteRotaciones.text = rotaciones.toString()
        }
    }

    @FXML private fun masLimiteRotaciones() {
        if (rotaciones < LIMITE_ROTACIONES_MAXIMO) {
            rotaciones += SALTO_ROTACIONES
            labelLimiteRotaciones.text = rotaciones.toString()
        }
    }

    @FXML private fun limiteB() {
        if (limiteRotaciones) {
            activarLimite.text = "Sin límite"
            masLimiteRotacionesB.isDisable = true
            menosLimiteRotacionesB.isDisable = true
            limiteRotaciones = false
            labelLimiteRotaciones.text = "SIN"
        } else {
            activarLimite.text = "Con límite"
            masLimiteRotacionesB.isDisable = false
            menosLimiteRotacionesB.isDisable = false
            limiteRotaciones = true
            labelLimiteRotaciones.text = rotaciones.toString()
        }
    }

    @FXML private fun activarHold() {
        if (activarHoldB.text == "Activo") {
            activarHoldB.text = "Desactivado"
            activarHoldGuardar = false
        } else {
            activarHoldB.text = "Activo"
            activarHoldGuardar = true
        }
    }

    @FXML private fun siguientesPiezas() {
        if (siguientesPiezasB.text == "Activo") {
            siguientesPiezasB.text = "Desactivado"
            activarSiguientesPiezasB = false
        } else {
            siguientesPiezasB.text = "Activo"
            activarSiguientesPiezasB = true
        }
    }

    @FXML private fun activarDashes(){
        if (activarDashButton.text == "Activo"){
            activarDashButton.text = "Desactivado"
            activarDashes = false
        }else{
            activarDashButton.text = "Activo"
            activarDashes = true
        }
    }

    private fun cargarValoresInit(){
        labelTiempoCaidaInicial.text = TIEMPO_CAIDA_PIEZAS_INICIAL.toString()
        labelLinesSaltoNivel.text = LINEAS_POR_NIVEL.toString()
        labelSaltoTiempoNivel.text = REDUCCION_TIEMPO_POR_NIVEL.toString()

        tiempoCaida = TIEMPO_CAIDA_PIEZAS_INICIAL
        saltoNivel = LINEAS_POR_NIVEL
        saltoTiempoNivel = REDUCCION_TIEMPO_POR_NIVEL

        limiteRotaciones = LIMITE_ROTACIONES_B

        rotaciones = LIMITE_ROTACIONES

        if (rotaciones == 999999999) {
            rotaciones = 0
        }

        if (limiteRotaciones) {
            activarLimite.text = "Con límite"
            masLimiteRotacionesB.isDisable = false
            menosLimiteRotacionesB.isDisable = false
            labelLimiteRotaciones.text = rotaciones.toString()
        } else {
            activarLimite.text = "Sin límite"
            masLimiteRotacionesB.isDisable = true
            menosLimiteRotacionesB.isDisable = true
            labelLimiteRotaciones.text = "SIN"
        }

        activarSiguientesPiezasB = siguientesPiezaActivo
        activarHoldGuardar = holdActivo
        activarDashes = dashActivo

        if (activarSiguientesPiezasB) {
            siguientesPiezasB.text = "Activo"
        } else {
            siguientesPiezasB.text = "Desactivado"
        }

        if(activarHoldGuardar){
            activarHoldB.text = "Activo"
        } else {
            activarHoldB.text = "Desactivado"
        }

        if (activarDashes){
            activarDashButton.text = "Activo"
        }else{
            activarDashButton.text = "Desactivado"
        }
    }

    override fun setStage(stage: Stage?) {
        stageOtrasConfi = stage!!
    }

    override fun setBoton(b: Button?) {}
}