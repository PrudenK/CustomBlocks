package com.pruden.tetris_2.WebSocket.BuscarPartida

import com.pruden.tetris_2.API.ObjsAux.JugadorInicioSesion
import com.pruden.tetris_2.WebSocket.ConstantesServidor
import kotlinx.coroutines.*
import org.json.JSONArray
import java.net.URI
import java.net.http.HttpClient
import java.net.http.WebSocket
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

object BuscarPartidaEmisor {

    interface Listener {
        fun onPartidasRecibidas(jugadores: List<JugadorConModo>)
    }

    fun buscarPartidas(jugador: JugadorInicioSesion, listener: Listener) {
        val client = HttpClient.newHttpClient()
        val uri = URI.create("${ConstantesServidor.PATH_SERVER}${ConstantesServidor.BUSCAR_PARTIDA}/${jugador.id}")

        client.newWebSocketBuilder().buildAsync(uri, object : WebSocket.Listener {

            override fun onOpen(webSocket: WebSocket) {
                webSocket.sendText("buscar", true) // Enviar algo para activar la respuesta del servidor
                webSocket.request(1)
            }

            override fun onText(webSocket: WebSocket, data: CharSequence, last: Boolean): CompletionStage<*> {
                CoroutineScope(Dispatchers.IO).launch {
                    val partidasJson = JSONArray(data.toString())
                    val listaPartidas = mutableListOf<JugadorConModo>()

                    for (i in 0 until partidasJson.length()) {
                        val partida = partidasJson.getJSONObject(i)

                        val modo = partida.getString("modo")
                        val creadorId = partida.getInt("creadorId")
                        val nombre = partida.getString("nombre")
                        val foto = partida.getString("foto")
                        val nivel = partida.getInt("nivel")

                        listaPartidas.add(JugadorConModo(creadorId, nombre, nivel, foto, modo))
                    }

                    listener.onPartidasRecibidas(listaPartidas)
                }

                return CompletableFuture.completedFuture(null)
            }
        })
    }
}
