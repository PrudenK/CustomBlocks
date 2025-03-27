package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idClanDelJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.nombreJugador
import com.pruden.tetris_2.WebSocket.ClanChatWebSocket
import com.pruden.tetris_2.WebSocket.MensajeChat
import javafx.application.Platform
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.stage.Stage

class ControladorChatClan : ControladorGEN() {
    lateinit var stageChatClan: Stage

    @FXML lateinit var input: TextField
    @FXML lateinit var btnAceptar: Button
    @FXML lateinit var btnCancelar: Button
    @FXML lateinit var listaMensajes: ListView<MensajeChat>

    private val mensajes = FXCollections.observableArrayList<MensajeChat>()
    private lateinit var socket: ClanChatWebSocket
    private val clanId = idClanDelJugador

    override fun setStage(stage: Stage?) {
        stageChatClan = stage!!
    }

    override fun setBoton(b: Button?) {}

    @FXML
    fun initialize() {
        listaMensajes.items = mensajes

        listaMensajes.setCellFactory {
            object : ListCell<MensajeChat>() {
                override fun updateItem(item: MensajeChat?, empty: Boolean) {
                    super.updateItem(item, empty)
                    if (item == null || empty) {
                        text = null
                        graphic = null
                    } else {
                        val label = Label("${item.remitente}: ${item.texto}")
                        label.maxWidth = 350.0
                        label.isWrapText = true
                        label.style = if (item.esPropio) {
                            "-fx-background-color: #a2f5a2; -fx-padding: 10px; -fx-background-radius: 10px;"
                        } else {
                            "-fx-background-color: #e0e0e0; -fx-padding: 10px; -fx-background-radius: 10px;"
                        }

                        val hbox = HBox(label)
                        if (item.esPropio) {
                            hbox.style = "-fx-alignment: CENTER-RIGHT;"
                        } else {
                            hbox.style = "-fx-alignment: CENTER-LEFT;"
                        }

                        HBox.setHgrow(label, Priority.ALWAYS)
                        graphic = hbox
                    }
                }
            }
        }

        socket = ClanChatWebSocket("ws://localhost:8080/clan-chat/$clanId", nombreJugador) { mensaje ->
            Platform.runLater {
                mensajes.add(mensaje)
                listaMensajes.refresh()
            }
        }
        socket.connect()

        btnAceptar.setOnAction {
            val texto = input.text
            if (texto.isNotBlank()) {
                val json = """{"nombre": "$nombreJugador", "mensaje": "$texto"}"""
                socket.send(json)
                input.clear()
            }
        }

        btnCancelar.setOnAction {
            socket.close()
            stageChatClan.close()
        }
    }
}
