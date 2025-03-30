package com.pruden.tetris_2.Metodos.ModosDeJuego.Modos

import com.pruden.tetris_2.Constantes.Listas


fun cargarPosicionesPiezasModos(posiciones : IntArray) : ArrayList<Boolean>{
    val lista = ArrayList(List(Listas.NOMBRES_PIEZAS.size) { false })
    for (pos in posiciones){
        lista[pos] = true
    }
    return lista
}