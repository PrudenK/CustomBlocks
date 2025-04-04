package com.pruden.tetris_2.Controladores.Logros

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.LogroJugador
import com.pruden.tetris_2.Constantes.Globales
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.Tooltip
import javafx.scene.effect.ColorAdjust
import javafx.scene.effect.GaussianBlur
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.Pane
import javafx.util.Duration

class ControladorItemLogro {
    @FXML lateinit var cadenaLogro: ImageView
    @FXML lateinit var iconoLogro: ImageView
    @FXML lateinit var tituloLogro: Label
    @FXML lateinit var pane: Pane

    fun setDataLogroJugador(logro: LogroJugador) {
        with(logro){
            iconoLogro.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}$imagen")
            tituloLogro.text = titulo


            if(!completado){
                cadenaLogro.image = Globales.CADENA
                val grayscale = ColorAdjust().apply {
                    saturation = -1.0
                }

                val blur = GaussianBlur(5.0)

                grayscale.input = blur

                iconoLogro.effect = grayscale
            }

            val tooltip = Tooltip(descripcion).apply {
                showDelay = Duration.millis(350.0)
                style = "-fx-font-size: 14px; -fx-background-color: #333; -fx-text-fill: white;"
            }

            Tooltip.install(pane, tooltip)
        }
    }
}