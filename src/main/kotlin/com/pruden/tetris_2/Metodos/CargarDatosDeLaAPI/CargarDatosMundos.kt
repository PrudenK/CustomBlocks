package com.pruden.tetris_2.Metodos.CargarDatosDeLaAPI

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaMundos
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun cargarDatosMundos(){
    CoroutineScope(Dispatchers.IO).launch {
        listaMundos = ApiCustom.mundoService.getAllMundos().toMutableList()
    }
}