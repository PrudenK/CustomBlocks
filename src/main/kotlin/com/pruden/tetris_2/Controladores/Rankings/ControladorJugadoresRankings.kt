package com.pruden.tetris_2.Controladores.Rankings

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.ObjsAuxApi.Jugador
import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Controladores.ControladorGEN
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.layout.GridPane
import javafx.scene.layout.Pane
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class ControladorJugadoresRankings: ControladorGEN(), Initializable {
    @FXML lateinit var gridJugadores: GridPane
    @FXML lateinit var comboPais: ComboBox<String>

    companion object{
        lateinit var listaTodosjugadores: MutableList<Jugador>
        lateinit var stageJugadoresRankings: Stage
    }

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        comboPais.items.add("Global")
        comboPais.items.addAll(Listas.LISTA_PAISES)
        comboPais.value = "Global"

        CoroutineScope(Dispatchers.IO).launch {
            listaTodosjugadores = ApiCustom.jugadorService.getTodosJugadores()

            Platform.runLater{
                cargarJugadores(listaTodosjugadores.sortedByDescending { it.nivel }.sortedByDescending { it.experiencia })
            }
        }

        comboPais.valueProperty().addListener { _, _, _ ->
            val lista = if(comboPais.value == "Global"){
                listaTodosjugadores.sortedByDescending { it.nivel }.sortedByDescending { it.experiencia }
            }else{
                listaTodosjugadores.filter { it.pais == comboPais.value }.sortedByDescending { it.nivel }
                    .sortedByDescending { it.experiencia }
            }

            cargarJugadores(lista)
        }
    }

    private fun cargarJugadores(jugadores: List<Jugador>) {
        gridJugadores.children.clear()
        for ((fila, jugador) in jugadores.withIndex()) {
            val loader = FXMLLoader(javaClass.getResource("/com/pruden/tetris_2/Vistas/Rankings/itemRankingJugador.fxml"))
            val item = loader.load<Pane>()
            val controller = loader.getController<ControladorJugadorRankings>()
            controller.setJugador(jugador, fila+1, comboPais.value == "Global")

            gridJugadores.add(item, 0, fila) // siempre columna 0
        }
    }


    @FXML fun volver() = stageJugadoresRankings.close()

    override fun setStage(stage: Stage?) {
        stageJugadoresRankings = stage!!
    }
    override fun setBoton(b: Button?) {}
}