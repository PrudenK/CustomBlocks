package com.pruden.tetris_2.WebSocket.BuscarPartida

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ModosDeJuego.ControladorMenuModos.Companion.cMenuModos
import com.pruden.tetris_2.Controladores.ModosDeJuego.PVP.ControladorBuscarPartida.Companion.stageBuscarPartida
import com.pruden.tetris_2.Controladores.ModosDeJuego.PVP.ControladorMenuPVP.Companion.stageMenuPVP
import com.pruden.tetris_2.WebSocket.ConstantesServidor
import javafx.application.Platform
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.URI
import java.net.http.HttpClient
import java.net.http.WebSocket
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

object UnirsePartidaEmisor {

    fun conectar(jugadorId: Int, rivalId: Int, onPartidaIniciada: (DatosPartidaPVP) -> Unit) {
        val client = HttpClient.newHttpClient()
        val uri = URI.create("${ConstantesServidor.PATH_SERVER}/unirse-partida/$jugadorId/$rivalId")

        client.newWebSocketBuilder().buildAsync(uri, object : WebSocket.Listener {
            override fun onText(webSocket: WebSocket, data: CharSequence, last: Boolean): CompletionStage<*> {
                val future = CompletableFuture<Void>()

                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val json = JSONObject(data.toString())
                        if (json.getString("mensaje") == "iniciarPartida") {
                            Platform.runLater {
                                println("🎮 ¡Partida aceptada! Iniciando como creador")
                                stageBuscarPartida.close()
                                stageMenuPVP.close()
                                cMenuModos.stageMenuMundos.close()
                            }

                            val creador = ApiCustom.jugadorService.getJugadorPorId(json.getInt("creadorId"))
                            val buscador = ApiCustom.jugadorService.getJugadorPorId(json.getInt("unidorId"))

                            Platform.runLater {
                                val datos = DatosPartidaPVP(
                                    creador = creador,
                                    buscador = buscador,
                                    modo = json.getString("modo"),
                                    bolsa = json.getJSONArray("bolsa").toString()
                                )
                                onPartidaIniciada(datos)
                            }
                        }

                        future.complete(null)
                    } catch (e: Exception) {
                        future.completeExceptionally(e)
                    }
                }
                return future
            }
        })
    }
}
