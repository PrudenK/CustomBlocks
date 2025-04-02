package com.pruden.tetris_2.WebSocket.BuscarPartida

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
        fun onPartidasRecibidas(partidas: List<String>)
    }

    fun buscarPartidas(jugadorId: Int, listener: Listener) {
        val client = HttpClient.newHttpClient()
        val uri = URI.create("${ConstantesServidor.PATH_SERVER}${ConstantesServidor.BUSCAR_PARTIDA}/$jugadorId")

        client.newWebSocketBuilder().buildAsync(uri, object : WebSocket.Listener {

            override fun onOpen(webSocket: WebSocket) {
                webSocket.sendText("buscar", true) // Enviar algo para activar la respuesta del servidor
                webSocket.request(1)
            }

            override fun onText(webSocket: WebSocket, data: CharSequence, last: Boolean): CompletionStage<*> {
                CoroutineScope(Dispatchers.IO).launch {
                    val partidasJson = JSONArray(data.toString())
                    val listaPartidas = mutableListOf<String>()

                    for (i in 0 until partidasJson.length()) {
                        val partida = partidasJson.getJSONObject(i)
                        val modo = partida.getString("modo")
                        val creadorId = partida.getInt("creadorId")
                        listaPartidas.add("$creadorId@$modo")
                    }

                    listener.onPartidasRecibidas(listaPartidas)
                }

                return CompletableFuture.completedFuture(null)
            }
        })
    }
}
