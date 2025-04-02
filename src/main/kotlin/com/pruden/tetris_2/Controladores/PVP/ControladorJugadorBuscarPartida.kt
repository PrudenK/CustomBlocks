package com.pruden.tetris_2.Controladores.PVP

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.Jugador
import com.pruden.tetris_2.Metodos.Media.deRutaAImagen
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ControladorJugadorBuscarPartida {
    @FXML lateinit var fotoPerfil: ImageView
    @FXML lateinit var nombre: Label
    @FXML lateinit var nivel: Label
    @FXML lateinit var modoLabel: Label

    fun setPartidaJugador(idJugador: Int, modo: String){
        CoroutineScope(Dispatchers.IO).launch {
            val jugador = ApiCustom.jugadorService.getJugadorPorId(idJugador)

            Platform.runLater {
                nombre.text = jugador.nombre
                nivel.text = "Nivel: ${jugador.nivel}"
                modoLabel.text = modo

                if(jugador.imagen != null){
                    fotoPerfil.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${jugador.imagen}", true)
                }else{
                    fotoPerfil.image = deRutaAImagen("/Imagenes/Logos/Imagen_perfil_deff.jpg")
                }
            }
        }
    }
}