package com.pruden.tetris_2.Controladores.Opciones

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cronometro
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.hasPerdido
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarPartida
import com.pruden.tetris_2.Metodos.Timelines.reanudarTimeline
import com.pruden.tetris_2.Metodos.Modos.ModoDeJuego
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.stage.Stage
import java.net.URL
import java.util.*


class ControladorModosJuego : ControladorGEN(), Initializable {
    private lateinit var elemento : Button
    companion object{
        lateinit var stageModos: Stage

        val modoClasico = ModoDeJuego("Clásico",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1500, 10,
            100, false, -1, true, 1, true, 1,false)
        val modoClasicoV2 = ModoDeJuego("Clásico v2",intArrayOf(10, 12, 13, 17, 18, 22, 30), 1500, 10,
            100, false, -1, true, 1, true, 1, false)
        val modoAllIn = ModoDeJuego("All in",IntArray(32) { it }, 1500, 10,
            100, false, -1, true, 2, true, 1, true)
        val modoAlgebra = ModoDeJuego("Algebra",intArrayOf(3, 8, 13, 14, 20, 28), 1800, 5,
            100, true, 4, true, 1, true, 1, false)
        val modoRapidO  = ModoDeJuego("RapidO",intArrayOf(0, 17, 24, 29), 500, 5,
            50, false, -1, true, 0, true,1, true)
        val modoMemory  = ModoDeJuego("Memory",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1500, 10,
            100, false, -1, true, 1, true, 2, false)
        val modoMemoryX  = ModoDeJuego("MemoryX",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1500, 10,
            100, false, -1, true, 1, true, 3, false)
        val modoMemoryY  = ModoDeJuego("MemoryY",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1500, 10,
            100, false, -1, true, 1, true, 4, false)
    }
    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cronometro.parar()
    }


    @FXML fun volver() {
        reanudarPartida()
        stageModos.close()
    }

    @FXML fun clasico() {
        crearStage(ClaseStage("Vistas/Modos/vista_Modo_Clasico.fxml", elemento,700.0,820.0, null,0, 0))
    }

    @FXML fun clasicoV2() {
        crearStage(ClaseStage("Vistas/Modos/vista_Modo_ClasicoV2.fxml", elemento,700.0,820.0, null,0, 0))
    }

    @FXML fun todo() {
        crearStage(ClaseStage("Vistas/Modos/vista_Modo_Todo.fxml", elemento,700.0,820.0, null,0, 0))
    }

    @FXML fun algebra() {
        crearStage(ClaseStage("Vistas/Modos/vista_Modo_Algebra.fxml", elemento,700.0,820.0, null,0, 0))
    }

    @FXML fun rapido() {
        crearStage(ClaseStage("Vistas/Modos/vista_Modo_RapidO.fxml", elemento,700.0,820.0, null,0, 0))
    }

    @FXML fun memory() {
        crearStage(ClaseStage("Vistas/Modos/vista_Modo_Memory.fxml", elemento,700.0,820.0, null,0, 0))
    }

    @FXML fun memoryX() {
        crearStage(ClaseStage("Vistas/Modos/vista_Modo_MemoryX.fxml", elemento,700.0,820.0, null,0, 0))
    }

    @FXML fun memoryY() {
        crearStage(ClaseStage("Vistas/Modos/vista_Modo_MemoryY.fxml", elemento,700.0,820.0, null,0, 0))
    }

    override fun setStage(stage: Stage?) {
        stageModos = stage!!
    }

    override fun setBoton(b: Button?) {
        elemento = b!!
    }
}