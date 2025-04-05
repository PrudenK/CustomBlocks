package com.pruden.tetris_2.WebSocket.CrearPartida

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.ObjsAux.JugadorInicioSesion
import com.pruden.tetris_2.Controladores.ModosDeJuego.ControladorMenuModos.Companion.cMenuModos
import com.pruden.tetris_2.Controladores.PVP.ControladorBuscarPartida.Companion.stageBuscarPartida
import com.pruden.tetris_2.Controladores.PVP.ControladorCrearPartidaPVP.Companion.stageCrearPartidaPVP
import com.pruden.tetris_2.Controladores.PVP.ControladorMenuPVP.Companion.stageMenuPVP
import com.pruden.tetris_2.Controladores.PVP.reiniciarPartidaParaPVP
import com.pruden.tetris_2.Metodos.IniciarPartida.reiniciarPartida
import com.pruden.tetris_2.WebSocket.BuscarPartida.DatosPartidaPVP
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

    fun crearPartida(jugador: JugadorInicioSesion, modo: String, opcion: String = "Crear") {
        val client = HttpClient.newHttpClient()
        val uri = URI.create("${ConstantesServidor.PATH_SERVER}${ConstantesServidor.CREAR_PARTIDA}/${jugador.id}")

        // Establecer conexión WebSocket
        client.newWebSocketBuilder().buildAsync(uri, object : WebSocket.Listener {
            override fun onOpen(webSocket: WebSocket) {
                val json = JSONObject()
                    .put("modo", modo)
                    .put("opcion", opcion)
                    .put("nombre", jugador.nombre)
                    .put("nivel", jugador.nivel)
                    .put("foto", jugador.imagen)
                    .put("creadorId", jugador.id)
                    .toString()

                webSocket.sendText(json, true)
                println("Partida creada: $json")

                CoroutineScope(Dispatchers.IO).launch {
                    delay(500)
                    //webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "done")
                    println("PARTIDA CREADA POR IDJUGADOR -> ${jugador.id}")
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
                        cMenuModos.stageMenuMundos.close()
                    }
                    CoroutineScope(Dispatchers.IO).launch { // TODO cambiar llamadas a la API en el futuro
                        val creador = ApiCustom.jugadorService.getJugadorPorId(json.getInt("creadorId"))
                        val buscador = ApiCustom.jugadorService.getJugadorPorId(json.getInt("unidorId"))

                        Platform.runLater {
                            reiniciarPartidaParaPVP(
                                DatosPartidaPVP(creador, buscador,  json.getString("modo"),
                                    json.getJSONArray("bolsa").toString()
                                )
                            )
                        }
                    }




                }
                webSocket.request(1) // Para que siga escuchando

                return CompletableFuture.completedFuture(null)
            }

        })
    }

    fun cancelarPartida(jugador: JugadorInicioSesion) {
        try {
            crearPartida(jugador, "Clásico", "cancelar")
        } catch (e: Exception) {
            println("⚠️ No se pudo cancelar: ${e.message}")
        }
    }
}
