package com.pruden.tetris_2.Controladores.Rankings

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Metodos.RankingVistaDatos.Jugador
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

    @FXML lateinit var tableView: TableView<Jugador>

    @FXML lateinit var nombre: TableColumn<Jugador, String>
    @FXML lateinit var nivelUser: TableColumn<Jugador, Int>
    @FXML lateinit var nivelPartida: TableColumn<Jugador, Int>
    @FXML lateinit var lineas: TableColumn<Jugador, Int>
    @FXML lateinit var puntu: TableColumn<Jugador, Int>
    @FXML lateinit var tiempoPartida: TableColumn<Jugador, String>
    @FXML lateinit var pais: TableColumn<Jugador, String>

    @FXML lateinit var comboModo: ComboBox<String>
    @FXML lateinit var comboPais: ComboBox<String>

    lateinit var datosRanking: ObservableList<Jugador>

    companion object{
        lateinit var cRanking : ControladorRankings
    }
    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cRanking = this
        initRankingDatos()
    }

    @FXML fun volver(){
        stageRankings.close()
    }


    override fun setStage(stage: Stage?) {
        stageRankings = stage!!
    }

    override fun setBoton(b: Button?) {
    }
    override fun setControladorPrincipal(principal: ControladorPrincipal?) {
    }
}