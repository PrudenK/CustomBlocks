package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal

abstract class Piezas(open var fila: Int, open var columna: Int, open var orientacion : Int, open var condicionEspecial_b: Boolean) : FuncionesPiezas{
    protected val matrizNumerica = ControladorPrincipal.matrizNumerica
    protected val BLANCO = Globales.BLANCO
    protected val CENTRO_BLANCO = Globales.CENTRO_BLANCO



    abstract override fun rotar(): Boolean
    override fun limpiar() {}
    override fun pintar() {}
    abstract fun clonar(): Piezas

    abstract override fun getForma(): Array<Array<IntArray>>
    abstract override fun getColumnaCentro(): Int
    abstract override fun getFilaCentro(): Int

}