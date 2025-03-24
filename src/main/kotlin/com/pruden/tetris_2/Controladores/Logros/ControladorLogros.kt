package com.pruden.tetris_2.Controladores.Logros

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.LogroJugador
import com.pruden.tetris_2.Controladores.ControladorGEN
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.layout.GridPane
import javafx.scene.layout.Pane
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorLogros: ControladorGEN(), Initializable {
    private lateinit var stageLogros : Stage

    @FXML lateinit var gridLogros: GridPane

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        val listaLogrosFicticios = listOf(
            LogroJugador(1, ConstantesCustomAPI.IMAGEN_CADENA, false, "Completa tu primer nivel", "¡Nivel 1!"),
            LogroJugador(2, ConstantesCustomAPI.IMAGEN_CADENA, false, "Alcanza 1000 puntos en una partida", "¡Milagro!"),
            LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(1, ConstantesCustomAPI.IMAGEN_CADENA, false, "Completa tu primer nivel", "¡Nivel 1!"),
            LogroJugador(2, ConstantesCustomAPI.IMAGEN_CADENA, false, "Alcanza 1000 puntos en una partida", "¡Milagro!"),
            LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),  LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"), LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),  LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"), LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),  LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"), LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),  LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"), LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),  LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"), LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),  LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"), LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),  LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"), LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),  LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"), LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),  LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"), LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),  LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"), LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),  LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"), LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),  LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"), LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),  LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"), LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),  LogroJugador(3, ConstantesCustomAPI.IMAGEN_CADENA, false, "Juega 10 partidas", "Veterano"),
            LogroJugador(8, ConstantesCustomAPI.IMAGEN_CADENA, true, "Comparte tu puntuación", "Social Gamer"),
            LogroJugador(9, ConstantesCustomAPI.IMAGEN_CADENA, false, "Encuentra el logro oculto", "Secreto Revelado")
        )
        cargarLogros(listaLogrosFicticios)
    }

    fun cargarLogros(listaLogros: List<LogroJugador>) {
        val columnas = 3
        var fila = 0
        var columna = 0

        val margin = Insets(0.0, 20.0, 0.0, 20.0) // top, right, bottom, left
        val defaultMargin = Insets(0.0, 0.0, 0.0, 0.0)

        for ((index, logro) in listaLogros.withIndex()) {
            val loader = FXMLLoader(javaClass.getResource("/com/pruden/tetris_2/Vistas/Logros/logroItem.fxml"))
            val item = loader.load<Pane>()
            val controller = loader.getController<ControladorItemLogro>()
            controller.setDataLogroJugador(logro)

            gridLogros.add(item, columna, fila)

            val insets = if (columna == 1) margin else defaultMargin
            GridPane.setMargin(item, insets)

            columna++
            if (columna == columnas) {
                columna = 0
                fila++
            }
        }
    }

    @FXML fun volver() = stageLogros.close()

    override fun setStage(stage: Stage?) {
        stageLogros = stage!!
    }

    override fun setBoton(b: Button?) {}

}