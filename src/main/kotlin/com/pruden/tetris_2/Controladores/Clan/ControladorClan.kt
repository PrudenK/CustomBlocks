package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAuxApi.Clan
import com.pruden.tetris_2.API.ObjsAuxApi.Jugador
import com.pruden.tetris_2.Constantes.Logros
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Metodos.DialogoAccion.mostrarDialogoConAccion
import com.pruden.tetris_2.Metodos.Logros.completarLogro
import com.pruden.tetris_2.WebSocket.ChatClan.ClanChatEmisor
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

class ControladorClan: ControladorGEN(), Initializable {
    lateinit var stageMiClan: Stage
    @FXML lateinit var gridJugadores: GridPane
    @FXML lateinit var imagen: ImageView
    @FXML lateinit var nombre: Label
    @FXML lateinit var descripcion: Label
    @FXML lateinit var miembros: Label
    @FXML lateinit var ubi: Label
    @FXML lateinit var fecha: Label
    @FXML lateinit var btnClan: Button

    private var listaJugadoresDeMiClan = mutableListOf<Jugador>()

    companion object{
        var idClanControlador = -1
    }

    private var idClanStage = -1
    private var idLiderDelClan = -1
    private lateinit var clanDelStage: Clan

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        recargarDatos()
    }

    private fun recargarDatos(){
        javafx.application.Platform.runLater {
            cargarDatosDeLaAPIAlaUI()
            cargarJugadores(listaJugadoresDeMiClan)

            if(ControladorBuscarClan.cBuscarClan != null){
                ControladorBuscarClan.cBuscarClan!!.cargarDatosDeLaApiALaUI()
            }
        }
    }

    private fun cargarJugadores(jugadores: List<Jugador>) {
        for ((fila, jugador) in jugadores.withIndex()) {
            val loader = FXMLLoader(javaClass.getResource("/com/pruden/tetris_2/Vistas/Clan/jugadorClanItenm.fxml"))
            val item = loader.load<Pane>()
            val controller = loader.getController<ControladorJugadorClan>()
            controller.setJugador(jugador, fila+1, idLiderDelClan)

            gridJugadores.add(item, 0, fila) // siempre columna 0
        }
    }

    private fun cargarDatosDeLaAPIAlaUI() {
        CoroutineScope(Dispatchers.IO).launch {

            listaJugadoresDeMiClan = ApiCustom.clanService.getJugadoresDeUnClan(idClanControlador).toMutableList()
            val clan = ApiCustom.clanService.getDatosDeUnClan(idClanControlador)
            clanDelStage = clan
            //val clan = jugadorConTodo.clan!!

            javafx.application.Platform.runLater {
                idLiderDelClan = clan.idlider
                cargarJugadores(listaJugadoresDeMiClan)
                miembros.text = "Miembros: ${listaJugadoresDeMiClan.size}"

                if(clan.imagen.isNotBlank()){
                    imagen.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${clan.imagen}")
                }else{
                    imagen.image = Image(ConstantesCustomAPI.IMAGEN_CLAN_DEFAULT)
                }



                descripcion.text = clan.descripcion
                nombre.text = clan.nombre

                btnClan.isVisible = true
                idClanStage = clan.idclan


                if(jugadorConTodo!!.clan == null){
                    btnClan.text = "Unirme"
                }else{
                    if(clan.idclan == jugadorConTodo!!.clan!!.idclan){
                        btnClan.text = "Abandonar"
                    }else{
                        btnClan.text = "Unirme"
                    }
                }

                ubi.text = "Localización: ${clan.ubicacion}"
                fecha.text = "Fundado: ${clan.fechaInit}"

            }
        }
    }

    @FXML
    fun accionClan(){
        if(btnClan.text == "Abandonar") {
            var mensaje = "¿Seguro qué quieres abandonar el clan?"
            if(clanDelStage.idlider == jugadorConTodo!!.id){
                mensaje = "Eres el lider del Clan, ¿quiéres abandonarlo?"
            }

            mostrarDialogoConAccion(
                mensaje = mensaje,
                onConfirmar = {
                    val clanAnterior = jugadorConTodo!!.clan!!
                    ClanChatEmisor.enviarMensajeClan(clanAnterior.idclan, "Server", "${jugadorConTodo!!.nombre} ha abandonado el clan")

                    jugadorConTodo!!.clan = null
                    CoroutineScope(Dispatchers.IO).launch {
                        ApiCustom.clanService.jugadorAbandonaClan(idJugador)
                        recargarDatos()
                    }

                    stageMiClan.close()
                }
            )
        }else{
            if(jugadorConTodo!!.clan == null || jugadorConTodo!!.clan!!.idclan == -1){
                jugadorConTodo!!.clan = clanDelStage
                btnClan.text = "Abandonar"

                CoroutineScope(Dispatchers.IO).launch {
                    ClanChatEmisor.enviarMensajeClan(clanDelStage.idclan, "Server", "${jugadorConTodo!!.nombre} se ha unido al clan")

                    ApiCustom.clanService.jugadorSeUneAUnClan(idClanControlador, idJugador)

                    recargarDatos()
                }

                if(!jugadorConTodo!!.listaLogros.find { it.idLogro == Logros.VIDA_SOCIAL }!!.completado){
                    completarLogro(Logros.VIDA_SOCIAL)
                }
            }else{
                var mensaje =  "Eres lider de un Clan, ¿quiéres cambiarte?"
                if(jugadorConTodo!!.clan!!.idlider != jugadorConTodo!!.id){
                    mensaje = "Ya perteneces a un Clan, ¿quiéres cambiarte?"
                }

                mostrarDialogoConAccion(
                    mensaje = mensaje,
                    onConfirmar = {
                        ClanChatEmisor.enviarMensajeClan(clanDelStage.idclan, "Server", "${jugadorConTodo!!.nombre} se ha unido al clan")
                        ClanChatEmisor.enviarMensajeClan(jugadorConTodo!!.clan!!.idclan, "Server", "${jugadorConTodo!!.nombre} ha abandonado el clan")

                        jugadorConTodo!!.clan = clanDelStage
                        btnClan.text = "Abandonar"

                        CoroutineScope(Dispatchers.IO).launch {
                            val response =  ApiCustom.clanService.jugadorSeUneAUnClan(idClanControlador, idJugador)
                            println(response)
                            recargarDatos()
                        }
                    }
                )
            }
        }
    }


    @FXML fun volver() = stageMiClan.close()


    override fun setStage(stage: Stage?) {
        stageMiClan = stage!!
    }

    override fun setBoton(b: Button?) {}
}