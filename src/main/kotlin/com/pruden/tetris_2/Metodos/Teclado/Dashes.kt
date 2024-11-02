package com.pruden.tetris_2.Metodos.Teclado

import com.pruden.tetris_2.Controladores.ControladorPrincipal.Companion.piezaActual

fun dashDerecha(){
    while (piezaActual.derecha()){}
}

fun dashIzquierda(){
    while (piezaActual.izquierda()){}
}