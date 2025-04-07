package com.pruden.tetris_2.Controladores.ModosDeJuego.PVP

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.ObjsAux.PartidaPVPconJugadores
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import javafx.application.Platform
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class ControladorHistorialPVP: ControladorGEN(), Initializable {
    @FXML lateinit var tableView: TableView<PartidaPVPconJugadores>

    @FXML lateinit var host: TableColumn<PartidaPVPconJugadores, String>
    @FXML lateinit var visitante: TableColumn<PartidaPVPconJugadores, String>
    @FXML lateinit var modo: TableColumn<PartidaPVPconJugadores, String>
    @FXML lateinit var resultado: TableColumn<PartidaPVPconJugadores, String>
    @FXML lateinit var fecha: TableColumn<PartidaPVPconJugadores, String>

    private lateinit var datosPartidasPVP: ObservableList<PartidaPVPconJugadores>

    companion object{
        lateinit var stageHistorialPVP: Stage
    }

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        tableView.columnResizePolicy = TableView.CONSTRAINED_RESIZE_POLICY
        datosPartidasPVP = FXCollections.observableArrayList()




        CoroutineScope(Dispatchers.IO).launch {
            val partidas = ApiCustom.partidaService.getPartidasPVPporUsuario(ControladorPrincipal.jugadorConTodo!!.id)

            println(partidas)

            Platform.runLater{
                for (p in partidas){
                    datosPartidasPVP.add(p)
                }
            }

            host.cellValueFactory = PropertyValueFactory("host")
            visitante.cellValueFactory = PropertyValueFactory("visitante")
            modo.cellValueFactory = PropertyValueFactory("modo")
            resultado.cellValueFactory = PropertyValueFactory("resultado")
            fecha.cellValueFactory = PropertyValueFactory("fecha")

            tableView.items = datosPartidasPVP
        }
    }

    @FXML fun volver(){
        stageHistorialPVP.close()
    }

    override fun setStage(stage: Stage?) {
        stageHistorialPVP = stage!!
    }
    override fun setBoton(b: Button?) {}
}