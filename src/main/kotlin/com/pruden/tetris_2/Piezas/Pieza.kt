package com.pruden.tetris_2.Piezas

import com.pruden.tetris_2.Constantes.Globales
import com.pruden.tetris_2.Controladores.ControladorPrincipal

abstract class Pieza(open var fila: Int, open var columna: Int, open var orientacion : Int, open var condicionEspecial_b: Boolean) : FuncionesAuxPiezas{
    protected val matrizNumerica = ControladorPrincipal.matrizNumerica
    protected val BLANCO = Globales.BLANCO
    protected val CENTRO_BLANCO = Globales.CENTRO_BLANCO


    abstract fun rotar(): Boolean
    abstract fun limpiar()
    abstract fun pintar()
    abstract fun clonar(): Pieza

    abstract fun bajar(): Boolean
    abstract fun derecha(): Boolean
    abstract fun izquierda(): Boolean
    abstract fun puedeRotar(nuevaOrientacion: Int) : Boolean
}