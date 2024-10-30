package com.pruden.tetris_2.Controladores.Modos

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.TIEMPO_CAIDA_PIEZAS_INICIAL
import com.pruden.tetris_2.Controladores.Custom.ControladorCustomPiezas.Companion.listaPiezasSeleccionadas
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
    private lateinit var stage: Stage
    private lateinit var cPrincipal : ControladorPrincipal
    private lateinit var elemento : Button

    var posicionesModoClasico : IntArray = intArrayOf(0, 1, 2, 3, 4, 5, 6)
    var posicionesModoClasicoV2 : IntArray = intArrayOf(10, 12, 13, 17, 18, 22)
    var posicionesModoAlgebra : IntArray = intArrayOf(3, 8, 13, 14, 20, 28)
    var posicionesRapido : IntArray = intArrayOf(0, 17, 24, 29)

    val listaPiezas = ArrayList(List(32) { false })
    val listaPiezasTodas = ArrayList(List(32) { true })

    val TIEMPO_CAIDA_INICIAL_CONST = 1500

    override fun initialize(location: URL?, resources: ResourceBundle?) {

    }


    @FXML private fun volver() {
        stage.close()
    }

    @FXML private fun clasico() {
        cargarPosiciones(listaPiezas, posicionesModoClasico)
        TIEMPO_CAIDA_PIEZAS_INICIAL= TIEMPO_CAIDA_INICIAL_CONST
        crearStage(ClaseStage("Vistas/Modos/vista_Modo_Clasico.fxml", elemento,700.0,820.0, null,0, 0))
    }

    @FXML private fun clasicoV2() {
        cargarPosiciones(listaPiezas, posicionesModoClasicoV2)
        TIEMPO_CAIDA_PIEZAS_INICIAL= TIEMPO_CAIDA_INICIAL_CONST
    }

    @FXML private fun todo() {
        listaPiezasSeleccionadas = listaPiezasTodas
        TIEMPO_CAIDA_PIEZAS_INICIAL= TIEMPO_CAIDA_INICIAL_CONST
    }


    @FXML private fun algebra() {
        cargarPosiciones(listaPiezas, posicionesModoAlgebra)
        TIEMPO_CAIDA_PIEZAS_INICIAL= TIEMPO_CAIDA_INICIAL_CONST
    }

    @FXML private fun rapido() {
        cargarPosiciones(listaPiezas, posicionesRapido)
        TIEMPO_CAIDA_PIEZAS_INICIAL= 500
    }

    private fun cargarPosiciones(lista : ArrayList<Boolean>, posiciones : IntArray){
        for (pos in posiciones){
            lista[pos] = true
        }
        listaPiezasSeleccionadas = listaPiezas
    }


    override fun setStage(stage: Stage?) {
        this.stage = stage!!
    }

    override fun setBoton(b: Button?) {
        elemento = b!!
    }

    override fun setControladorPrincipal(principal: ControladorPrincipal?) {
        cPrincipal = principal!!
    }
}