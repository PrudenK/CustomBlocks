package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Constantes.Logros
import com.pruden.tetris_2.Controladores.ControladorGEN
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.jugadorConTodo
import com.pruden.tetris_2.Metodos.Logros.completarLogro
import com.pruden.tetris_2.WebSocket.ClanChatWebSocket
import com.pruden.tetris_2.WebSocket.ConstantesServidor
import com.pruden.tetris_2.WebSocket.MensajeChat
import javafx.application.Platform
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.image.ImageView
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ControladorChatClan : ControladorGEN() {
    lateinit var stageChatClan: Stage

    @FXML lateinit var input: TextField
    @FXML lateinit var nombre: Label
    @FXML lateinit var btnAceptar: ImageView
    @FXML lateinit var btnCancelar: Button
    @FXML lateinit var listaMensajes: ListView<MensajeChat>

    private val mensajes = FXCollections.observableArrayList<MensajeChat>()
    private lateinit var socket: ClanChatWebSocket
    private val clanId = jugadorConTodo.clan!!.idclan

    override fun setStage(stage: Stage?) {
        stageChatClan = stage!!
    }

    override fun setBoton(b: Button?) {}

    @FXML
    fun initialize() {
        listaMensajes.items = mensajes

        input.setOnAction {
            enviarMensaje()
        }

        CoroutineScope(Dispatchers.Main).launch {
            val mensajesDelClan = ApiCustom.mensajeClanService.getMensajesDeUnClan(jugadorConTodo.clan!!.idclan)

            Platform.runLater {
                mensajesDelClan.forEach { mensajeClan ->
                    val esPropio = mensajeClan.remitente == jugadorConTodo.nombre
                    val mensajeChat = MensajeChat(
                        remitente = mensajeClan.remitente,
                        texto = mensajeClan.mensaje,
                        esPropio = esPropio
                    )
                    mensajes.add(mensajeChat)
                }

                listaMensajes.refresh()

                listaMensajes.scrollTo(mensajes.size - 1)

                nombre.text = jugadorConTodo.clan!!.nombre
            }

        }


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
                            if (item.remitente == "Server") {
                                when {
                                    item.texto.contains("se ha unido al clan", ignoreCase = true) -> {
                                        "-fx-background-color: #2e7d32; -fx-padding: 10px; -fx-background-radius: 10px; -fx-font-weight: bold; -fx-text-fill: white;"
                                    }
                                    item.texto.contains("ha abandonado el clan", ignoreCase = true) -> {
                                        "-fx-background-color: #ffcdd2; -fx-padding: 10px; -fx-background-radius: 10px; -fx-font-weight: bold; -fx-text-fill: #b71c1c;"
                                    }
                                    else -> {
                                        "-fx-background-color: #e0e0e0; -fx-padding: 10px; -fx-background-radius: 10px; -fx-font-weight: normal; -fx-text-fill: black;"
                                    }
                                }
                            } else {
                                "-fx-background-color: #e0e0e0; -fx-padding: 10px; -fx-background-radius: 10px;"
                            }
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

        socket = ClanChatWebSocket("${ConstantesServidor.PATH_SERVER}${ConstantesServidor.CLAN_CHAT}/$clanId", jugadorConTodo.nombre) { mensaje ->
            Platform.runLater {
                mensajes.add(mensaje)
                listaMensajes.refresh()
                listaMensajes.scrollTo(mensajes.size - 1)
            }
        }
        socket.connect()

        btnAceptar.setOnMouseClicked {
            enviarMensaje()
        }

        btnCancelar.setOnAction {
            socket.close()
            stageChatClan.close()
        }
    }

    private fun enviarMensaje(){
        val texto = input.text
        if (texto.isNotBlank()) {
            val json = """{"nombre": "${jugadorConTodo.nombre}", "mensaje": "$texto"}"""
            socket.send(json)
            input.clear()
        }

        if(!jugadorConTodo.listaLogros.find { it.idLogro == Logros.VIDA_SOCIAL_II }!!.completado){
            completarLogro(Logros.VIDA_SOCIAL_II)
        }
    }
}
