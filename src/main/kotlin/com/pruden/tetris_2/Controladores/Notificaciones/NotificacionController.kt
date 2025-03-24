package com.pruden.tetris_2.Controladores.Notificaciones

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.LogroJugador
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView

class NotificacionController {
    @FXML lateinit var nombreLogro: Label
    @FXML lateinit var imagenLogro: ImageView

    fun setDatos(logro: LogroJugador) {
        nombreLogro.text = logro.titulo
        imagenLogro.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${logro.imagen}")
    }
}