package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.Jugador
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView

class ControladorJugadorClan {

    @FXML lateinit var fotoPerfil: ImageView
    @FXML lateinit var imgLider: ImageView
    @FXML lateinit var nombre: Label
    @FXML lateinit var nivel: Label
    @FXML lateinit var posicion: Label

    fun setJugador(jugador: Jugador, pos: Int, idLider: Int){
        nombre.text = jugador.nombre
        nivel.text = "Nivel: ${jugador.nivel}"
        posicion.text = "#$pos"

        if(jugador.imagen != null){
            fotoPerfil.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${jugador.imagen}", true)
        }else{
            fotoPerfil.image = deRutaAImagen("/Imagenes/Logos/Imagen_perfil_deff.jpg")
        }

        if(jugador.id == idLider){
            imgLider.image = Image(ConstantesCustomAPI.IMAGEN_CORONA, true)
        }

    }
}