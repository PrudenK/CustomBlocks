package com.pruden.tetris_2.Controladores.Partidas

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Metodos.IniciarPartida.reanudarPartida
import com.pruden.tetris_2.Metodos.PartidaVistaDatos.Partida
import com.pruden.tetris_2.Metodos.PartidaVistaDatos.initPartidaDatos
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.*
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorPartidas: ControladorGEN(), Initializable {
    lateinit var stagePartidas : Stage
    @FXML lateinit var tableView: TableView<Partida>

    @FXML lateinit var modo: TableColumn<Partida, String>
    @FXML lateinit var nivel: TableColumn<Partida, Int>
    @FXML lateinit var puntu: TableColumn<Partida, Int>
    @FXML lateinit var tiempo: TableColumn<Partida, String>
    @FXML lateinit var lineas: TableColumn<Partida, Int>
    @FXML lateinit var fecha: TableColumn<Partida, String>

    @FXML lateinit var comboFiltrar: ComboBox<String>
    @FXML lateinit var comboOrdenar: ComboBox<String>

    lateinit var datosPartida: ObservableList<Partida>

    companion object{
        lateinit var cPartidas : ControladorPartidas
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cPartidas = this
        initPartidaDatos()
    }

    @FXML fun volver(){
        reanudarPartida()
        stagePartidas.close()
    }


    override fun setStage(stage: Stage?) {
        stagePartidas = stage!!
    }

    override fun setBoton(b: Button?) {

    }
}