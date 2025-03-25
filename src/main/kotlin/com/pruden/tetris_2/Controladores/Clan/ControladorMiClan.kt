package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.ObjsAux.Jugador
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idClanDelJugador
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.layout.GridPane
import javafx.scene.layout.Pane
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class ControladorMiClan: ControladorGEN(), Initializable {
    lateinit var stageMiClan: Stage
    @FXML lateinit var gridJugadores: GridPane

    companion object{
        var listaJugadoresDeMiClan = mutableListOf<Jugador>()
    }

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        cargarJugadoresDeUnClanPorId(idClanDelJugador)

        cargarJugadores(listaJugadoresDeMiClan)
    }

    private fun cargarJugadores(jugadores: List<Jugador>) {

        for ((fila, jugador) in jugadores.withIndex()) {
            val loader = FXMLLoader(javaClass.getResource("/com/pruden/tetris_2/Vistas/Clan/jugadorClanItenm.fxml"))
            val item = loader.load<Pane>()
            val controller = loader.getController<ControladorJugadorClan>()
            controller.setJugador(jugador, fila+1)

            gridJugadores.add(item, 0, fila) // siempre columna 0
        }
    }

    private fun cargarJugadoresDeUnClanPorId(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {

            listaJugadoresDeMiClan = ApiCustom.clanService.getJugadoresDeUnClan(id).toMutableList()

            javafx.application.Platform.runLater {
                cargarJugadores(listaJugadoresDeMiClan)
            }
        }
    }


    @FXML fun volver(){
        stageMiClan.close()
    }

    override fun setStage(stage: Stage?) {
        stageMiClan = stage!!
    }

    override fun setBoton(b: Button?) {
    }


}