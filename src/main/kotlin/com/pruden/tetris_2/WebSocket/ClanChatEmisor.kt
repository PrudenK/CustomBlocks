package com.pruden.tetris_2.WebSocket

import kotlinx.coroutines.*
import org.json.JSONObject
import java.net.URI
import java.net.http.HttpClient
import java.net.http.WebSocket

object ClanChatEmisor {
    fun enviar(clanId: Int, remitente: String, mensaje: String) {
        val client = HttpClient.newHttpClient()
        val uri = URI.create("${ConstantesServidor.PATH_SERVER}${ConstantesServidor.CLAN_CHAT}/$clanId")

        client.newWebSocketBuilder().buildAsync(uri, object : WebSocket.Listener {
            override fun onOpen(webSocket: WebSocket) {
                val json = JSONObject()
                    .put("nombre", remitente)
                    .put("mensaje", mensaje)
                    .toString()

                webSocket.sendText(json, true)
                println("Mensaje enviado: $json")

                CoroutineScope(Dispatchers.IO).launch {
                    delay(500)
                    webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "done")
                }

                webSocket.request(1)
            }
        })
    }
}
