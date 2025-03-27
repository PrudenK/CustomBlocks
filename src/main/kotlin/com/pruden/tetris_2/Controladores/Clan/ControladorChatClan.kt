package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idClanDelJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.nombreJugador
import com.pruden.tetris_2.WebSocket.ClanChatWebSocket
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.stage.Stage

class ControladorChatClan : ControladorGEN() {
    lateinit var stageChatClan: Stage

    @FXML lateinit var textArea: TextArea
    @FXML lateinit var input: TextField
    @FXML lateinit var btnAceptar: Button
    @FXML lateinit var btnCancelar: Button

    private lateinit var socket: ClanChatWebSocket
    private val clanId = idClanDelJugador

    override fun setStage(stage: Stage?) {
        stageChatClan = stage!!
    }

    override fun setBoton(b: Button?) {}

    @FXML
    fun initialize() {
        socket = ClanChatWebSocket("ws://localhost:8080/clan-chat/$clanId") { mensaje ->
            Platform.runLater {
                textArea.appendText("$mensaje\n")
            }
        }
        socket.connect()

        btnAceptar.setOnAction {
            val mensaje = input.text
            if (mensaje.isNotBlank()) {
                val mensajeJson = crearMensaje(nombreJugador, input.text)
                socket.send(mensajeJson)
                input.clear()

                textArea.appendText("Tú: $mensaje\n")
            }
        }

        btnCancelar.setOnAction {
            socket.close()
            stageChatClan.close()
        }
    }

    fun crearMensaje(nombre: String, texto: String): String {
        return """{"nombre": "$nombre", "mensaje": "$texto"}"""
    }
}
