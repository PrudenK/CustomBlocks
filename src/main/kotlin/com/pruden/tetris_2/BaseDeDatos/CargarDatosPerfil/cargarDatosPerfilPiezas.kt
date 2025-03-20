package com.pruden.tetris_2.BaseDeDatos.CargarDatosPerfil

import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Constantes.custom.ConstantesCustomAPI
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.Login.ControladorLogin
import com.pruden.tetris_2.Controladores.Perfil.ControladorPiezasPerfil.Companion.cPiezasPerfil
import javafx.application.Platform
import javafx.scene.control.Label
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun cargarDatosPiezasPerfil(){
    CoroutineScope(Dispatchers.IO).launch {
        val jsonObject = ApiCustom.estaPiezasService.getEstaPiezasPorJugador(idJugador)

        Platform.runLater{
            for (columna in Listas.NOMBRES_PIEZAS_Y_TOTAL){
                val label = cPiezasPerfil.stagePiezasPerfil.scene.lookup("#$columna") as Label
                label.text =  jsonObject.get(columna)?.asInt.toString() ?: "0"
            }
        }

    }
}