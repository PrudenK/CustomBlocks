package com.pruden.tetris_2.Metodos.SubirDatos

import com.pruden.tetris_2.API.ObjsAux.EstaPiezas
import com.pruden.tetris_2.Constantes.Listas
import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import com.pruden.tetris_2.Piezas.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

var contadorPiezas = MutableList(Listas.NOMBRES_PIEZAS.size) { 0 }

fun sumarTipoPieza(pieza : Piezas){
    for ((indice, p) in Listas.LISTA_INSTANCIAS_PIEZAS.withIndex()){
        if (p.isInstance(pieza)){
            contadorPiezas[indice] += 1
            break
        }
    }
}

fun subirTodoEstaPiezas() {
    CoroutineScope(Dispatchers.IO).launch {
        ApiCustom.estaPiezasService.subirEstaPiezas(
            EstaPiezas(idJugador, contadorPiezas.joinToString("_"))
        )
    }
}