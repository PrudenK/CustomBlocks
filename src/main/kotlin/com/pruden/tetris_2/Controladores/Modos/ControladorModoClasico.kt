package com.pruden.tetris_2.Controladores.Modos

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.COLUMNAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.FILAS
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LIMITE_ROTACIONES_B
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.LINEAS_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.REDUCCION_TIEMPO_POR_NIVEL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TAMANO_CELDA
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TIEMPO_CAIDA_PIEZAS_INICIAL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.holdActivo
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.rotacionesActuales
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.siguientesPiezaActivo
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomOtrasConfiguraciones
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas.Companion.listaPiezasSeleccionadas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaNumColumnas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaNumFilas
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomTablero.Companion.listaTamaCelda
import com.pruden.tetris_2.Controladores.Modos.ControladorModosJuego.Companion.modoClasico
import com.pruden.tetris_2.Controladores.Modos.ControladorModosJuego.Companion.stageModos
import com.pruden.tetris_2.Metodos.Modos.ModoDeJuego
import com.pruden.tetris_2.Metodos.Modos.cargarCambiosModo
import com.pruden.tetris_2.Metodos.Modos.cargarPosicionesPiezasModos
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.Stage

class ControladorModoClasico : ControladorGEN(){
    private lateinit var stage : Stage
    private lateinit var cPrincipal : ControladorPrincipal

    @FXML private fun salir(){
        stage.close()
    }

    @FXML private fun guardar(){
        cargarCambiosModo(modoClasico)
        cPrincipal.partdiaNueva()
        stage.close()
        stageModos.close()
    }

    override fun setStage(stage: Stage?) {
        this.stage = stage!!
    }
    override fun setBoton(b: Button?) {}
    override fun setControladorPrincipal(principal: ControladorPrincipal?) {
        cPrincipal = principal!!
    }
}