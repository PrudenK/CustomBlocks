package com.pruden.tetris_2.Controladores.Clan

import com.pruden.tetris_2.API.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.API.ObjsAux.ItemClan
import com.pruden.tetris_2.Controladores.Clan.ControladorClan.Companion.idClanControlador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Metodos.Stages.ClaseStage
import com.pruden.tetris_2.Metodos.Stages.crearStage
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.Pane

class ControladorItemClan {

    @FXML lateinit var fotoPerfil: ImageView
    @FXML lateinit var nombre: Label
    @FXML lateinit var pais: Label
    @FXML lateinit var miembros: Label
    @FXML lateinit var pane: Pane

    fun setClan(clan: ItemClan){
        nombre.text = clan.nombre
        pais.text = clan.ubi
        miembros.text = "Miembros: ${clan.miembros}"
        fotoPerfil.image = Image("${ConstantesCustomAPI.PATH_CUSTOM}${clan.imagen}", true)

        pane.setOnMouseClicked {
            idClanControlador = clan.idClan
            crearStage(ClaseStage("Vistas/Clan/vistaMiClan.fxml", cPrin.nuevaPartidaB, 553.0, 668.0, null, 0, 0))
        }
    }
}