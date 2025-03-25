package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.API.ObjsAux.Jugador
import com.pruden.tetris_2.Controladores.ControladorGEN
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.layout.GridPane
import javafx.scene.layout.Pane
import javafx.stage.Stage
import java.net.URL
import java.util.*

class ControladorMiClan: ControladorGEN(), Initializable {
    lateinit var stageMiClan: Stage
    @FXML lateinit var gridJugadores: GridPane


    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        val listaJugadores = listOf(
            Jugador(
                id = 1,
                nombre = "Ana",
                contrasena = "1234",
                nivel = 5,
                pais = "España",
                experiencia = 1500,
                imagen = "http://localhost/uploads/ana.jpg",
                online = true
            ),
            Jugador(
                id = 2,
                nombre = "Carlos",
                contrasena = "abcd",
                nivel = 3,
                pais = "México",
                experiencia = 800,
                imagen = "http://localhost/uploads/carlos.jpg",
                online = false
            ),
            Jugador(
                id = 3,
                nombre = "Lucía",
                contrasena = "pass",
                nivel = 7,
                pais = "Argentina",
                experiencia = 2400,
                imagen = "http://localhost/uploads/lucia.jpg",
                online = true
            ),
            Jugador(
                id = 4,
                nombre = "David",
                contrasena = "secure",
                nivel = 2,
                pais = "Chile",
                experiencia = 400,
                imagen = "http://localhost/uploads/david.jpg",
                online = false
            ),Jugador(
                id = 1,
                nombre = "Ana",
                contrasena = "1234",
                nivel = 5,
                pais = "España",
                experiencia = 1500,
                imagen = "http://localhost/uploads/ana.jpg",
                online = true
            ),
            Jugador(
                id = 2,
                nombre = "Carlos",
                contrasena = "abcd",
                nivel = 3,
                pais = "México",
                experiencia = 800,
                imagen = "http://localhost/uploads/carlos.jpg",
                online = false
            ),
            Jugador(
                id = 3,
                nombre = "Lucía",
                contrasena = "pass",
                nivel = 7,
                pais = "Argentina",
                experiencia = 2400,
                imagen = "http://localhost/uploads/lucia.jpg",
                online = true
            ),
            Jugador(
                id = 4,
                nombre = "David",
                contrasena = "secure",
                nivel = 2,
                pais = "Chile",
                experiencia = 400,
                imagen = "http://localhost/uploads/david.jpg",
                online = false
            )
        )

        cargarJugadores(listaJugadores)
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

    @FXML fun volver(){
        stageMiClan.close()
    }

    override fun setStage(stage: Stage?) {
        stageMiClan = stage!!
    }

    override fun setBoton(b: Button?) {
    }


}