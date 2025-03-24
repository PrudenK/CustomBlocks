package com.pruden.tetris_2.Metodos.CargarDatosDeLaAPI

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaLogrosJugador
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun cargarDatosDelJugador(){
    CoroutineScope(Dispatchers.IO).launch{
        listaLogrosJugador = ApiCustom.logroService.getLogrosDelJugador(idJugador).toMutableList()
    }
}