package com.pruden.tetris_2.Controladores.Modos

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TIEMPO_CAIDA_PIEZAS_INICIAL
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.hasPerdido
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas.Companion.listaPiezasSeleccionadas
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarTimeline
import com.pruden.tetris_2.Metodos.Modos.ModoDeJuego
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.stage.Stage
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList


class ControladorModosJuego : ControladorGEN(), Initializable {
    private lateinit var cPrincipal : ControladorPrincipal
    private lateinit var elemento : Button
    companion object{
        lateinit var stageModos: Stage

        val modoClasico = ModoDeJuego(intArrayOf(0, 1, 2, 3, 4, 5, 6), 1500, 10,
            100, false, -1, true, 1, true)
        val modoClasicoV2 = ModoDeJuego(intArrayOf(10, 12, 13, 17, 18, 22, 30), 1500, 10,
            100, false, -1, true, 1, true)
        val modoTodo = ModoDeJuego(IntArray(32) { it }, 1500, 10,
            100, false, -1, true, 2, true)
        val modoAlgebra = ModoDeJuego(intArrayOf(3, 8, 13, 14, 20, 28), 1800, 5,
            100, true, 4, true, 1, true)
        val modoRapidO  = ModoDeJuego(intArrayOf(0, 17, 24, 29), 500, 5,
            50, false, -1, true, 0, true)
    }
    override fun initialize(location: URL?, resources: ResourceBundle?) {

    }


    @FXML private fun volver() {
        if (!hasPerdido) {
            ControladorPrincipal.cronometro.reanudar()
            reanudarTimeline()
        }
        stageModos.close()
    }

    @FXML private fun clasico() {
        crearStage(ClaseStage("Vistas/Modos/vista_Modo_Clasico.fxml", elemento,700.0,820.0, null,0, 0))
    }

    @FXML private fun clasicoV2() {
        crearStage(ClaseStage("Vistas/Modos/vista_Modo_ClasicoV2.fxml", elemento,700.0,820.0, null,0, 0))
    }

    @FXML private fun todo() {
        crearStage(ClaseStage("Vistas/Modos/vista_Modo_Todo.fxml", elemento,700.0,820.0, null,0, 0))
    }

    @FXML private fun algebra() {
        crearStage(ClaseStage("Vistas/Modos/vista_Modo_Algebra.fxml", elemento,700.0,820.0, null,0, 0))
    }

    @FXML private fun rapido() {
        crearStage(ClaseStage("Vistas/Modos/vista_Modo_RapidO.fxml", elemento,700.0,820.0, null,0, 0))
    }

    override fun setStage(stage: Stage?) {
        stageModos = stage!!
    }

    override fun setBoton(b: Button?) {
        elemento = b!!
    }

    override fun setControladorPrincipal(principal: ControladorPrincipal?) {
        cPrincipal = principal!!
    }
}