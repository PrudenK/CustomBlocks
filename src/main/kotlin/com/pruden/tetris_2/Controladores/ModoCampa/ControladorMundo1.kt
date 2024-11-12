package com.pruden.tetris_2.Controladores.ModoCampa

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Metodos.ModoCampa.Nivel
import com.pruden.tetris_2.Metodos.ModoCampa.CargarNivel.cargarStageCargaYNivel
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorMundo1 : ControladorGEN(), Initializable {
    lateinit var stageMundo1 : Stage
    @FXML lateinit var volverB: Button

    val nivel1_1 = Nivel("Mundo 1, Nivel 1",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1500, 2, 100, false,
        -1, true, 1, true, 1, false, 4000, "/0:04:00", 20, 10)

    val nivel1_2 =  Nivel("Mundo 1, Nivel 2",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1400, 2, 100, false,
        -1, true, 1, true, 1, false, 5000, "/0:03:30", 20, 10)

    val nivel1_3 =  Nivel("Mundo 1, Nivel 3",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1200, 3, 100, false,
        -1, true, 1, true, 1, false, 6500, "/0:03:00", 24, 8)

    val nivel1_4 =  Nivel("Mundo 1, Nivel 4",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1300, 3, 100, false,
        -1, true, 0, true, 1, false, 4000, "/0:02:00", 18, 6)

    val nivel1_5 =  Nivel("Mundo 1, Nivel 5",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1200, 5, 100, false,
        -1, true, 0, true, 1, false, 5000, "/0:03:00", 25, 5)

    val nivel1_6 =  Nivel("Mundo 1, Nivel 6",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1200, 3, 100, false,
        -1, true, 0, true, 2, false, 2000, "/0:03:00", 15, 5)

    val nivel1_7 =  Nivel("Mundo 1, Nivel 7",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1200, 4, 100, false,
        -1, true, 2, true, 1, true, 8000, "/0:04:00", 16, 4)

    val nivel1_8 =  Nivel("Mundo 1, Nivel 8",intArrayOf(0, 1, 2, 3, 4, 5, 6), 1300, 1, 100, false,
        -1, true, 2, true, 0, true, 5000, "/0:03:30", 10, 10)

    val nivel1_9 =  Nivel("Mundo 1, Nivel 8",intArrayOf(0, 1, 17, 22, 27), 1500, 4, 100, false,
        -1, true, 2, true, 1, true, 12000, "/0:04:30", 24, 6)

    companion object{
        lateinit var cMundo1: ControladorMundo1
    }


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cMundo1 = this
    }

    @FXML fun nivel1_1F() = cargarStageCargaYNivel(nivel1_1, stageMundo1)
    @FXML fun nivel1_2F() = cargarStageCargaYNivel(nivel1_2, stageMundo1)
    @FXML fun nivel1_3F() = cargarStageCargaYNivel(nivel1_3, stageMundo1)
    @FXML fun nivel1_4F() = cargarStageCargaYNivel(nivel1_4, stageMundo1)
    @FXML fun nivel1_5F() = cargarStageCargaYNivel(nivel1_5, stageMundo1)
    @FXML fun nivel1_6F() = cargarStageCargaYNivel(nivel1_6, stageMundo1)
    @FXML fun nivel1_7F() = cargarStageCargaYNivel(nivel1_7, stageMundo1)
    @FXML fun nivel1_8F() = cargarStageCargaYNivel(nivel1_8, stageMundo1)
    @FXML fun nivel1_9F() = cargarStageCargaYNivel(nivel1_9, stageMundo1)


    @FXML fun volver(){
        stageMundo1.close()
    }


    override fun setStage(stage: Stage?) {
        stageMundo1 = stage!!
    }

    override fun setBoton(b: Button?) {
    }
}