package com.pruden.tetris_2.Controladores.Logros

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.LogroJugador
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.effect.ColorAdjust
import javafx.scene.image.Image
import javafx.scene.image.ImageView

class ControladorItemLogro {
    @FXML lateinit var cadenaLogro: ImageView
    @FXML lateinit var iconoLogro: ImageView
    @FXML lateinit var tituloLogro: Label

    fun setDataLogroJugador(logro: LogroJugador) {
        with(logro){
            iconoLogro.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}/uploads/mund1/Nivel_1_1.jpg")
            //iconoLogro.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}$imagen")
            tituloLogro.text = titulo


            if(!completado){
                cadenaLogro.image = Image(ConstantesCustomAPI.IMAGEN_CADENA, true)
                val grayscale = ColorAdjust().apply {
                    saturation = -1.0
                }
                iconoLogro.effect = grayscale
            }
        }
    }
}