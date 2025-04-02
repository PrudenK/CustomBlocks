package com.pruden.tetris_2.WebSocket.Clan

import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import org.json.JSONObject
import java.net.URI

class ClanChatWebSocket(
    uri: String,
    private val nombreJugador: String,
    private val onMensajeRecibido: (MensajeChat) -> Unit
) : WebSocketClient(URI(uri)) {

    override fun onOpen(handshakedata: ServerHandshake?) {
        println("Conectado al chat del clan")
    }

    override fun onMessage(message: String) {
        println("Recibido del servidor: $message")

        try {
            val json = JSONObject(message)
            val remitente = json.getString("nombre")
            val texto = json.getString("mensaje")

            val mensaje = MensajeChat(
                remitente = remitente,
                texto = texto,
                esPropio = remitente == nombreJugador
            )

            onMensajeRecibido(mensaje)

        } catch (e: Exception) {
            println("Error al parsear JSON: ${e.message}")
        }
    }


    override fun onClose(code: Int, reason: String?, remote: Boolean) {
        println("Desconectado: $reason")
    }

    override fun onError(ex: Exception) {
        println("Error: ${ex.message}")
    }
}
