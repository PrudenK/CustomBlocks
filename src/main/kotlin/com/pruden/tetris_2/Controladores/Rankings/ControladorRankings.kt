package com.pruden.tetris_2.Controladores.Rankings

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarPartida
import com.pruden.tetris_2.BaseDeDatos.Objs.JugadorRanking
import com.pruden.tetris_2.Metodos.RankingVistaDatos.initRankingDatos
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorRankings: ControladorGEN(), Initializable {
    lateinit var stageRankings : Stage

    @FXML lateinit var tableView: TableView<JugadorRanking>

    @FXML lateinit var nombre: TableColumn<JugadorRanking, String>
    @FXML lateinit var nivelUser: TableColumn<JugadorRanking, Int>
    @FXML lateinit var nivelPartida: TableColumn<JugadorRanking, Int>
    @FXML lateinit var lineas: TableColumn<JugadorRanking, Int>
    @FXML lateinit var puntu: TableColumn<JugadorRanking, Int>
    @FXML lateinit var tiempoPartida: TableColumn<JugadorRanking, String>
    @FXML lateinit var pais: TableColumn<JugadorRanking, String>

    @FXML lateinit var comboModo: ComboBox<String>
    @FXML lateinit var comboPais: ComboBox<String>

    lateinit var datosRanking: ObservableList<JugadorRanking>

    companion object{
        lateinit var cRanking : ControladorRankings
    }
    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cRanking = this
        initRankingDatos()
    }

    @FXML fun volver(){
        reanudarPartida()
        stageRankings.close()
    }


    override fun setStage(stage: Stage?) {
        stageRankings = stage!!
    }

    override fun setBoton(b: Button?) {
    }
}