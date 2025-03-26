package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.Jugador
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idClanDelJugador
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
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
    @FXML lateinit var imagen: ImageView
    @FXML lateinit var nombre: Label
    @FXML lateinit var descripcion: Label
    @FXML lateinit var miembros: Label


    private var listaJugadoresDeMiClan = mutableListOf<Jugador>()

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        cargarDatosDeLaAPIAlaUI()

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

    private fun cargarDatosDeLaAPIAlaUI() {
        CoroutineScope(Dispatchers.IO).launch {

            listaJugadoresDeMiClan = ApiCustom.clanService.getJugadoresDeUnClan(idClanDelJugador).toMutableList()
            val clan = ApiCustom.clanService.getDatosDeUnClan(idClanDelJugador)

            javafx.application.Platform.runLater {
                cargarJugadores(listaJugadoresDeMiClan)
                miembros.text = "Miembros: ${listaJugadoresDeMiClan.size}"

                if(clan.imagen != null){
                    imagen.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${clan.imagen}")
                }else{
                    imagen.image = Image(ConstantesCustomAPI.IMAGEN_CLAN_DEFAULT)
                }

                descripcion.text = clan.descripcion
                nombre.text = clan.nombre
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