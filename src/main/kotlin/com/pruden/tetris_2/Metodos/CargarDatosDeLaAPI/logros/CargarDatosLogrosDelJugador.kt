package com.pruden.tetris_2.Metodos.CargarDatosDeLaAPI.logros

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaLogrosJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.numLineas
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.numeroLineas
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.numeroPartidasClasicas
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun cargarDatosDelJugador(){
    CoroutineScope(Dispatchers.IO).launch{
        listaLogrosJugador = ApiCustom.logroService.getLogrosDelJugador(idJugador).toMutableList()
        numeroPartidasClasicas = ApiCustom.partidaService.getNumPartidasClasicas(idJugador).body()!!
        numeroLineas = ApiCustom.partidaService.getNumLineas(idJugador)
    }
}