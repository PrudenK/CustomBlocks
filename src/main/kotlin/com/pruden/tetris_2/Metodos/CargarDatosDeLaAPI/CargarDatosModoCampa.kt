package com.pruden.tetris_2.Metodos.CargarDatosDeLaAPI

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaMundos
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaMundosJugador
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaNiveles
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun cargarDatosModoCampa(){
    CoroutineScope(Dispatchers.IO).launch {
        listaMundos = ApiCustom.mundoService.getAllMundos().toMutableList()
        listaNiveles = ApiCustom.nivelService.getAllNiveles().toMutableList()
        listaMundosJugador = ApiCustom.mundoJugadorService.getMundosDelJugador(idJugador)
    }
}