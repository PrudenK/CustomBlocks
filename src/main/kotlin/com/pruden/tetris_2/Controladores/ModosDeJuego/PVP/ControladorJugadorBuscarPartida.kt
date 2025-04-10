package com.pruden.tetris_2.Controladores.ModosDeJuego.PVP

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Controladores.ModosDeJuego.ControladorMenuModos.Companion.cMenuModos
import com.pruden.tetris_2.Controladores.ModosDeJuego.PVP.ControladorBuscarPartida.Companion.stageBuscarPartida
import com.pruden.tetris_2.Controladores.ModosDeJuego.PVP.ControladorMenuPVP.Companion.stageMenuPVP
import com.pruden.tetris_2.Metodos.DialogoAccion.mostrarDialogoConAccion
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import com.pruden.tetris_2.Metodos.ModosDeJuego.PVP.reiniciarPartidaParaPVP
import com.pruden.tetris_2.WebSocket.BuscarPartida.DatosPartidaPVP
import com.pruden.tetris_2.WebSocket.BuscarPartida.JugadorConModo
import com.pruden.tetris_2.WebSocket.BuscarPartida.UnirsePartidaEmisor
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

    fun setPartidaJugador(jugador: JugadorConModo){
        CoroutineScope(Dispatchers.IO).launch {
            Platform.runLater {
                nombre.text = jugador.nombre
                nivel.text = "Nivel: ${jugador.nivel}"
                modoLabel.text = jugador.modo

                if(jugador.foto != null){
                    fotoPerfil.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${jugador.foto}", true)
                }else{
                    fotoPerfil.image = deRutaAImagen("/Imagenes/Logos/Imagen_perfil_deff.jpg")
                }

                paneItemBuscarPartida.setOnMouseClicked {
                    mostrarDialogoConAccion(
                        mensaje = "¿Quiérers jugar contra\n${jugador.nombre} en modo ${jugador.modo}?",
                        onConfirmar = {
                            UnirsePartidaEmisor.conectar(jugador.id, jugadorConTodo!!.id) {
                                reiniciarPartidaParaPVP(it)
                            }
                        }
                    )
                }
            }
        }

    }
}