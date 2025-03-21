package com.pruden.tetris_2.Metodos.CargarDatosDeLaAPI

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.listaSuscripciones
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun cargarSuscripciones(){
    CoroutineScope(Dispatchers.IO).launch {
        val response = ApiCustom.suscripcionService.getAllSuscripciones()
        if(response.isSuccessful){
            listaSuscripciones = response.body()!!.toMutableList()
        }else{
            println(response.code())
            println(response.message())
            println(response)
        }
    }
}