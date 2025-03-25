package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.Jugador
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView

class ControladorJugadorClan {

    @FXML lateinit var fotoPerfil: ImageView
    @FXML lateinit var nombre: Label
    @FXML lateinit var nivel: Label
    @FXML lateinit var posicion: Label

    fun setJugador(jugador: Jugador, pos: Int){
        nombre.text = jugador.nombre
        nivel.text = "Lv: ${jugador.nivel}"
        posicion.text = "#$pos"
        fotoPerfil.image = Image(ConstantesCustomAPI.IMAGEN_CADENA, true)
    }
}