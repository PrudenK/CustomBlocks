package com.pruden.tetris_2.Metodos.Comprobaciones.Login

import com.pruden.tetris_2.API.Constantes.custom.ApiCustom
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.idJugador
import kotlinx.coroutines.runBlocking

fun cerrarSesionApi(){
    if(idJugador != -1){
        runBlocking {
            try {
                ApiCustom.jugadorService.cerrarSesion(idJugador)
                println("Sesión cerrada correctamente")
            } catch (e: Exception) {
                println("Error al cerrar sesión: ${e.message}")
            }
        }
    }
}

