package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Controladores.ControladorPrincipal

abstract class Piezas(open var fila: Int, open var columna: Int) : FuncionesPiezas{
    protected val matrizNumerica = ControladorPrincipal.matrizNumerica
    protected val BLANCO = ControladorPrincipal.BLANCO
    protected val CENTRO_BLANCO = ControladorPrincipal.CENTRO_BLANCO



    abstract override fun rotar(): Boolean
    override fun limpiar() {}
    override fun pintar() {}


    abstract override fun getForma(): Array<Array<IntArray>>
    abstract override fun getOrientacion(): Int
    abstract override fun getColumnaCentro(): Int
    abstract override fun getFilaCentro(): Int




}