package com.pruden.tetris_2.Metodos.Observables

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES_B
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LINEAS_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.REDUCCION_TIEMPO_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TIEMPO_CAIDA_PIEZAS_INICIAL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.holdActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.rotacionesActuales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.siguientesPiezaActivo
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOpciones
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOtrasConfiguraciones.Companion.activarHoldGuardar
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOtrasConfiguraciones.Companion.activarSiguientesPiezasB
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOtrasConfiguraciones.Companion.guardar_valores_otras_confi
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOtrasConfiguraciones.Companion.limiteRotaciones
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOtrasConfiguraciones.Companion.rotaciones
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOtrasConfiguraciones.Companion.saltoNivel
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOtrasConfiguraciones.Companion.saltoTiempoNivel
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOtrasConfiguraciones.Companion.stageOtrasConfi
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOtrasConfiguraciones.Companion.tiempoCaida

import javafx.beans.property.SimpleBooleanProperty

fun cargarObservableOtrasConfi(){
    guardar_valores_otras_confi = SimpleBooleanProperty(false)

    guardar_valores_otras_confi.addListener{ _, _, newValue ->
        if (newValue) {
            TIEMPO_CAIDA_PIEZAS_INICIAL = tiempoCaida
            LINEAS_POR_NIVEL = saltoNivel
            REDUCCION_TIEMPO_POR_NIVEL = saltoTiempoNivel
            LIMITE_ROTACIONES_B = limiteRotaciones
            LIMITE_ROTACIONES = rotaciones
            rotacionesActuales = LIMITE_ROTACIONES

            holdActivo = activarHoldGuardar
            siguientesPiezaActivo = activarSiguientesPiezasB

            ControladorCustomOpciones.cambioOtrasConfi = true
            stageOtrasConfi.close()
        }
    }
}