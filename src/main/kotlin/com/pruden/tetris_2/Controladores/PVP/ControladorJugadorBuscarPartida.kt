package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.PVP.ControladorBuscarPartida.Companion.stageBuscarPartida
import com.pruden.tetris_2.Controladores.PVP.ControladorMenuPVP.Companion.stageMenuPVP
import com.pruden.tetris_2.Metodos.DialogoAccion.mostrarDialogoConAccion
import com.pruden.tetris_2.Metodos.IniciarPartida.reiniciarPartida
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.WebSocket.ConstantesServidor
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.Pane
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.URI
import java.net.http.HttpClient
import java.net.http.WebSocket
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

class ControladorJugadorBuscarPartida {
    @FXML lateinit var fotoPerfil: ImageView
    @FXML lateinit var nombre: Label
    @FXML lateinit var nivel: Label
    @FXML lateinit var modoLabel: Label

    @FXML lateinit var paneItemBuscarPartida: Pane

    fun setPartidaJugador(idJugador: Int, modo: String){
        CoroutineScope(Dispatchers.IO).launch {
            val jugador = ApiCustom.jugadorService.getJugadorPorId(idJugador)

            Platform.runLater {
                nombre.text = jugador.nombre
                nivel.text = "Nivel: ${jugador.nivel}"
                modoLabel.text = modo

                if(jugador.imagen != null){
                    fotoPerfil.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${jugador.imagen}", true)
                }else{
                    fotoPerfil.image = deRutaAImagen("/Imagenes/Logos/Imagen_perfil_deff.jpg")
                }

                paneItemBuscarPartida.setOnMouseClicked {
                    mostrarDialogoConAccion(
                        mensaje = "¿Quiérers jugar contra\n${jugador.nombre} en modo $modo?",
                        onConfirmar = {
                            CoroutineScope(Dispatchers.IO).launch {
                                val client = HttpClient.newHttpClient()
                                val uri = URI.create("${ConstantesServidor.PATH_SERVER}/unirse-partida/${idJugador}/${jugadorConTodo!!.id}")

                                client.newWebSocketBuilder().buildAsync(uri, object : WebSocket.Listener {
                                    override fun onText(webSocket: WebSocket, data: CharSequence, last: Boolean): CompletionStage<*> {
                                        val json = JSONObject(data.toString())
                                        if (json.getString("mensaje") == "iniciarPartida") {
                                            Platform.runLater {
                                                // Cambia de escena aquí para iniciar la partida
                                                println("✅ Iniciar partida entre ${json.getInt("creadorId")} y ${json.getInt("unidorId")}")
                                                stageBuscarPartida.close()
                                                stageMenuPVP.close()

                                                reiniciarPartida()
                                            }
                                        }
                                        return CompletableFuture.completedFuture(null)
                                    }
                                })
                            }
                        }
                    )
                }
            }
        }

    }
}