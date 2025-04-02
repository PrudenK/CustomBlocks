package com.pruden.tetris_2.WebSocket.CrearPartida

import com.pruden.tetris_2.WebSocket.ConstantesServidor
import kotlinx.coroutines.*
import org.json.JSONObject
import java.net.URI
import java.net.http.HttpClient
import java.net.http.WebSocket

object CrearPartidaEmisor {

    fun crearPartida(jugadorId: Int, modo: String) {
        val client = HttpClient.newHttpClient()
        val uri = URI.create("${ConstantesServidor.PATH_SERVER}${ConstantesServidor.CREAR_PARTIDA}/$jugadorId")

        // Establecer conexión WebSocket
        client.newWebSocketBuilder().buildAsync(uri, object : WebSocket.Listener {
            override fun onOpen(webSocket: WebSocket) {
                val json = JSONObject()
                    .put("modo", modo)
                    .toString()

                webSocket.sendText(json, true)
                println("Partida creada: $json")

                CoroutineScope(Dispatchers.IO).launch {
                    delay(500)
                    //webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "done")
                    println("PARTIDA CREADA POR IDJUGADOR -> $jugadorId")
                }

                webSocket.request(1)
            }
        })
    }
}
