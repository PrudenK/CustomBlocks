package com.pruden.tetris_2.WebSocket.CrearPartida

import com.pruden.tetris_2.Controladores.PVP.ControladorBuscarPartida.Companion.stageBuscarPartida
import com.pruden.tetris_2.Controladores.PVP.ControladorCrearPartidaPVP.Companion.stageCrearPartidaPVP
import com.pruden.tetris_2.Controladores.PVP.ControladorMenuPVP.Companion.stageMenuPVP
import com.pruden.tetris_2.Metodos.IniciarPartida.reiniciarPartida
import com.pruden.tetris_2.WebSocket.ConstantesServidor
import javafx.application.Platform
import kotlinx.coroutines.*
import org.json.JSONObject
import java.net.URI
import java.net.http.HttpClient
import java.net.http.WebSocket
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

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

            override fun onText(webSocket: WebSocket, data: CharSequence, last: Boolean): CompletionStage<*> {
                println("📥 [CREADOR] Recibido del servidor: $data")
                val json = JSONObject(data.toString())
                if (json.has("mensaje") &&  json.optString("mensaje") == "iniciarPartida") {
                    Platform.runLater {
                        println("🎮 ¡Partida aceptada! Iniciando como creador")
                        stageCrearPartidaPVP.close()
                        stageMenuPVP.close()

                        reiniciarPartida()
                    }
                }
                webSocket.request(1) // Para que siga escuchando

                return CompletableFuture.completedFuture(null)
            }

        })
    }
}
