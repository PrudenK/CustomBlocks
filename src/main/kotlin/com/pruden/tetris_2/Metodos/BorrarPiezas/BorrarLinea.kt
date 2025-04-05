package com.pruden.tetris_2.Metodos.BorrarPiezas

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Constantes.Stages
import com.pruden.tetris_2.Controladores.ControladorPrincipal
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.eresHostPVP
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.partidaPVPenCurso
import com.pruden.tetris_2.Controladores.ModosDeJuego.PVP.ControladorTerminarPartidaPVP
import com.pruden.tetris_2.Metodos.ModosDeJuego.PVP.Resultado
import com.pruden.tetris_2.Metodos.ModosDeJuego.PVP.actualizarEstadoPVP
import com.pruden.tetris_2.Metodos.ModosDeJuego.PVP.compararJugadoresDesdeUI
import com.pruden.tetris_2.Metodos.Matriz.pintarMatriz
import com.pruden.tetris_2.Metodos.Stages.crearStage
import com.pruden.tetris_2.WebSocket.PartidaEnCurso.PartidaEnCursoEmisor

private var lineasBorradas = 0

var objLineasNivel = ""

fun borrarLinea(){
    val filaBorrar = filasQueHayQueBorrar()
    lineasBorradas += filaBorrar.size

    if(partidaPVPenCurso){
        if(eresHostPVP){
            cPrin.lineasHostLabel.text = lineasBorradas.toString()
        }else{
            cPrin.lineasVisiLabel.text = lineasBorradas.toString()
        }
    }else{
        cPrin.labelLineas.text = lineasBorradas.toString()+ objLineasNivel
    }




    puntuaciones(filaBorrar.size)

    for (i in filaBorrar.indices) {
        for (j in filaBorrar[i] downTo 0) {
            pintarMatriz(j, 0)
        }
    }

    if(partidaPVPenCurso){
        if (filaBorrar.size > 0) {
            actualizarEstadoPVP()
            // Para que cuando el usuario va perdiendo pero el otro ya ha perdido y lo supera al poner una linea
            if(ControladorPrincipal.elRivarHaPerdido){
                val resultado = compararJugadoresDesdeUI()
                println(resultado.toString())
                if(resultado == Resultado.GANA_EL_JUGADOR){
                    PartidaEnCursoEmisor.mensajeEstandar("perder")
                    ControladorTerminarPartidaPVP.resultado = "Ganas"
                    crearStage(Stages.TERMIANR_PARTIDA_PVP)
                }
            }


        }
    }
}

fun reiniciarLineasBorradas(){ lineasBorradas = 0}

private fun filasQueHayQueBorrar(): ArrayList<Int> {
    val filaBorrar = ArrayList<Int>()
    var contador0PorLinea: Int
    for (i in  matrizNumerica.indices - 1) {
        contador0PorLinea = 0
        for (j in  matrizNumerica[0].indices) {
            if (matrizNumerica[i][j] == Globales.BLANCO || matrizNumerica[i][j] == Globales.BORDE_TABLERO) {
                contador0PorLinea++
            }
        }
        if (contador0PorLinea == 0) {
            filaBorrar.add(i)
        }
    }
    return filaBorrar
}


