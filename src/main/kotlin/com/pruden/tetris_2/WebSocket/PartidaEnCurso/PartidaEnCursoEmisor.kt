package com.pruden.tetris_2.WebSocket.PartidaEnCurso

import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.WebSocket.ConstantesServidor
import javafx.application.Platform
import org.json.JSONObject
import java.net.URI
import java.net.http.HttpClient
import java.net.http.WebSocket
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

object PartidaEnCursoEmisor {

    lateinit var socket: WebSocket

    fun iniciar(jugadorId: Int, onMensajeRecibido: (JSONObject) -> Unit) {
        val client = HttpClient.newHttpClient()
        val uri = URI.create("${ConstantesServidor.PATH_SERVER}${ConstantesServidor.PARTIDA_EN_CURSO}/$jugadorId")

        client.newWebSocketBuilder().buildAsync(uri, object : WebSocket.Listener {
            override fun onOpen(webSocket: WebSocket) {
                println("🟢 WebSocket de partida iniciado para jugador $jugadorId")
                socket = webSocket
                webSocket.request(1)
            }

            override fun onText(webSocket: WebSocket, data: CharSequence, last: Boolean): CompletionStage<*> {
                val json = JSONObject(data.toString())
                println("📥 [PartidaEnCurso] Mensaje recibido: $json")

                // Lanzamos en hilo principal si es necesario
                Platform.runLater {
                    onMensajeRecibido(json)
                }

                webSocket.request(1)
                return CompletableFuture.completedFuture(null)
            }
        })
    }

    fun enviarEstado(nivel: Int, lineas: Int, puntuacion: Int, rivalId: Int) {
        val json = JSONObject()
            .put("mensaje", "actualizarEstado")
            .put("nivel", nivel)
            .put("lineas", lineas)
            .put("puntuacion", puntuacion)
            .put("rivalId", rivalId)

        socket.sendText(json.toString(), true)
    }

    fun subirDeNivel(){
        val json = JSONObject()
            .put("mensaje", "subirDeNivel")
            .put("rivalId", ControladorPrincipal.idRivalPVP)

        socket.sendText(json.toString(), true)
    }
}
