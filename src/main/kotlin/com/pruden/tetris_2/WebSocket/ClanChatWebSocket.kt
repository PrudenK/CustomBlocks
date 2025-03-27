package com.pruden.tetris_2.WebSocket

import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI

class ClanChatWebSocket(
    uri: String,
    private val onMensajeRecibido: (String) -> Unit
) : WebSocketClient(URI(uri)) {

    override fun onOpen(handshakedata: ServerHandshake?) {
        println("✅ Conectado al chat del clan")
    }

    override fun onMessage(message: String) {
        println("📥 Mensaje recibido: $message")
        onMensajeRecibido(message)
    }

    override fun onClose(code: Int, reason: String?, remote: Boolean) {
        println("❌ Desconectado: $reason")
    }

    override fun onError(ex: Exception) {
        println("⚠️ Error: ${ex.message}")
    }
}
