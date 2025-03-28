package com.pruden.tetris_2.Controladores.Custom

import com.pruden.tetris_2.Constantes.Configuraciones
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES_B
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LINEAS_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.REDUCCION_TIEMPO_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TIEMPO_CAIDA_PIEZAS_INICIAL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
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
    
    companion object{
        lateinit var stageOtrasConfi: Stage

        lateinit var guardarValoresOtrasConfi: BooleanProperty

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


    @FXML fun volver() {
        stageOtrasConfi.close()
    }

    @FXML fun guardar() {
        crearStage(ClaseStage("Vistas/Advertencias/vista_Advertencia_Otras_Confi.fxml",
            cPrin.nuevaPartidaB, 344.0, 178.0,null,0,0))
    }

    @FXML fun reestablecer() {
        activarLimite.text = "Sin límite"
        masLimiteRotacionesB.isDisable = true
        menosLimiteRotacionesB.isDisable = true
        labelLimiteRotaciones.text = "SIN"
        limiteRotaciones = false

        tiempoCaida = 1500
        saltoNivel = 10
        saltoTiempoNivel = 100

        labelTiempoCaidaInicial.text = tiempoCaida.toString() + Configuraciones.MS
        labelLinesSaltoNivel.text = saltoNivel.toString()
        labelSaltoTiempoNivel.text = saltoTiempoNivel.toString() + Configuraciones.MS

        activarHoldB.text = "Activo"
        siguientesPiezasB.text = "Activo"
        activarDashButton.text = "Desactivado"

        activarSiguientesPiezasB = true
        activarHoldGuardar = true
        activarDashes = false
    }

    @FXML fun menosTiempoCaidaInicial() {
        if (tiempoCaida > Configuraciones.TIEMPO_MINIMO_CAIDA) {
            tiempoCaida -= Configuraciones.SALTO_TIEMPO_CAIDA
            labelTiempoCaidaInicial.text = tiempoCaida.toString() + Configuraciones.MS
        }
    }

    @FXML fun masTiempoCaidaInicial() {
        if (tiempoCaida < Configuraciones.TIEMPO_MAXIMO_CAIDA) {
            tiempoCaida += Configuraciones.SALTO_TIEMPO_CAIDA
            labelTiempoCaidaInicial.text = tiempoCaida.toString() + Configuraciones.MS
        }
    }

    @FXML fun menosLinesSaltoNivel() {
        if (saltoNivel > Configuraciones.LINEAS_SALTO_NIVEL_MINIMO) {
            saltoNivel -= Configuraciones.SALTO_LINEAS_SALTO_NIVEL
            labelLinesSaltoNivel.text = saltoNivel.toString()
        }
    }

    @FXML fun masLinesSaltoNivel() {
        if (saltoNivel < Configuraciones.LINEAS_SALTO_NIVEL_MAXIMO) {
            saltoNivel += Configuraciones.SALTO_LINEAS_SALTO_NIVEL
            labelLinesSaltoNivel.text = saltoNivel.toString()
        }
    }

    @FXML fun menosSaltoTiempoNivel() {
        if (saltoTiempoNivel > Configuraciones.SALTO_TIEMPO_NIVEL_MINIMO) {
            saltoTiempoNivel -= Configuraciones.SALTO_SALTO_TIEMPO_NIVEL
            labelSaltoTiempoNivel.text = saltoTiempoNivel.toString() + Configuraciones.MS
        }
    }

    @FXML fun masSaltoTiempoNivel() {
        if (saltoTiempoNivel < Configuraciones.SALTO_TIEMPO_NIVEL_MAXIMO) {
            saltoTiempoNivel += Configuraciones.SALTO_SALTO_TIEMPO_NIVEL
            labelSaltoTiempoNivel.text = saltoTiempoNivel.toString() + Configuraciones.MS
        }
    }

    @FXML fun menosLimiteRotaciones() {
        if (rotaciones > Configuraciones.LIMITE_ROTACIONES_MINIMO) {
            rotaciones -= Configuraciones.SALTO_ROTACIONES
            labelLimiteRotaciones.text = rotaciones.toString()
        }
    }

    @FXML fun masLimiteRotaciones() {
        if (rotaciones < Configuraciones.LIMITE_ROTACIONES_MAXIMO) {
            rotaciones += Configuraciones.SALTO_ROTACIONES
            labelLimiteRotaciones.text = rotaciones.toString()
        }
    }

    @FXML fun limiteB() {
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

    @FXML fun activarHold() {
        if (activarHoldB.text == "Activo") {
            activarHoldB.text = "Desactivado"
            activarHoldGuardar = false
        } else {
            activarHoldB.text = "Activo"
            activarHoldGuardar = true
        }
    }

    @FXML fun siguientesPiezas() {
        if (siguientesPiezasB.text == "Activo") {
            siguientesPiezasB.text = "Desactivado"
            activarSiguientesPiezasB = false
        } else {
            siguientesPiezasB.text = "Activo"
            activarSiguientesPiezasB = true
        }
    }

    @FXML fun activarDashes(){
        if (activarDashButton.text == "Activo"){
            activarDashButton.text = "Desactivado"
            activarDashes = false
        }else{
            activarDashButton.text = "Activo"
            activarDashes = true
        }
    }

    private fun cargarValoresInit(){
        labelTiempoCaidaInicial.text = TIEMPO_CAIDA_PIEZAS_INICIAL.toString() + Configuraciones.MS
        labelLinesSaltoNivel.text = LINEAS_POR_NIVEL.toString()
        labelSaltoTiempoNivel.text = REDUCCION_TIEMPO_POR_NIVEL.toString() + Configuraciones.MS

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