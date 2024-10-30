package com.pruden.tetris_2.Metodos.BorrarPiezas

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BLANCO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.BORDE_TABLERO
import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.matrizNumerica
import com.pruden.tetris_2.Metodos.Matriz.pintarMatriz
import javafx.scene.control.Label

private var lineasBorradas = 0

private lateinit var lineas: Label
private lateinit var puntuacion: Label

fun borrarLinea(){
    val filaBorrar = filasQueHayQueBorrar()
    lineasBorradas += filaBorrar.size
    lineas.text = lineasBorradas.toString()
    puntuaciones(filaBorrar.size, puntuacion)

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

fun initLabelsBorrarLineas(lp : Label, ll : Label){
    lineas = ll
    puntuacion = lp
}


