package com.pruden.tetris_2.Controladores.Rankings

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.Jugador
import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView

class ControladorJugadorRankings {

    @FXML lateinit var fotoPerfil: ImageView
    @FXML lateinit var imgOnline: ImageView
    @FXML lateinit var imgPais: ImageView
    @FXML lateinit var nombre: Label
    @FXML lateinit var nivel: Label
    @FXML lateinit var posicion: Label
    @FXML lateinit var exp: Label

    fun setJugador(jugador: Jugador, pos: Int, global: Boolean){
        nombre.text = jugador.nombre
        nivel.text = "Nivel: ${jugador.nivel}"
        posicion.text = "#$pos"
        exp.text = "XP: ${jugador.experiencia}"

        if(jugador.imagen != null){
            fotoPerfil.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${jugador.imagen}", true)
        }else{
            fotoPerfil.image = deRutaAImagen("/Imagenes/Logos/Imagen_perfil_deff.jpg")
        }

        if(global){
            val codigo = Listas.MAPA_PAISES_SIMBOLOS_BANDERAS[jugador.pais]!!.lowercase()
            val url = "https://flagcdn.com/w80/$codigo.png"
            val image = Image(url)
            imgPais.image = image
        }


        if(jugador.online){
            imgOnline.image = Image(ConstantesCustomAPI.IMAGEN_ONLINE, true)
        }

    }

}