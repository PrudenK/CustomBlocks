package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.ItemClan
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView

class ControladorItemClan {

    @FXML lateinit var fotoPerfil: ImageView
    @FXML lateinit var nombre: Label
    @FXML lateinit var pais: Label
    @FXML lateinit var miembros: Label

    fun setClan(clan: ItemClan){
        nombre.text = clan.nombre
        pais.text = clan.ubi
        miembros.text = "Miembros: ${clan.miembros}"
        fotoPerfil.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${clan.imagen}", true)
    }
}