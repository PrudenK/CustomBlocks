package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.ObjsAux.ItemClan
import com.pruden.tetris_2.API.ObjsAux.Jugador
import com.pruden.tetris_2.Controladores.ControladorGEN
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import javafx.scene.layout.Pane
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class ControladorBuscarClan: ControladorGEN(), Initializable {
    lateinit var stageBuscarClan : Stage

    @FXML lateinit var gridClanes: GridPane
    @FXML lateinit var barraBusqueda: TextField

    private var listaClanes: List<ItemClan> = emptyList()

    companion object{
        var cBuscarClan : ControladorBuscarClan? = null
    }

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        cBuscarClan = this
        cargarDatosDeLaApiALaUI()
    }

    fun cargarDatosDeLaApiALaUI(){
        CoroutineScope(Dispatchers.IO).launch {
            listaClanes = ApiCustom.clanService.getTodosLosClanes()

            javafx.application.Platform.runLater{
                cargarClanes(listaClanes)
            }
        }
    }

    private fun cargarClanes(clanes: List<ItemClan>) {
        gridClanes.children.clear()
        for ((fila, clan) in clanes.withIndex()) {
            val loader = FXMLLoader(javaClass.getResource("/com/pruden/tetris_2/Vistas/Clan/clanItem.fxml"))
            val item = loader.load<Pane>()
            val controller = loader.getController<ControladorItemClan>()
            controller.setClan(clan)

            gridClanes.add(item, 0, fila) // siempre columna 0
        }
    }


    @FXML fun filtrarClanes() {
        val texto = barraBusqueda.text.lowercase(Locale.getDefault())
        val filtrados = listaClanes.filter {
            it.nombre.lowercase(Locale.getDefault()).contains(texto)
        }
        cargarClanes(filtrados)
    }


    @FXML fun volver() = stageBuscarClan.close()

    override fun setStage(stage: Stage?) {
        stageBuscarClan = stage!!
    }

    override fun setBoton(b: Button?) {}
}