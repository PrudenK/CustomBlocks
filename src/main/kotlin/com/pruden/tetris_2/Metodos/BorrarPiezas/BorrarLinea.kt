package com.pruden.tetris_2.Metodos.BorrarPiezas

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BORDE_TABLERO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.cPrin
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.Matriz.pintarMatriz

private var lineasBorradas = 0

var objLineasNivel = ""

fun borrarLinea(){
    val filaBorrar = filasQueHayQueBorrar()
    lineasBorradas += filaBorrar.size
    cPrin.labelLineas.text = lineasBorradas.toString()+ objLineasNivel
    puntuaciones(filaBorrar.size)

    for (i in filaBorrar.indices) {
        for (j in filaBorrar[i] downTo 0) {
            pintarMatriz(j, 0)
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
            if (matrizNumerica[i][j] == BLANCO || matrizNumerica[i][j] == BORDE_TABLERO) {
                contador0PorLinea++
            }
        }
        if (contador0PorLinea == 0) {
            filaBorrar.add(i)
        }
    }
    return filaBorrar
}


