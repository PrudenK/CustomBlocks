package com.pruden.tetris_2.Metodos.Modos


fun cargarPosicionesPiezasModos(posiciones : IntArray) : ArrayList<Boolean>{
    val lista = ArrayList(List(32) { false })
    for (pos in posiciones){
        lista[pos] = true
    }
    return lista
}